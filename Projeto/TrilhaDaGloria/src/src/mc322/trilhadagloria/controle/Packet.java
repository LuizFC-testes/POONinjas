package mc322.trilhadagloria.controle;

import java.io.Serializable;

public class Packet implements Serializable {
	private static final long serialVersionUID = -3407614460412459989L;

	public int playerId;
	public String command;
	public String msg;
	public int cartaId;
	public int[] posTabuleiro;
	public String[][] tabuleiro;
	public String[] deck;
	public String[] deckInimigo;
	
}
