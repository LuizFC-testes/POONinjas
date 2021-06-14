package mc322.trilhadagloria.monarch;

import mc322.trilhadagloria.battlefield.Terreno;
import mc322.trilhadagloria.exceptions.EmptyDeckException;

public interface ICommand {
	public void comprarCarta() throws EmptyDeckException;
	
	public void enviarCemiterio(Carta c);
	
	public void invocarCarta(Carta c, Terreno t);
	
	public void sacrificarCarta(Carta c);
}
