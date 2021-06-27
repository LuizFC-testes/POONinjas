package mc322.trilhadagloria.monarch;

public class Mago extends Heroi {

	public Mago(int id, Dominio dominio) {
		super(id, dominio);
		
		forca = new int[] {80, 150};
		resistencia = new int[] {80,100};
		alcance = 1;
	}

	@Override
	public String getClasse() {
		return "Mago";
	}


	@Override
	public String getHabPass() {
		return "Não possui.";
	}


	@Override
	public String getHabAt() {
		return "Não possui.";
	}
}
