public abstract class Monstro extends Componente{
    protected int forca;
    protected int prioridade;

    Monstro(int linha, int coluna, Caverna cave, int forca) {
        prioridade = 1;
        this.linha = linha;
        this.coluna = coluna;
        this.cave = cave;
        this.forca = forca;
    }

    public int getForca() {
        return forca;
    }

    public void confrontarHeroi(Heroi h) {
        // FAZER
    }

    private void morrer() {
        cave.getSala().removerComponente(this);
    }

    private abstract void gerarEfeito();

    private abstract void anularEfeito();

    public abstract void anunciar();

    public abstract String toString();
}