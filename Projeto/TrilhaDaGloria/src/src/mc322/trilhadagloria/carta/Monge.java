package mc322.trilhadagloria.carta;

public class Monge extends Heroi {

	public Monge(int id, Dominio dominio) {
		super(id, dominio);
		
		forca = new int[] {120, 0};
		resistencia = new int[] {120,100};
		alcance = 0;
	}

	@Override
	public String getNome() {
		return "Monge";
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
