package mc322.trilhadagloria.controle;

import mc322.trilhadagloria.monarch.Carta;

public interface IControle extends IRBattle, IRCommand, IUserInput, IRState {
	public void comprarCarta();
	public void invocarCarta(Carta c);
	public void passarFase();
	public void sacrificarCarta(Carta c);
}
