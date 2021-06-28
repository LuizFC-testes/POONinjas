package mc322.trilhadagloria.serverclient;

import java.io.Serializable;

/**
 * Declara objeto utilizado na comunicação tcp
 * @author João Victor Matoso
 * @author Luiz Felipe Cezar
 */
public class Mensagem implements Serializable {
	private static final long serialVersionUID = -3407614460412459989L;

	/**** Usados na inicialização ****/
	public int playerId;
	public String[][] tabuleiro;
	public String[] deck;
	public String[] deckInimigo;
	
	/***** Usados durante o jogo *****/	
	public String command;
	public int cartaId;
	public int[] posTabuleiro;
}
