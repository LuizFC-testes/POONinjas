package mc322.damas;

public class Peca {
	/** Cor da peça */
	protected CorPeca cor;
	
	/** Posição no tabuleiro */
	protected char linha, coluna;

	Peca(CorPeca cor, char coluna, char linha){
		this.cor = cor;
		this.coluna = coluna;
		this.linha = linha;
	}
	
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

	public boolean movimentoEhPossivel(Peca[] trajetoria) {
		// Vai ser sobrescrito
		return false;
	}

	public Peca virarDama() {
		return this;
	}
	
}
