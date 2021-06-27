package mc322.trilhadagloria.monarch;

public class Warlock extends Heroi {

	public Warlock(int id, Dominio dominio) {
		super(id, dominio);
		
		forca = new int[] {110, 130};
		resistencia = new int[] {100,120};
		alcance = 1;
	}

}
