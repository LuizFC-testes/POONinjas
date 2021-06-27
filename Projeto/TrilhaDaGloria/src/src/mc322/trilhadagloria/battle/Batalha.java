package mc322.trilhadagloria.battle;

import mc322.trilhadagloria.monarch.Heroi;

public class Batalha {
	protected Heroi atacante;
	protected Heroi defensor;
	protected float bonusAtaque;
	protected float bonusDefesa;
	

	public Batalha() {
		atacante = null;
		defensor = null;
		bonusAtaque = 0;
		bonusDefesa = 0;
	}
	
	public Batalha(Heroi heroi, Heroi inimigo) {
		atacante = heroi;
		defensor = inimigo;
	}

	public Heroi batalhar() {
		if(defensor == null) {
			return null;
		}
		
		// Realiza ataque e verifica se atacante ganhou
		if(atacante.atacar(defensor, bonusAtaque, bonusDefesa)) {
			defensor.morrer();
			return defensor;
		}
		
		// Caso atacante perdeu, verifica se combate foi a distancia ou nao
		if(atacante.getTerreno() == defensor.getTerreno()) {
			atacante.morrer();
			return atacante;
		}
		
		// Caso atacante perdeu combate a distancia, ambos continuam vivos
		return null;
	}

	public boolean mesmoDefensor(Batalha b2) {
		return (b2.defensor == this.defensor);
	}
}
