package mc322.trilhadagloria.carta;

public class Clerigo extends Heroi {

	public Clerigo(int id, Dominio dominio) {
		super(id, dominio);
		
		forca = new int[] {120, 0};
		resistencia = new int[] {120,120};
		alcance = 0;
	}

	@Override
	public String getNome() {
		return "Clerigo";
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
