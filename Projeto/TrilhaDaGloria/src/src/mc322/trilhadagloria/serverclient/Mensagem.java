package mc322.trilhadagloria.serverclient;

import java.io.Serializable;

public class Mensagem implements Serializable {

	private static final long serialVersionUID = -3407614460412459989L;

	public int playerId;
	public String command;
	public String msg;
	public int cartaId;
	public int[] posTabuleiro;
	public String[][] tabuleiro;
	public String[] deck;
	public String[] deckInimigo;
	
	public Mensagem() {
		
	}
	
	public Mensagem(String string) {
		this.msg = string;
	}
	
	
}
