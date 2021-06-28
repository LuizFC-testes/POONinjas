package mc322.trilhadagloria.carta;

public class Barbaro extends Heroi {
	public Barbaro(int id, Dominio dominio) {
		super(id, dominio);
		
		forca = new int[] {130, 0};
		resistencia = new int[] {100,90};
		alcance = 0;
	}

	public String getClasse() {
		return "Barbaro";
	}

	public String getHabPass() {
		return "Não possui.";
	}

	public String getHabAt() {
		return "Não possui.";
	}

}
