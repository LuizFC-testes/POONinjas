package mc322.trilhadagloria.monarch;

public class teste {

	public static void main(String[] args) {
		Heroi h = new Barbaro(0, Dominio.AGUA);
		
		System.out.println("Barbaro instanceof Heroi " + (h instanceof Carta));
	}

}
