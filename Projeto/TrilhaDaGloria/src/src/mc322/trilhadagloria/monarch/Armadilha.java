package mc322.trilhadagloria.monarch;

public class Armadilha extends Carta {
	private boolean armada;
	private Heroi alvo;
	private int alcance;
	private Efeito efeito;
	
	public Armadilha() {
		this.preco = 1;
		armada = false;
	}
	
	public void armar(Heroi heroi) {
		alvo = heroi;
		armada = true;
		heroi.adicionarEfeito(efeito);
	}

	public boolean estaArmada() {
		return armada;
	}
	
	public int getAlcance() {
		return alcance;
	}

}
