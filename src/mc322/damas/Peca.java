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
		return this.cor;
	}

	public char getColuna() {
		return this.coluna;
	}

	public char getLinha() {
		return this.linha;
	}
	
	public void setCor(CorPeca cor) {
		this.cor = cor;
	}

	public void setColuna(char novaColuna) {
		this.coluna = novaColuna;
	}

	public void setLinha(char novaLinha) {
		this.linha = novaLinha;
	}
	
	
}
