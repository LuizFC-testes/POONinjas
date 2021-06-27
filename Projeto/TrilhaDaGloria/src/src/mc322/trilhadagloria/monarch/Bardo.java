package mc322.trilhadagloria.monarch;

import java.util.ArrayList;

import mc322.trilhadagloria.field.Terreno;

public class Bardo extends Heroi implements HabilidadeEspecial {
	ArrayList<Efeito> efeitosModificados;
	
	
	public Bardo(int id, Dominio dominio) {
		super(id, dominio);
		
		forca = new int[] {80, 80};
		resistencia = new int[] {100,100};
		alcance = 1;
		
		
		efeitosModificados = new ArrayList<Efeito>();
	}


	public void passiva() {
		for(Terreno vizinho : this.terreno.getVizinhos()) {
			
			Carta c = vizinho.getCarta(dono.getPlayerId());
			
			if(c != null && c instanceof Heroi) {
				
				Heroi h = (Heroi) c;
				
				for(Efeito ef : h.sobEfeito) {
					if(!efeitosModificados.contains(ef)) {
						efeitosModificados.add(ef);
						ef.modificarEfeito(0.1f, 0.1f);
					}
				}
			}
		}
	}
	
	@Override
	public void morrer() {
		super.morrer();
		
		for(Efeito ef : efeitosModificados) {
			ef.modificarEfeito(-0.1f, -0.1f);
		}
	}


	@Override
	public String getClasse() {
		return "Bardo";
	}


	@Override
	public String getHabPass() {
		return "Concede +10% de bonus para cada efeito aplicado nos aliados adjacentes.";
	}


	@Override
	public String getHabAt() {
		return "Não possui.";
	}
}
