package mc322.trilhadagloria.monarch;

public class Mago extends Heroi {

	public Mago(int id, Dominio dominio) {
		super(id, dominio);
		
		forca = new int[] {80, 150};
		resistencia = new int[] {80,100};
		alcance = 1;
	}

}
