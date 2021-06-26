package mc322.trilhadagloria.controle;

import mc322.trilhadagloria.battlefield.IBattle;
import mc322.trilhadagloria.monarch.Carta;
import mc322.trilhadagloria.monarch.ICommand;

public class Controle implements IControle {
	IBattle battlefield;
	ICommand player;
	ICommand inimigo;

	public void conecta(IBattle battlefield) {
		this.battlefield = battlefield;
	}

	public void conecta(ICommand monarca) {
		this.player = monarca;
	}

	@Override
	public void comprarCarta() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void invocarCarta(Carta c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void passarFase() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sacrificarCarta(Carta c) {
		// TODO Auto-generated method stub
		
	}

}
