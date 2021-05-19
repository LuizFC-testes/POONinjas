package mc322.lab06;

/**
 * @author João Victor Matoso
 * @author Luiz Felipe Cezar
 */
public abstract class Componente implements CompMovel {
	/** Linha da posição do componente */
    protected int linha;
    /** Coluna da posição do componente */
    protected int coluna;
    /** Ponteiro para a caverna que o componente está */
    protected Caverna cave;
    /** Prioridade de exibição do componente */
    protected int prioridade; // A partir de 1, e, quanto menor o número, mais alta

    /** Construtor */
    public Componente (int linha, int coluna, Caverna cave) {
        this.linha = linha;
        this.coluna = coluna;
        this.cave = cave;
        prioridadeEAdd();
    }

    /**
     * Atualiza atributo prioridade com a prioridade da classe herdeira e adiciona componente na caverna
     */
    protected abstract void prioridadeEAdd();

	/**
	 * Retorna a linha da posição atual do componente
	 */
    public int getLinha() {
        return linha;
    }

    /**
     * Retorna a coluna da posição atual do componente
     */
    public int getColuna() {
        return coluna;
    }

    /**
     * Atualiza a posição do componente
     */
    public void atualizarCoord(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
    }

    /**
     * Move o componente em uma das quatro direçãos possíveis
     * @return true se foi possível mover, false senão
     */
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

    /**
     * Retorna a prioridade de exibição do componente, menor o inteiro maior a prioridade
     */
    public int getPrioridade() {
        return prioridade;
    }

}