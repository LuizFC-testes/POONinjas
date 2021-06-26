package mc322.trilhadagloria.controle;

import mc322.trilhadagloria.battlefield.Terreno;
import mc322.trilhadagloria.monarch.Carta;

public class PacketInicial extends Packet {
	private static final long serialVersionUID = -5716136451663891976L;

	public int playerId;
	public Carta[] deckPlayer0;
	public Carta[] deckPlayer1;
	public Terreno[] tabuleiro;
	
	public PacketInicial(int playerId) {
		super("Bem vindo ao Trilha da Gloria");
		this.playerId = playerId;
	}
}
