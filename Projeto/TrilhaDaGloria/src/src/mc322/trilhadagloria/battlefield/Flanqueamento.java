package mc322.trilhadagloria.battlefield;

import java.util.ArrayList;

import mc322.trilhadagloria.monarch.Heroi;

public class Flanqueamento extends Batalha {
	ArrayList<Batalha> mesmoInimigo;
	private int numAtacantes;

	public Flanqueamento(ArrayList<Batalha> mesmoInimigo) {
		this.mesmoInimigo = mesmoInimigo;
		this.defensor = mesmoInimigo.get(0).defensor;
		numAtacantes = mesmoInimigo.size();
		
		Batalha maisForte = mesmoInimigo.get(0);
		boolean corpoACorpo = (maisForte.atacante.getTerreno() == defensor.getTerreno());
		
		for(Batalha p : mesmoInimigo) {
			// Combate corpo a corpo
			if(p.atacante.getTerreno() == defensor.getTerreno()) {
				if(corpoACorpo) {
					if(p.atacante.getForcaComBonus()[0] > maisForte.atacante.getForcaComBonus()[0]) {
						maisForte = p;
						corpoACorpo = true;
					}
				} else {
					if(p.atacante.getForcaComBonus()[0] > maisForte.atacante.getForcaComBonus()[1]) {
						maisForte = p;
						corpoACorpo = true;
					}
				}
			}
			
			// Combate a distancia
			else {
				if(corpoACorpo) {
					if(p.atacante.getForcaComBonus()[1] > maisForte.atacante.getForcaComBonus()[0]) {
						maisForte = p;
						corpoACorpo = false;
					}
				} else {
					if(p.atacante.getForcaComBonus()[1] > maisForte.atacante.getForcaComBonus()[1]) {
						maisForte = p;
						corpoACorpo = false;
					}
				}
			}
		}
		
		atacante = maisForte.atacante;
	}
	
	public Heroi batalhar() {
		if(atacante.atacar(defensor, numAtacantes)) {
			defensor.morrer();
			return defensor;
		} else {
			atacante.morrer();
			return atacante;
		}
	}
}
