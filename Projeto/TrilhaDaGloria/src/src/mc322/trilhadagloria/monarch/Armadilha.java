package mc322.trilhadagloria.monarch;

public class Armadilha extends Carta {
	protected int preco;

	public void invocar() {
		invocada = true;
	}
	
	public int getPreco() {
		return preco;
	}
}
