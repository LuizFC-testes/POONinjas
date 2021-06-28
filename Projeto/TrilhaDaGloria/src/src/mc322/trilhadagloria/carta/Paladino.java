package mc322.trilhadagloria.carta;

import java.util.ArrayList;

import mc322.trilhadagloria.field.Terreno;

public class Paladino extends Heroi {
	ArrayList<Heroi> aliadosSobEfeito;
	ArrayList<Efeito> efeitosGerados;

	public Paladino(int id, Dominio dominio) {
		super(id, dominio);
		
		forca = new int[] {120, 0};
		resistencia = new int[] {150,120};
		alcance = 0;
		
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
	
	@Override
	public String getNome() {
		return "Paladino";
	}


	@Override
	public String getHabPass() {
		return "Concede +10% de bonus para aliados adjacentes.";
	}


	@Override
	public String getHabAt() {
		return "Não possui.";
	}
}
