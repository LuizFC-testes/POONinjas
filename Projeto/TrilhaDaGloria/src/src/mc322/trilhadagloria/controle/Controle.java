package mc322.trilhadagloria.controle;

import mc322.trilhadagloria.field.IBattle;
import mc322.trilhadagloria.monarch.Carta;
import mc322.trilhadagloria.monarch.ICommand;

public class Controle implements IControle {
	IBattle battlefield;
	ICommand player;
	ICommand inimigo;

	public void conecta(IBattle battlefield) {
		this.battlefield = battlefield;
	}

	public void conectaPlayer(ICommand player) {
		this.player = player;
	}
	
	public void conectaInimigo(ICommand inimigo) {
		this.inimigo = inimigo;
	}

	public void comprarCarta() {
		
	}

	public void invocarCarta(Carta c) {

	}


	public void passarFase() {

	}


	public void sacrificarCarta(Carta c) {

	}
}
