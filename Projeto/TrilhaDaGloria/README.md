# Projeto Trilha da Glória

# Descrição Resumida do Projeto/Jogo

Trilha da Glória é um jogo épico de cartas e conquista de terrítórios de dois players. O objetivo é conquistar terrenos conectando o seu reino ao reino do inimigo. Posicione suas tropas e armadilhas para vencer o oponente. Use estratégicamente suas tropas: cada tipo de herói possui uma habilidade especial e um domínio que dão vantagens em certos tipos de terrenos.

Leia o [manual](Regras/Manual.md) para mais informações sobre as regras do jogo.

# Equipe POONinjas
* João Victor Evangelista Matoso - 176293
* Luiz Felipe Cezar - 183146

# Vídeos do Projeto

## Vídeo da Prévia
* Neste [video](assets/apresentacao-video.mp4), é apresentado a proposta do jogo, as regras e mecânicas básicas e um primeiro modelo simples da arquitetura do jogo.

## Vídeo do Jogo
* Neste [video](assets/apresentacao-final.mp4), é apresentado brevement o funcionamento do jogo.

# Slides do Projeto

## Slides da Prévia
* Este [slide](assets/apresentacao-slide.pdf) apresenta a proposta do jogo, suas regras e mecânicas básicas e um primeiro modelo simples da arquitetura do jogo.

## Slides da Apresentação Final

## Relatório de Evolução
Foram enfrentadas algumas dificuldades durante o desenvolvimento do projeto, pricipalmente na fase de design da arquitetura do jogo. Como ambos os membros tinham pouca experiência no início do projeto, foi imaginada uma arquitetura buscando atender os requisitos e a flexibilidade que o jogo propoẽ, e logo vimos que ela seria insuficiente.

Na tentativa de ajustes na arquitetura durante a fase de desenvolvimento, algumas regras da arquitetura de componentes foram quebradas. A estrutura global respeita a arquitetura Model-View-Control, porém internamente (principalmente no modelo), componentes que eram pra ser modulares acabaram tendo uma ligação forte.

Outra dificuldade enfrentada foi de lidar com conceitos novos de redes e comunicação entre máquinas, afim de desenvolver um jogo multiplayer online. Em geral, a equipe evoluiu seus conhecimentos em varias areas da computação, desde o início deste projeto.


# Destaques de Código

## Servidor
Como dito anteriormente, a equipe adquiriu muito conhecimento prático na área de redes durante o desenvolvimento desse projeto. Nesse projeto, o servidor tem o papel de gerar as cartas e o tabuleiro, e sincronizar as ações entre os dois players. Logo abaixo, está destacado a parte do código do servidor que implementa a *thread* de comunicação com o cliente

~~~java
// Thread de escuta de mensagens do cliente
public void run() {
  try {
    while(true) {
      // Aguarda comunicação do cliente
      Mensagem pkt = (Mensagem) dataIn.readObject();
      System.out.println("Player #" + playerId + ": " + pkt.command);

      // Verifica se jogo acabou
      if(pkt.command.equals("gameover")) {
        break;
      } else {
        // Encaminha pacote para o oponente
        enemy.enviarPacote(pkt);
      }
    }
  } catch(...) {
    ...
  }

  // Fim da thread. Fecha conexão com o cliente
  closeConnection();
}
~~~

## Máquina de estados
Para realizar o controle do fluxo de jogo, assim como a sincronização entre os players, foi implementado uma máquina de estados utilizando um `enum` dentro da classe `Controle`. Logo abaixo é mostrado um trecho de código desta máquina:

~~~java
// Função chamada quando usuário pressiona o botão para passar de fase
public void passarFase() {
  stm = stm.proximoEstado();

  // Sincroniza ações com o player remoto
  if(suaVez) {
    Mensagem msg = new Mensagem();
    msg.command = "passar";
    remote.enviarMensagem(msg);
  }

  switch(stm) {
  case RevelarArmadilhas:
    battle.ativarHabilidadesPassivas();
    battle.revelarArmadilhas();
    break;
  case AtivarArmadilhas:
    battle.ativarArmadilhas();
    break;
  case RevelarCombate:
    battle.gerarBatalhas((suaVez) ? playerId : inimigoId);
    break;
  case Combate:
    battle.iniciarBatalhas();
    break;
  case AguardandoCompra:
    fimDeTurno();
    suaVez = !suaVez;
    break;
  }
}
~~~

## Efeitos
O ponto mais importante do jogo Trilha da Glória é a sua flexibilidade em relação as habilidades do Heróis. Para modelar os efeitos que heróis, armadilhas (e futuramente magias) podem gerar durante o jogo, foi criado a Classe `Efeito` que descreve o bonus e a duração de um efeito sob um Heroi. Logo abaixo é mostrado o trecho de código da habilidade passiva do `Paladino`. Ele gera +10% de bonus para aliados adjacente a ele. Além disso, o efeito é eliminado quando a carta é destruída.

~~~java
public class Paladino extends Heroi {
ArrayList<Heroi> aliadosSobEfeito;
ArrayList<Efeito> efeitosGerados;
...
public void passiva() {
// Percorre terrenos vizinhos
  for(Terreno vizinho : this.terreno.getVizinhos()) {
    Carta c = vizinho.getCarta(dono.getPlayerId());

    if(c != null && c instanceof Heroi) {
      Heroi h = (Heroi) c;

      if(!aliadosSobEfeito.contains(h)) {
        aliadosSobEfeito.add(h);

        Efeito ef = new Efeito(0.1f, 0.1f, null);
        ef.aplicarEfeito(h);

        efeitosGerados.add(ef);
      }
    }
  }
}
~~~

# Destaques de Pattern
`<Destaque de patterns adotados pela equipe. Sugestão de estrutura:>`

## Diagrama do Pattern
`<Diagrama do pattern dentro do contexto da aplicação.>`

## Código do Pattern
~~~java
// Recorte do código do pattern seguindo as mesmas diretrizes de outros destaques
public void algoInteressante(…) {
   …
   trechoInteressante = 100;
}
~~~

> <Explicação de como o pattern foi adotado e quais suas vantagens, referenciando o diagrama.>

# Conclusões e Trabalhos Futuros

> <Apresente aqui as conclusões do projeto e propostas de trabalho futuro. Esta é a oportunidade em que você pode indicar melhorias no projeto a partir de lições aprendidas e conhecimentos adquiridos durante a realização do projeto, mas que não puderam ser implementadas por questões de tempo. Por exemplo, há design patterns aprendidos no final do curso que provavelmente não puderam ser implementados no jogo -- este é o espaço onde você pode apresentar como aplicaria o pattern no futuro para melhorar o jogo.>

# Documentação dos Componentes

O vídeo a seguir apresenta um detalhamento de um projeto baseado em componentes:

[![Projeto baseado em Componentes](http://img.youtube.com/vi/1LcSghlin6o/0.jpg)](https://youtu.be/1LcSghlin6o)

# Diagramas

## Diagrama Geral do Projeto
O jogo é construído seguindo a arquitetura Model-View-Control. O controle é responsável pelo fluxo e consistência do jogo. O view faz a exibição do jogo na tela, assim como captura as ações do usuário. Já o modelo é composto por dois principais componentes: o Monarch representa um player e suas tropas (cartas); e o BattleField que representa o tabuleiro com os terrenos e construções e é responsável por modelizar os combates entre as cartas invocadas.

Na figura abaixo, estes componentes estão detalhados juntos com as interfaces de comunicação.
![Diagrama geral dos principais componentes](assets/componentes2.png)

> <Apresente um diagrama geral de organização da organização do seu sistema. O formato é livre. A escolha de um ou mais estilos arquiteturais será considerado um diferencial.>

> <Faça uma breve descrição do diagrama.>

## Diagrama Geral de Componentes
Logo abaixo, está um modelo mais aprofundado do componente Monarch, responsável por modelizar o player e suas cartas.
![Diagrama do componente Monarch](assets/monarch.png)

### Exemplo 1

Este é o diagrama compondo componentes para análise:

![Diagrama Analise](diagrama-componentes-analise.png)

### Exemplo 2

Este é um diagrama inicial do projeto de jogos:

![Diagrama Jogos](diagrama-componentes-jogos.png)

### Exemplo 3

Este é outro diagrama de um projeto de vendas:

![Diagrama Vendas](diagrama-componentes-vendas.png)

Para cada componente será apresentado um documento conforme o modelo a seguir:

## Componente `<Nome do Componente>`

> <Resumo do papel do componente e serviços que ele oferece.>

![Componente](diagrama-componente.png)

**Ficha Técnica**
item | detalhamento
----- | -----
Classe | `<caminho completo da classe com pacotes>` <br> Exemplo: `pt.c08componentes.s20catalog.s10ds.DataSetComponent`
Autores | `<nome dos membros que criaram o componente>`
Interfaces | `<listagem das interfaces do componente>`

### Interfaces

Interfaces associadas a esse componente:

![Diagrama Interfaces](diagrama-interfaces.png)

Interface agregadora do componente em Java:

~~~java
public interface IDataSet extends ITableProducer, IDataSetProperties {
}
~~~

## Detalhamento das Interfaces

### Interface `<nome da interface>`

`<Resumo do papel da interface.>`

~~~
<Interface em Java.>
~~~

Método | Objetivo
-------| --------
`<id do método em Java>` | `<objetivo do método e descrição dos parâmetros>`

## Exemplo:

### Interface `ITableProducer`

Interface provida por qualquer fonte de dados que os forneça na forma de uma tabela.

~~~java
public interface ITableProducer {
  String[] requestAttributes();
  String[][] requestInstances();
}
~~~

Método | Objetivo
-------| --------
`requestAttributes` | Retorna um vetor com o nome de todos os atributos (colunas) da tabela.
`requestInstances` | Retorna uma matriz em que cada linha representa uma instância e cada coluna o valor do respectivo atributo (a ordem dos atributos é a mesma daquela fornecida por `requestAttributes`.

### Interface `IDataSetProperties`

Define o recurso (usualmente o caminho para um arquivo em disco) que é a fonte de dados.

~~~java
public interface IDataSetProperties {
  public String getDataSource();
  public void setDataSource(String dataSource);
}
~~~

Método | Objetivo
-------| --------
`getDataSource` | Retorna o caminho da fonte de dados.
`setDataSource` | Define o caminho da fonte de dados, informado através do parâmetro `dataSource`.

# Plano de Exceções

## Diagrama da hierarquia de exceções
`<Elabore um diagrama com a hierarquia de exceções como detalhado abaixo>`

![Hierarquia Exceções](exception-hierarchy.png)

## Descrição das classes de exceção

`<Monte uma tabela descritiva seguindo o exemplo>:`

Classe | Descrição
----- | -----
DivisaoInvalida | Engloba todas as exceções de divisões não aceitas.
DivisaoInutil | Indica que a divisão por 1 é inútil.
DivisaoNaoInteira | Indica uma divisão não inteira.

