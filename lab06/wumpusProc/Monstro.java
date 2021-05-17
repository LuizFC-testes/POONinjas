package wumpusProc;

public abstract class Monstro extends Componente{
    protected int forca;
    protected int saque;

    Monstro(int linha, int coluna, Caverna cave, int forca, int saque) {
        super(linha, coluna, cave);
        this.forca = forca;
        this.saque = saque;
        gerarEfeito();
    }

    protected void prioridadeEAdd() {
        this.prioridade = 1;
        this.cave.adicionarComponente(this);
    }

    public int getForca() {
        return forca;
    }

    public int confrontarHeroi(Heroi h) {
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

    protected abstract void anularEfeito();

    public abstract void anunciar();

    public abstract void mensagemDeVitoria();

    public abstract void mensagemDeMorte();

    public abstract String toString();
}