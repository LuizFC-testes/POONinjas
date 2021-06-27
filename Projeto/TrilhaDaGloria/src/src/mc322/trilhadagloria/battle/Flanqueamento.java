package mc322.trilhadagloria.battle;

import java.util.ArrayList;

public class Flanqueamento extends Batalha {

	public Flanqueamento(ArrayList<Batalha> mesmoInimigo) {
		this.defensor = mesmoInimigo.get(0).defensor;
		int numAtacantes = mesmoInimigo.size();
		
		// Extrai heroi mais forte para ser o atacante e receber o bonus
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
		
		this.bonusAtaque = 0.05f * (numAtacantes-1);
	}
}
