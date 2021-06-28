package mc322.trilhadagloria.carta;

import mc322.trilhadagloria.monarch.HabilidadeEspecial;

public class Sorcerer extends Heroi implements HabilidadeEspecial {
	Efeito efeito;
	
	
	public Sorcerer(int id, Dominio dominio) {
		super(id, dominio);
		
		forca = new int[] {100, 130};
		resistencia = new int[] {100,130};
		alcance = 2;
	}

	public void passiva() {
		if(efeito != null) {
			efeito.eliminar();
			efeito = null;
		}
		
		if(terreno.getCarta(dono.getInimigoId()) != null) {
			efeito = getEfeitoBioma();
			efeito.aplicarEfeito(this);
		}
	}

	@Override
	public String getNome() {
		return "Sorcerer";
	}


	@Override
	public String getHabPass() {
		return "Recebe o dobro de efeito de bioma.";
	}


	@Override
	public String getHabAt() {
		return "Não possui.";
	}
}
