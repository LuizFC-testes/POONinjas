package mc322.trilhadagloria.monarch;

public class Magia extends Carta{

	private int preco;
	
	public int getPreco() {
		return preco;
	}

	
	public void invocar() {
		invocada = true;
	}

}
