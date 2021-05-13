package prototipos;

import java.lang.Object;
import java.util.Random;

public abstract class Monstro extends Componente{
    protected int forca;
    protected int saque;

    Monstro(int linha, int coluna, Caverna cave, int forca, int saque) {
        super(linha, coluna, cave);
        prioridade = 1;
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

    protected abstract void anularEfeito();

    public abstract void anunciar();

    public abstract void mensagemDeVitoria();

    public abstract void mensagemDeMorte();

    public abstract String toString();
}