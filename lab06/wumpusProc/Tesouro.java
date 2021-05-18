package wumpusProc;

public abstract class Tesouro extends Componente{
    protected int valor;
    protected Tesouro proximo; //Só é usado na mochila do herói

    Tesouro(int linha, int coluna, Caverna cave, int valor) {
        super(linha, coluna, cave);
        this.valor = valor;
        this.proximo = null;
    }

    protected void prioridadeEAdd() {
        this.prioridade = 1;
        this.cave.adicionarComponente(this);
    }

    public boolean salaValida() {
        int[] dimCave = cave.dimensoesCaverna();
        boolean valida = !((linha%(dimCave[0]-1) == 0)&&(coluna%(dimCave[1]-1) == 0));
        if (!valida) {
            cave.removerComponente(this);
        }
        return valida;
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
        this.linha = -1;
        this.coluna = -1;
    }

}