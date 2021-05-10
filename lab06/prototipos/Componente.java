public class Componente {
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

    public String toString() {
        return "Superclasse";
    }

    // Protótipos Heroi

    public Flecha getFlecha() {
        return null;
    }

    public boolean flechaEquipada() {
        return false;
    }

    public Ouro getOuro() {
        return null;
    }

    public Componente[] percepcao() {
        return null;
    }

    public boolean capturarOuro() {
        return false;
    }

    public void moverHeroi(Sala s) {
        System.out.println("Superclasse");
    }

    public void disparar() {
        System.out.println("Superclasse");
    }

    public boolean confrontarWumpus() {
        return false;
    }

    // Protótipos Buraco

    public void capturarHeroi(Heroi h) {
        System.out.println("Superclasse");
    }

    // Protótipos Wumpus

    public void posicionar(Sala s) {
        System.out.println("Superclasse");
    }

    public void confrontarHeroi(Heroi h) {
        System.out.println("Superclasse");
    }
}