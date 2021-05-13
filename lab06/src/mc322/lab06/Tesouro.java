public abstract class Tesouro extends Componente{
    protected int valor;
    protected Tesouro proximo; //Só é usado na mochila do herói

    Tesouro(int linha, int coluna, Caverna cave, int valor) {
        super(linha, coluna, cave);
        this.prioridade = 1;
        this.valor = valor;
        this.proximo = null;
    }

    public int getValor() {
        return valor;
    }

    public Tesouro getProximo() {
        return proximo;
    }

    public void setProximo(Tesouro proximo) {
        this.proximo = proximo;
    }

    public void serCapturado() {
        this.linha = null;
        this.coluna = null;
    }

    public abstract void anunciar();

    public abstract String toString();
}