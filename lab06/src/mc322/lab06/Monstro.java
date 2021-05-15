package mc322.lab06;

public abstract class Monstro extends Componente{
    protected int forca;
    protected int prioridade;
    protected int saque;

    Monstro(int linha, int coluna, Caverna cave, int forca, int saque) {
    	super(linha, coluna, cave);
        prioridade = 1;
        this.linha = linha;
        this.coluna = coluna;
        this.cave = cave;
        this.forca = forca;
        this.saque = saque;
        gerarEfeito();
    }

    public int getForca() {
        return forca;
    }

    public int confrontarHeroi(Heroi h) {
        anunciar();
        if (h.confrontarMonstro(this)) {
            mensagemDeMorte();
            return morrer();
        }
        mensagemDeVitoria();
        return h.morrer();
    }

    private int morrer() {
        cave.removerComponente(this);
        anularEfeito();
        return saque;
    }

    protected abstract void gerarEfeito();

    public abstract void anularEfeito();

    public abstract void anunciar();

    public abstract void mensagemDeVitoria();

    public abstract void mensagemDeMorte();
}