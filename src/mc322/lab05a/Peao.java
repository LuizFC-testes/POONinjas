package mc322.lab05a;

/**
 * @author João Victor Matoso
 * @author Luiz Felipe Cezar
 */
public class Peao extends Peca {
	/** Construtor */	
	Peao(CorPeca cor, char coluna, char linha){
		super(cor, coluna, linha);
	}
	
	/****************** Metodos públicos *********************/
    /**
     * Retorna uma representação do peão dependendo de sua cor
     */
	public String toString() {
		if (cor == CorPeca.BRANCA) {
			return "b";
		} else {
			return "p";
		}
	}

	/**
	 * Cria uma dama com as mesmas características do peão e retorna seu ponteiro
	 * @return objeto Peca da dama criada
	 */
	public Peca virarDama() {
		Peca novaDama = new Dama(this.cor, this.coluna, this.linha);
		return novaDama;
	}

	/**
	 * Dada uma trajetoria com o caminho que uma peça passará,
	 * decide se o movimento é realizavel ou não
	 * @param trajetoria - array de peças com a trajetória do movimento
	 * @return true se é possível, false se não é possível
	 */
	public boolean movimentoEhPossivel(Peca[] trajetoria) {
		int distancia = trajetoria.length;

		// Verifica se destino da peça está livre
		if(trajetoria[distancia-1] != null) {
			return false;
		}
		
		boolean ehPossivel = true;
		
		// Verifica se existem capturas a serem feitas e se elas são válidas
		for(int i = 0; i <= distancia-2 && ehPossivel; i++) {
			// Casas pares a partir da peça
			if(i%2 == 0) {
				if(trajetoria[i] == null) {
					ehPossivel = false;
				} else if(trajetoria[i].getCor() == this.cor) {
					ehPossivel = false;
				}
			// Casas impares a partir da peça
			} else {
				if(trajetoria[i] != null) {
					ehPossivel = false;
				}
			}
		}
		
		return ehPossivel;
	}
}