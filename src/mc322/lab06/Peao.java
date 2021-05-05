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
		
		boolean ehPossivel = true;
		
		for(int i = 0; i <= distancia-2 && ehPossivel; i++) {
			if(i%2 == 0) {
				if(trajetoria[i] == null) {
					ehPossivel = false;
				} else if(trajetoria[i].getCor() == this.cor) {
					ehPossivel = false;
				}
			} else {
				if(trajetoria[i] != null) {
					ehPossivel = false;
				}
			}
		}
		
		return ehPossivel;
	}
}