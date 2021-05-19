package mc322.lab06;

/**
 * Interface para uso dos componentes na caverna
 * @author João Victor Matoso
 * @author Luiz Felipe Cezar
 */
public interface CompMovel {
	/**
	 * Retorna a linha da posição atual do componente
	 */
    public int getLinha();
    
    /**
     * Retorna a coluna da posição atual do componente
     */
    public int getColuna();
    
    /**
     * Atualiza a posição do componente
     */
    public void atualizarCoord(int linha, int coluna);
    
    /**
     * Move o componente em uma das quatro direçãos possíveis
     * @return true se foi possível mover, false senão
     */
    public boolean mover(String wasd);
    
    /**
     * Retorna a prioridade de exibição do componente, menor o inteiro maior a prioridade
     */
    public int getPrioridade();
    
    /**
     * Ação de anunciar a presença do componente no console
     */
    public void anunciar();
}