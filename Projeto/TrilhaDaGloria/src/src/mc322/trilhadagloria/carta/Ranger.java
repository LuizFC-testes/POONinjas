package mc322.trilhadagloria.carta;

public class Ranger extends Heroi {

	public Ranger(int id, Dominio dominio) {
		super(id, dominio);
		
		forca = new int[] {100, 140};
		resistencia = new int[] {100,120};
		alcance = 2;
	}
	
	@Override
	public boolean cairNaArmadilha(Armadilha armadilha, float bonusArmadilha) {
		return super.cairNaArmadilha(armadilha, bonusArmadilha-(0.3f));
	}

	@Override
	public String getClasse() {
		return "Ranger";
	}


	@Override
	public String getHabPass() {
		return "Poder das armadilhas é reduzido em 30% contra esse heroi.";
	}


	@Override
	public String getHabAt() {
		return "Não possui.";
	}
}
