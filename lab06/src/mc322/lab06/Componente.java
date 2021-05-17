package mc322.lab06;

public abstract class Componente implements CompMovel {
    protected int linha;
    protected int coluna;
    protected Caverna cave;
    protected int prioridade; // A partir de 1, e, quanto menor o número, mais alta

    public Componente (int linha, int coluna, Caverna cave) {
        this.linha = linha;
        this.coluna = coluna;
        this.cave = cave;
        prioridadeEAdd();
        //this.cave.adicionarComponente(this);
    }

    protected abstract void prioridadeEAdd();

    public int getLinha() {
        return linha;
    }

    public int getColuna() {
        return coluna;
    }

    public void atualizarCoord(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
    }

    public boolean mover(String wasd) {
        int novaLinha = linha, novaColuna = coluna;
        if (wasd.equals("w")) {
            novaLinha--;
        } else if (wasd.equals("a")) {
            novaColuna--;
        } else if (wasd.equals("s")) {
            novaLinha++;
        } else {
            //System.out.println("Aqui");
            novaColuna++;
        }
        boolean moveu = cave.moverComponente(this, novaLinha, novaColuna);
        return moveu;
    }

    public int getPrioridade() {
        return prioridade;
    }

}