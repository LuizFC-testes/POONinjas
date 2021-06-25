package mc322.trilhadagloria.battlefield;

import mc322.trilhadagloria.monarch.Armadilha;
import mc322.trilhadagloria.monarch.Carta;
import mc322.trilhadagloria.monarch.Heroi;

public class Batalha {
	protected Heroi atacante;
	protected Heroi defensor;

	public Batalha() {
		atacante = null;
		defensor = null;
	}
	
	
	public Batalha(Heroi heroi, Carta carta) {
		atacante = heroi;
		
		if(carta instanceof Armadilha) {
			Armadilha armadilha = (Armadilha) carta;
			if(!armadilha.estaArmada()) {
				armadilha.armar(heroi);
			}
		} else if(carta instanceof Heroi) {
			defensor = (Heroi) carta;
		} else {
			defensor = null;
		}
	}

	public Heroi batalhar() {
		if(defensor == null) {
			return null;
		}
		
		if(atacante.atacar(defensor)) {
			defensor.morrer();
			return defensor;
		} else {
			if(atacante.getTerreno() == defensor.getTerreno()) {
				atacante.morrer();
				return atacante;
			} else {
				return null;
			}
		}
	}

	public boolean mesmoDefensor(Batalha b2) {
		return (b2.defensor == this.defensor);
	}
}
