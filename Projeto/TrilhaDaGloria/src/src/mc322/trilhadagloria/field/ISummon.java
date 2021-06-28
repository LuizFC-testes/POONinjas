package mc322.trilhadagloria.field;

import mc322.trilhadagloria.carta.Carta;
import mc322.trilhadagloria.exceptions.GameExceptions;

public interface ISummon {
	public void invocarCarta(Carta c, Terreno t, int playerId) throws GameExceptions;

	public Terreno getTerreno(int i, int j);
}
