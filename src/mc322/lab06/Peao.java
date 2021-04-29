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
		if (distancia <= 2) {
			if (distancia == 2) {
				if (trajetoria[0] != null && trajetoria[1] == null) {
					if (trajetoria[0].getCor() != cor) {
						return true;
					}
				} else if (distancia == 1) {
					if (trajetoria[0] == null) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
}