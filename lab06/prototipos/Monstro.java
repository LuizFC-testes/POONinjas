public abstract class Monstro extends Componente{
    protected int forca;
    protected int prioridade;

    Monstro(int linha, int coluna, Caverna cave, int forca) {
        prioridade = 1;
        this.linha = linha;
        this.coluna = coluna;
        this.cave = cave;
        this.forca = forca;
        gerarEfeito();
    }

    public int getForca() {
        return forca;
    }

    public int confrontarHeroi(Heroi h) {
        if (h.confrontarMonstro()) {
            return morrer();
        }
        return h.morrer();
    }

    private int morrer() {
        cave.getSala().removerComponente(this);
        anularEfeito();
        return 500;
    }

    private abstract void gerarEfeito();

    private abstract void anularEfeito();

    public abstract void anunciar();

    public abstract String toString();
}