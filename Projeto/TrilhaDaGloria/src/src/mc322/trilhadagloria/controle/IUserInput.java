package mc322.trilhadagloria.controle;

import mc322.trilhadagloria.carta.Carta;
import mc322.trilhadagloria.field.Terreno;

public interface IUserInput {
	public void comprarCarta();
	public void invocarCarta(Carta c, Terreno t);
	public void passarFase();
	public void sacrificarCarta(Carta c);
}
