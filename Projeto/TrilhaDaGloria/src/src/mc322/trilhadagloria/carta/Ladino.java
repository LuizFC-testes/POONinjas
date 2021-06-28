package mc322.trilhadagloria.carta;

public class Ladino extends Heroi {

	public Ladino(int id, Dominio dominio) {
		super(id, dominio);
		
		forca = new int[] {100, 0};
		resistencia = new int[] {130,120};
		alcance = 0;
	}

	
	@Override
	public String getNome() {
		return "Ladino";
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
