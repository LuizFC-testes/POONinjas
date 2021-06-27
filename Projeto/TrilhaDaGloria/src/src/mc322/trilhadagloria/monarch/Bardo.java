package mc322.trilhadagloria.monarch;

import java.util.ArrayList;

import mc322.trilhadagloria.field.Terreno;

public class Bardo extends Heroi implements HabilidadeEspecial {
	ArrayList<Heroi> aliadosSobEfeito;
	ArrayList<Efeito> efeitosGerados;
	
	
	public Bardo(int id, Dominio dominio) {
		super(id, dominio);
		
		forca = new int[] {80, 80};
		resistencia = new int[] {100,100};
		alcance = 1;
		
		
		aliadosSobEfeito = new ArrayList<Heroi>();
		efeitosGerados = new ArrayList<Efeito>();
	}


	public void passiva() {
		for(Terreno vizinho : this.terreno.getVizinhos()) {
			
			Carta c = vizinho.getCarta(dono.getPlayerId());
			
			if(c != null && c instanceof Heroi) {
				
				Heroi h = (Heroi) c;
				
				if(!aliadosSobEfeito.contains(h)) {
					aliadosSobEfeito.add(h);
					
					Efeito ef = new Efeito(0.1f, 0.1f, null);
					ef.aplicarEfeito(h);
					
					efeitosGerados.add(ef);
				}
			}
		}
	}
	
	@Override
	public void morrer() {
		super.morrer();
		
		for(Efeito ef : efeitosGerados) {
			ef.eliminar();;
		}
		
	}
}
