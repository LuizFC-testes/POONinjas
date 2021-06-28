package mc322.trilhadagloria.carta;

public class Warlock extends Heroi {

	public Warlock(int id, Dominio dominio) {
		super(id, dominio);
		
		forca = new int[] {110, 130};
		resistencia = new int[] {100,120};
		alcance = 1;
	}

	@Override
	public String getClasse() {
		return "Warlock";
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
