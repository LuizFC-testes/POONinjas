# Arquivos-fonte do aplicativo

  * [Wumpus](https://github.com/LuizFC-testes/POONinjas/tree/main/lab06/src/mc322/lab06)

# Destaques do código

  * Classes Aljava e Flecha

```
public class Flecha {
	/** Status da flecha, se equipada ou não */
    boolean equipada;
    ...
```
Para facilitar o controle das flechas, em relação a estar equipada ou não
```
public class Aljava {
	/** Número de flechas disponíveis */
    private int qtdFlechas;
    
    /** Objeto flecha para armazenar estado da flecha */
    private Flecha flechaAtual;
    ...
```
Para controlar a quantidade de flechas possuídas pelo herói

  * Classes Tesouro e Monstro

```
public abstract class Monstro extends Componente{
	/** Atributo de força do monstro de 0 a 100, sendo 100 invencível */
    protected int forca;
    /** Pontos que o monstro fornece caso derrotado */
    protected int saque;
    ...
```
```
public abstract class Tesouro extends Componente{
	/** Valor do tesouro */
    protected int valor;
    /** Ponteiro para próximo tesouro / Mochila do herói utiliza uma lista ligada */
    protected Tesouro proximo;
    ...
```
Possibilitam a criação de novos tipos de inimigos com diferentes chances de vitória, e de novos tipos de tesouros com diferentes valores em pontos

  * Atributo prioridade e Interface CompMovel

```
public abstract class Componente implements CompMovel {
	  ...
    protected int prioridade;
```
Permite a criação de novos tipos de componentes com diferentes prioridades, além da modificação da prioridade dos já existentes
```
public interface CompMovel {
    ...
    public void atualizarCoord(int linha, int coluna);
    public boolean mover(String wasd);
    ...
}
```
```
public class Sala {
	/** Indica se a sala está visível ao usuário */
    private boolean visivel;
    ...
    /** Lista de componentes presenntes na sala */
    private CompMovel[] componentes;
```
   O atributo "visivel" facilita o controle da visibilidade da sala no mapa impresso no terminal  
   O array permite que seja modificado o número máximo de componentes que a sala pode abrigar, 
bem como o controle dos componentes permitidos na mesma sala, por meio das suas prioridades  
    
  * Status "vivo" do herói e "saldo" de pontos

```
public class Heroi extends Componente {
    ...
    private boolean statusVivo;
```
Facilita o controle do fluxo do jogo a cada movimento do jogador
```
public int moverHeroi(String wasd) {
        int saldo = 0;
        if (mover(wasd)) {
            saldo -= 15;    // penalidade de movimento
            ...
                saldo += m.confrontarHeroi(this);
            ...
                saldo += b.capturarHeroi(this);
            ...
                saldo += disparar();
            ...
        return saldo;
    }
```
Cada ação devolve a sua soma de pontos resultante que será passada ao jogador, as quais são acumuladas na função moverJogador,
para distribuir o gerenciamento dos pontos
