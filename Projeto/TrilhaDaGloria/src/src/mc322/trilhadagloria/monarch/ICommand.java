package mc322.trilhadagloria.monarch;

import mc322.trilhadagloria.battlefield.Terreno;
import mc322.trilhadagloria.exceptions.EmptyDeckException;
import mc322.trilhadagloria.exceptions.GameExceptions;
import mc322.trilhadagloria.exceptions.NotEnoughManaException;

public interface ICommand {
	public void comprarCarta() throws EmptyDeckException;
	
	public void enviarCemiterio(Carta c);
	
	public void invocarCarta(Carta c, Terreno t) throws NotEnoughManaException, GameExceptions;
	
	public void sacrificarCarta(Carta c);
}
