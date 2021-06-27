package mc322.trilhadagloria.controle;

import mc322.trilhadagloria.field.Terreno;
import mc322.trilhadagloria.monarch.Carta;

public interface IUserInput {
	public void comprarCarta();
	public void invocarCarta(Carta c, Terreno t);
	public void passarFase();
	public void sacrificarCarta(Carta c);
}
