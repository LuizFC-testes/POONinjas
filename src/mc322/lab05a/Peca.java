package mc322.lab05a;

/**
 * @author João Victor Matoso
 * @author Luiz Felipe Cezar
 */
public class Peca {
	/** Cor da peça */
	protected CorPeca cor;
	
	/** Posição no tabuleiro */
	protected char linha, coluna;

	/** Construtor */
	Peca(CorPeca cor, char coluna, char linha){
		this.cor = cor;
		this.coluna = coluna;
		this.linha = linha;
	}
	
	/****************** Metodos públicos *********************/
	// Propriedades
	public CorPeca getCor() {
		return cor;
	}

	public char getColuna() {
		return coluna;
	}

	public char getLinha() {
		return linha;
	}

	public void setColuna(char novaColuna) {
		this.coluna = novaColuna;
	}

	public void setLinha(char novaLinha) {
		this.linha = novaLinha;
	}

	public String toString() {
		// Vai ser sobrescrito
		return null;
	}

	/**
	 * Dada uma trajetoria com o caminho que uma peça passará,
	 * decide se o movimento é realizavel ou não
	 * @param trajetoria - array de peças com a trajetória do movimento
	 * @return true se é possível, false se não é possível
	 */
	public boolean movimentoEhPossivel(Peca[] trajetoria) {
		// Vai ser sobrescrito
		return false;
	}

	public Peca virarDama() {
		// Sobrescrito apenas para os peões
		return this;
	}
	
}
