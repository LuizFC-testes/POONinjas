public abstract class Componente {
    protected int linha;
    protected int coluna;
    protected Caverna cave;

    public Componente (int linha, int coluna, Caverna cave) {
        this.linha = linha;
        this.coluna = coluna;
        this.cave = cave;
    }

    public int getLinha() {
        return linha;
    }

    public int getColuna() {
        return coluna;
    }

    // Protótipos gerais

    public abstract String toString();

    // Protótipos Heroi

    public abstract Flecha getFlecha();

    public abstract boolean flechaEquipada();

    public abstract Ouro getOuro();

    public abstract Componente[] percepcao(); // Pode imprimir as mensagens diretamente

    public abstract boolean capturarOuro();

    public abstract void moverHeroi(Sala s);

    public abstract void disparar();

    public abstract boolean confrontarWumpus();

    // Protótipos Buraco

    public abstract void capturarHeroi(Heroi h);

    // Protótipos Wumpus

    public abstract void posicionar(Sala s);

    public abstract void confrontarHeroi(Heroi h);
}