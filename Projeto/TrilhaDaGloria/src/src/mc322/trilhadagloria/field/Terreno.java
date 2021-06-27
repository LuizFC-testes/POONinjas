package mc322.trilhadagloria.field;

import mc322.trilhadagloria.exceptions.GameExceptions;
import mc322.trilhadagloria.monarch.Carta;
import mc322.trilhadagloria.monarch.Dominio;

public class Terreno {
	private Carta cartas[];
	private Terreno vizinhos[];
	private int posicaoI;
	private int posicaoJ;
	private Bioma bioma;
	
	public Terreno(Bioma bioma) {
		cartas = new Carta[2];
		vizinhos = new Terreno[4];
		this.bioma = bioma;
	}
	
	public void setPosicao(int i, int j) {
		posicaoI = i;
		posicaoJ = j;
	}
	
	public Bioma getBioma() {
		return bioma;
	}
	
	public void invocarCarta(Carta c) throws GameExceptions {
		if(cartas[c.getDono().getPlayerId()] != null) {
			throw new GameExceptions("Player já possui uma carta invocada nesse terreno");
		} else {
			cartas[c.getDono().getPlayerId()] = c;
			c.invocar(this);
		}
	}

	public void setVizinho(int indice, Terreno t) {
		if(indice >= 0 && indice < 4) {
			vizinhos[indice] = t;
		}
	}

	public boolean temDuasCartas() {
		if(cartas[0] != null && cartas[1] != null) {
			return true;
		}
		return false;
	}

	public Terreno getVizinho(int indice) {
		return vizinhos[indice];
	}
	
	public Carta getCarta(int playerId) {
		return cartas[playerId];
	}
	
	public int distanciaAte(Terreno t) {
		return Math.abs(t.posicaoI - posicaoI) + Math.abs(t.posicaoJ - posicaoJ);
	}

	public int[] getPosicao() {
		return new int[] {posicaoI, posicaoJ};
	}

	public void setCarta(int playerId, Carta carta) {
		cartas[playerId] = carta;
	}
}
