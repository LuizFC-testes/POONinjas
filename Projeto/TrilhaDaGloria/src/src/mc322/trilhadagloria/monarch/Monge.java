package mc322.trilhadagloria.monarch;

public class Monge extends Heroi {

	public Monge(int id, Dominio dominio) {
		super(id, dominio);
		
		forca = new int[] {120, 0};
		resistencia = new int[] {120,100};
		alcance = 0;
	}

}
