package mc322.trilhadagloria.field;

import mc322.trilhadagloria.exceptions.GameExceptions;
import mc322.trilhadagloria.monarch.Carta;
import mc322.trilhadagloria.monarch.Efeito;
import mc322.trilhadagloria.monarch.Heroi;

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
	
	public void invocarCarta(Carta c, int playerId) throws GameExceptions {
		if(cartas[playerId] != null) {
			throw new GameExceptions("Player já possui uma carta invocada nesse terreno");
		} else {
			cartas[playerId] = c;
			c.invocar(this);
			
			if(c instanceof Heroi) {
				aplicarEfeitoBioma((Heroi)c);
			}
		}
	}
	
	private void aplicarEfeitoBioma(Heroi h) {
		Efeito efBioma = new Efeito(BonusDatabase.getBonusHeroi(bioma, h.getDominio()), BonusDatabase.getBonusHeroi(bioma, h.getDominio()), null);
		efBioma.aplicarEfeitoBioma(h);
	}

	public void setVizinho(int indice, Terreno t) {
		if(indice >= 0 && indice < 4) {
			vizinhos[indice] = t;
		}
	}

	public Terreno getVizinho(int indice) {
		return vizinhos[indice];
	}
	
	public Carta getCarta(int playerId) {
		return cartas[playerId];
	}

	public int[] getPosicao() {
		return new int[] {posicaoI, posicaoJ};
	}

	public void setCarta(int playerId, Carta carta) {
		cartas[playerId] = carta;
	}
}
