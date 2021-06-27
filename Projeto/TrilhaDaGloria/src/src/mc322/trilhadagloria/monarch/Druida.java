package mc322.trilhadagloria.monarch;

public class Druida extends Heroi {

	public Druida(int id, Dominio dominio) {
		super(id, dominio);
		
		forca = new int[] {100, 100};
		resistencia = new int[] {80,100};
		alcance = 1;
	}
	
	@Override
	public String getClasse() {
		return "Druida";
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
