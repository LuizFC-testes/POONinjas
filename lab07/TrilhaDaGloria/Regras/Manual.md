# Trilha da Glória - Como jogar

## Elementos

### Tabuleiro

//**[IMAGEM]**

O tabuleiro é composto por **Terrenos** quadrados, que configuram uma grade 5x5. 

* Terrenos

1. Biomas

Cada terreno possui um dos seguinte **Biomas**, sendo que cada um deles representa um **Domínio** (entre parênteses): 
```
Deserto (Terra), Floresta (Flora), Tundra (Gelo), Aquático (Água), Vulcânico (Fogo), Montanhas (Ar), Planície (Luz) e Caverna (Sombra)
```
Mais detalhes sobre **Domínios** podem ser encontrados na seção Cartas

2. Construções

Alguns terrenos podem possuir uma **Construção**. Essas construções são capazes de conferir bônus ou permitir certas ações ao jogador que tiver posse (mais detalhes na seção "Conquistando Territórios") do terreno em que elas estiverem. Mais detalhes sobre os bônus atribuídos por cada Construção podem ser encontrados no //**[Apêndice ?]**.

3. Reinos

Cada jogador possui um Reino, que é disposto no lado do tabuleiro oposto ao lado do adversário. Seu reino aparecerá na região inferior do tabuleiro.

### Deck (Baralho), Mão e Cemitério

//**[IMAGEM]**

Cada jogador possui um **Deck**, que é disposto no lado direito inferior da tela. Dele, ele obtém **Cartas** as quais utilizará para completar o objetivo (explicado na seção "Objetivo"). Cada jogador pode ver as cartas que possui na **Mão** (centro inferior da tela), que são as cartas jogáveis por ele no turno atual. No canto inferior esquerdo da tela, aparece o **Cemitério**, onde são dispostas as suas cartas que foram descartadas.

### Mana

Recurso utilizado para a realização de certas ações especiais (como algumas habilidades de Herois) e a invocação de Armadilhas e Magias. Mais detalhes são explicados na //**[SEÇÃO]**.

### Cartas

Há 3 tipos de carta: Heróis, Armadilhas e Magias

* Heróis

//**[IMAGEM]**

O principal tipo de carta do jogo. Apresentam as seguintes características:

1. Domínio

Indicado pela cor de fundo da carta. Os Domínios interagem principalmente com **Biomas**, o que resulta em bônus ou penalidades nos **Atributos** do Heroi, dependendo do Bioma ao qual ele estiver associado. Cada Domínio de Bioma tem um valor fixo de bônus ou penalidade para cada Domínio de Herói.

2. Escudo representando o seu **Reino**

3. Uma **Classe**. 

Cada Classe possui um conjunto de Domínios possíveis, além de **Atributos**-base e uma **Habilidade** única. Mais detalhes sobre cada Classe podem ser encontrados no //**[APÊNDICE]**

4. Atributos. 

São utilizados para enfrentar ou se proteger de cartas inimigas. São assim representados:
```
* //**[IMAGEM]** (Alcance) - Define a distância máxima em terrenos adjacentes que um Heroi inimigo deve estar para que este seja elegível a ser enfrentado pelo Heroi da carta
* //**[IMAGEM]** (Força) - Utilizada para enfrentar cartas (Herois ou Armadilhas) inimigas quando em situação de ataque
* //**[IMAGEM]** (Resistência) - Utilizada para enfrentar cartas inimigas quando em situação de defesa
```
Os atributos de Força e Resistência são apresentados nas cartas da seguinte forma:
```
* Fora dos parênteses: Corpo-a-corpo - Utilizada para enfrentar a carta inimiga que se encontram no mesmo terreno que a ocupada por ela
* Dentro dos parêntesees: À distância - Utilizada para enfrentar ou se defender de cartas inimigas que se encontram em terrenos diferentes do ocupado pela carta
```
Mais detalhes do funcionamento dos atributos podem ser encontrados na seção "Combate".

Layout das cartas de Heroi:

//**[IMAGEM + LEGENDAS]**

* Armadilha

São utilizadas para combater Heróis inimigos. Possuem as seguintes características:

1. //**[IMAGEM]** Poder: Utilizado para confrontar Herois. Pode sofrer um bônus ou uma penalidade, a depender do Domínio do Herói que enfrentar (mais detalhes na //**[SEÇÃO]**).

2. //**[IMAGEM]** Alcance: Funciona de maneira similar ao alcance de Heróis. É a distância máxima que um Heroi inimigo deve ser posicionado para que este acione a Armadilha.

3. Domínio: Cada armadilha com nome distinto possui um Domínio pré-determinado (podendo não ser nenhum), que pode interagir com o Domínio do Heroi que estiver combatendo de diversas formas.

4. Tipo

Pode ser "mecânica" ou "elementar". Armadilhas mecânicas não possuem Domínios, enquanto que as elementares possuem.

5. Efeito

Podem ser instantâneos ou termporários, e afetam Heróis ou Terrenos.

Layout das cartas de Armadilha:

//**[IMAGEM + LEGENDAS]**

* Magia

Pode ser jogada durante resoluções de Armadilhas e de Combates ou durante a Fase de Posicionamento, e custa 2 Mana para ser utilizada. Seus efeitos podem ser instantâneos, temporários ou permanentes. Magias só podem ser invocadas por Heróis do mesmo Reino, sendo o alcance da Magia medido a partir do Terreno em que o Herói que a invocou se encontra.

//**[IMAGEM]**

## Jogabilidade - Básico

### Objetivo do jogo

O jogador alcança a vitória cumprindo um dos requisitos:

* Formar uma um caminho de terrenos adjacentes conquistados por você que conecte o seu Reino com o Reino adversário //**[IMAGEM]**
* Ser o único com cartas jogáveis (ou seja, no Deck e na Mão) restantes

### Conquistando territórios

Há duas formas de conquistar territórios:

* Mantendo um Herói em um Terreno por 5 turnos
* Derrotando um Herói inimigo que esteja no Terreno a ser conquistado, usando um Herói controlado por você

### Início do jogo

O Campo de Batalha (tabuleiro) é gerado aleatoriamente, definindo os Biomas e Construções de cada Terreno. Esses Terrenos são inicialmente neutros, ou seja, não pertencem a nenhum dos jogadores. Cada jogador inicia o jogo com 30 cartas no total, que são criadas aleatoriamente no início do jogo, estando 5 na Mão e o restante no Deck. Além disso, cada jogador também começa com 5 Mana. Nas 30 cartas de cada jogador, estarão 20 Heróis, 5 Armadilhas e 5 Magias.

### Turnos

O fluxo do jogo é em turnos. Os turnos são divididos em três **Fases**:

1. Fase de Compra

Caso ainda hajam cartas restantes no Deck, o jogador compra a carta do topo do Deck, ou seja, a retira do Deck e a adiciona à sua Mão.

2. Fase de Sacrifício

O jogador pode optar por sacrificar uma carta (enviá-la ao cemitério) em troca de seu custo, acrescido de um em Mana. Assim, o valor de Mana recebido com o sacrifício de cada tipo de carta será:
```
Herói: 1; Armadilha: 2; Magia: 3
```

2. Fase de Posicionamento

As cartas de Herói e de Armadilha são jogadas posicionando-as em Terrenos do Campo de Batalha (invocação). Cartas de Herói não custam Mana para serem invocadas, enquanto que Armadilhas custam 1 Mana. Em um turno normal, durante a Fase de Posicionamento de seu turno, o jogador pode invocar até um Heroi e até uma Armadilha, na ordem que preferir. Assim que uma carta é invocada, um Totem (ícone) representando a carta invocada é mostrado no Terreno em que foi invocada. A carta é invocada oculta ao oponente, ou seja, seu Totem não revela a ele qual carta ela é. Para o jogador que as invocou, as cartas ficam sempre visíveis.

3. Fase de Combate

São resolvidos os acionamentos de Armadilhas e de Combates, nesta ordem. Uma Armadilha é acionada caso um Herói do Reino inimigo seja invocado após ela, dentro do seu Alcance. É então aberto um espaço para que sejam utilizadas Magias e habilidades ativas de Herois (desde que as habilidades sejam capazes de afetar um dos Heróis ao alcance da Armadilha). Os jogadores podem utilizar habilidades ativas de seus Herois e Magias de sua mão o quanto quiserem (habilidades ativas tem o limite de um uso por Fase de Combate), desde que possuam Mana suficiente para isso, e na hora que quiserem (não é necessário esperar o oponente utilizar algo para que você possa utilizar outra habilidade ou Magia). 

Assim que ambos os jogadores declararem que terminaram de utilizar suas habilidades e Magias, cada uma é resolvida seguindo a ordem da anunciada primeiro para a mais recente. Os efeitos da Armadilha são então resolvidos, e a armadilha é descartada para o Cemitério. Então, o turno segue para os eventuais combates que possam ser acionados, caso o Herói recém-invocado esteja dentro do Alcance de um Herói inimigo ou um Herói inimigo esteja dentro do seu Alcance. O combate segue então como detalhado na //**[SEÇÃO]**, sendo aberto outro espaço para a utilização de habilidades e Magias antes da sua resolução.

Assim que uma carta de Herói ou de Armadilha participa diretamente na fase de combate, essa carta é anunciada para ambos os jogadores. Caso um Heroi que não participa diretamente da Fase de Combate utilize uma habilidade ativa, ele também é revelado ao adversário. Cartas reveladas permanecem expostas no Campo de Batalha para ambos os jogadores, caso não sejam destruídas.

### Combate

O Reino da carta de Heroi recém-posicionada é o **Reino atacante**, enquanto que seu adversário é o **Reino defensor**. Cartas atacantes que estiverem envolvidas no combate utilizam sua **Força** contra a **Resistência** das defensoras. Cada confronto é realizado entre dois Heróis inimigos por vez. Caso o confronto da vez seja realizado entre dois Heróis que não estejam no mesmo Terreno, é realizado então um confronto à distância, e seus Atributos à distância são utilizados contra o oponente. Caso se encontrem no mesmo Terreno, são utilizados os seus respectivos Atributos corpo-a-corpo. O Herói que possuir o maior valor do seu respectivo Atributo utilizado, vence o confronto. Caso haja empate nesses valores, a vitória é do Reino defensor.

Apenas Heróis capazes de visualizar o adversário do Combate (o possuírem dentro de seu Alcance) são capazes de tentar infligi-lo dano. Caso não consigam visualizar o oponente, são capazes apenas de bloquearem a investida inimiga. Nesse caso, ao vencer o confronto, o Herói não morre (não é enviado ao Cemitério), mas não é capaz de matar o oponente. Caso o Herói alcance o oponente e vença o confronto, o oponente é enviado ao Cemitério e o Terreno em que estava é conquistado pelo Reino vitorioso, mesmo se o Terreno já tiver sido conquistado previamente pelo oponente. Apenas um Reino pode ter posse de cada Terreno por vez, ou seja, caso um jogador conquiste um Terreno adversário, ele o toma para si.
Para a resolução de combates e Armadilhas, os bônus aplicáveis aos Heróis são cumulativos e se somam, por exemplo:
```
Caso um Herói sofra um efeito que lhe dê 10% de bônus, outro que dê 5% de bônus e mais um que dê 10% de penalidade, o total de bônus que ele receberá é 5%.
Da mesma forma, caso ele sofra efeitos de +10%, +5% e -20%, ele sofre uma penalidade de 5%
```
O bônus ou a penalidade total aplicada ao Herói é referente aos seus Atributos, incrementando-os ou descontando de seu valor. Por exemplo:
```
Um Atributo de valor 100 com bônus total de 10% passa a ter valor 110, enquanto que, ao sofrer uma penalidade total de 10%, passa a ter valor 90.
```
O mesmo se aplica para o Poder de Armadilhas.

## Jogabilidade - Avançado

### Flanqueamentos

Quando há mais de um Herói capaz de alcançar um Herói inimigo participante de um Combate, ocorre Flanqueamento. Em um Flanqueamento, para cada Herói "excedente" (ou seja, além de um) que alcançar o mesmo Herói adversário, será aplicado 5% de bônus ao aliado que estiver participando do confronto, ao longo de sua duração. Há duas categorias de Flanqueamento:
* Flanqueamento simples: Há apenas um Herói de um Reino contra vários Heróis do Reino inimigo.

//**[IMAGEM]**

Nesse caso, o Herói flanqueador com o maior valor do respectivo Atributo utilizado (**Força**, para atacantes, e **Resistência**, para defensores) dentre seus aliados participará do confronto contra o Herói inimigo, e os bônus são aplicados a ele. Caso o Herói da equipe flanqueadora não derrote o inimigo, é realizado um novo confronto entre o Herói flanqueado e o flanqueador com o segundo maior Atributo utilizado, prosseguindo para os próximos Heróis flanqueadores em ordem decrescente de valor do Atributo utilizado, caso seja necessário (caso o Herói flanqueado continue sobrevivendo aos confrontos dos flanqueadores), recalculando os bônus de Flanqueamento a cada confronto, de acordo com a quantidade de flanqueadores restante (que diminui ou não, dependendo se o flanqueador do confronto anterior foi morto ou não). O progresso e os resultados desses confrontos seguem da mesma forma que os combates comuns, ou seja, com o espaço para a utilização de habilidades ativas e Magias, bem como a conquista de Terrenos pelo Reino vitorioso em cada confronto.
* Flanqueamento em equipes: Quando, na mesma fase de combate, há Heróis flanqueando e sofrendo flanqueamento ao mesmo tempo. //**[REVISAR]**

//**[IMAGEM]**

Nesse caso, é verificado qual o flanqueamento mais forte, ou seja, aquele que possui mais Heróis flanqueadores para um Herói flanqueado, para ter a prioridade. Em caso de empate nesse quesito, um Flanqueamento dos defensores será priorizado. Caso o mesmo Reino possua mais de um Flanqueamento apto a receber a prioridade, o priorizado será aquele que possuir o Herói cujo Atributo utilizado é o mais forte, dentre os Flanqueamentos empatados. Assim que o Flanqueamento corrente é definido, o confronto é realizado da mesma forma que no Flanqueamento Simples. Entretanto, após cada confronto, é verificado o próximo Flanqueamento a ser considerado, da mesma forma, até que cada Flanqueamento seja completamente resolvido (sem necessariamente uma das equipes ser completamente derrotada). Caso algum confronto não resulte em nenhuma morte, é seguida a sequência de um Flanqueamento Simples, até que haja alguma morte ou que esse Flanqueamento seja completamente resolvido. Caso haja um Flanqueamento resolvido sem nenhuma morte, se inicia a resolução do próximo Flanqueamento na fila de prioridade.

