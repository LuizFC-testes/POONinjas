package mc322.trilhadagloria.field;

import mc322.trilhadagloria.exceptions.GameExceptions;
import mc322.trilhadagloria.monarch.Carta;

public interface ISummon {
	public void invocarCarta(Carta c, Terreno t) throws GameExceptions;
}