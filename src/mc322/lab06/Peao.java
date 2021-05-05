package mc322.lab06;

public class Peao extends Peca {
	// Ponteiros para vizinhos 
	
	Peao(CorPeca cor, char coluna, char linha){
		super(cor, coluna, linha);
	}
	
	public String toString() {
		if (cor == CorPeca.BRANCA) {
			return "b";
		} else {
			return "p";
		}
	}

	public Peca virarDama() {
		Peca novaDama = new Dama(this.cor, this.coluna, this.linha);
		return novaDama;
	}

	public boolean movimentoEhPossivel(Peca[] trajetoria) {
		int distancia = trajetoria.length;

		if(trajetoria[distancia-1] != null) {
			return false;
		}
		
		boolean captura = true;
		boolean ehPossivel = true;
		
		for(int i = distancia-2; i >= 0 && ehPossivel; i--) {
			if(captura) {
				if(trajetoria[i] == null) {
					ehPossivel = false;
				}
				captura = false;
			} else {
				if(trajetoria[i] != null && trajetoria[i].getCor() != this.cor) {
					ehPossivel = false;
				}
				captura = true;
			}
		}
		
		return ehPossivel;
	}
}