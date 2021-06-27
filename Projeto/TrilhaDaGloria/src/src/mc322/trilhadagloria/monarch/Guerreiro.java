package mc322.trilhadagloria.monarch;

public class Guerreiro extends Heroi implements HabilidadeEspecial {
	Efeito bonusTerritorio;
	
	public Guerreiro(int id, Dominio dominio) {
		super(id, dominio);
		
		forca = new int[] {120, 0};
		resistencia = new int[] {120,120};
		alcance = 0;
	}

	@Override
	public void passiva() {
		if(bonusTerritorio != null) {
			bonusTerritorio.eliminar();
		}
		
		float bonus = 0.1f * dono.getQtdTerritoriosConquistados();
		
		if(bonus > 0.5)
			bonus = 0.5f;
		
		bonusTerritorio = new Efeito(bonus, bonus, null);
	}

}
