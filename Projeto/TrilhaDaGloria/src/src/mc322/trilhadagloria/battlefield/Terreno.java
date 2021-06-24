package mc322.trilhadagloria.battlefield;

import mc322.trilhadagloria.exceptions.GameExceptions;
import mc322.trilhadagloria.monarch.Carta;
import mc322.trilhadagloria.monarch.Dominio;

public abstract class Terreno {
	private Carta cartas[];
	private Terreno vizinhos[];
	
	public Terreno() {
		cartas = new Carta[2];
		vizinhos = new Terreno[4];
	}
	
	public abstract float getBonus(Dominio d);
	
	public void invocarCarta(Carta c) throws GameExceptions {
		if(cartas[c.getDono().getPlayerId()] != null) {
			throw new GameExceptions("Player já possui uma carta invocada nesse terreno");
		} else {
			cartas[c.getDono().getPlayerId()] = c;
			c.invocar(this);
		}
	}
	
}
