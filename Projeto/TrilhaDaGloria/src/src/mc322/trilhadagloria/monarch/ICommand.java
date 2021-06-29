package mc322.trilhadagloria.monarch;

import mc322.trilhadagloria.carta.Carta;
import mc322.trilhadagloria.exceptions.EmptyDeckException;
import mc322.trilhadagloria.exceptions.GameExceptions;
import mc322.trilhadagloria.exceptions.NotEnoughManaException;
import mc322.trilhadagloria.field.Terreno;

public interface ICommand {
	public void comprarCarta() throws EmptyDeckException;
	
	public void enviarCemiterio(Carta c);
	
	public void invocarCarta(Carta c, Terreno t) throws NotEnoughManaException, GameExceptions;
	
	public void sacrificarCarta(Carta c);

	public void sacrificarCarta(int cartaId);

	public void invocarCarta(int cartaId, int[] posTabuleiro) throws NotEnoughManaException, GameExceptions;

	public void mostrarDeck();

	public void mostrarMao();
}
