package mc322.trilhadagloria.controle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import mc322.trilhadagloria.battlefield.Tabuleiro;
import mc322.trilhadagloria.monarch.Dominio;

public class GeradorServer {
	private static int cartaId = 0;
	
	private String[] deckPlayer0;
	private String[] deckPlayer1;
	private String[][] tabuleiro;
	
	
	public GeradorServer() {
		// Gerar decks
		deckPlayer0 = gerarDeck(30,0,0);
		deckPlayer1 = gerarDeck(30,0,0);
		
		// Gerar terrenos
		tabuleiro = new String[Tabuleiro.MAPSIZE][Tabuleiro.MAPSIZE];
		
		for(int i = 0; i < Tabuleiro.MAPSIZE; i++) {
			for(int j = 0; j < Tabuleiro.MAPSIZE; j++) {
				tabuleiro[i][j] = gerarTerreno();
			}
		}
	}
	
	/**
	 * Gerador de Deck
	 * @param nHerois - número de cartas do tipo Heroi
	 * @param nMagias - número de cartas do tipo Magia
	 * @param nArmadilhas - número de cartas do tipo Armadilha
	 * @return ArrayList de cartas geradas aleatoriamente conforme especificado 
	 */
	private String[] gerarDeck(int nHerois, int nMagias, int nArmadilhas) {
		ArrayList<String> deck = new ArrayList<String>();
		
		for(int i = 0; i < nHerois; i++) {
			deck.add(gerarHeroi());
		}
		for(int i = 0; i < nMagias; i++) {
			deck.add(gerarMagia());
		}
		for(int i = 0; i < nArmadilhas; i++) {
			deck.add(gerarArmadilha());
		}
		
		Collections.shuffle(deck);
		
		String[] array = new String[deck.size()];
		
		array = deck.toArray(array);
		
		return array;
	}
	
	/**
	 * Gera aleatoriamente um objeto do tipo Heroi. Os Herois possuem probabilidade iguais de geração.
	 * @return  objeto do tipo Carta/Heroi
	 */
	private String gerarHeroi() {
		Random rnd = new Random();
		String s = cartaId + ";";
		cartaId++;
		
		// Escolhe um dominio aleatório
		Dominio dom = Dominio.values()[rnd.nextInt(Dominio.values().length)];
		
		switch(rnd.nextInt(12)) {
		case 0:
			return s+"warlock;" + dom.toString() + ";";
		case 1:
			return s+"bardo;" + dom.toString() + ";";
		case 2:
			return s+"clerigo;" + dom.toString() + ";";
		case 3:
			return s+"druida;" + dom.toString() + ";";
		case 4:
			return s+"guerreiro;" + dom.toString() + ";";
		case 5:
			return s+"ladino;" + dom.toString() + ";";
		case 6:
			return s+"mago;" + dom.toString() + ";";
		case 7:
			return s+"monge;" + dom.toString() + ";";
		case 8:
			return s+"paladino;" + dom.toString() + ";";
		case 9:
			return s+"ranger;" + dom.toString() + ";";
		case 10:
			return s+"sorcerer;" + dom.toString() + ";";
		default:
			return s+"barbaro;" + dom.toString() + ";";
		}
	}
	
	private String gerarMagia() {
		String s = cartaId + ";";
		cartaId++;
		return s+"magia;";
	}
	
	private String gerarArmadilha() {
		String s = cartaId + ";";
		cartaId++;
		return s+"armadilha;";
	}
	
	private String gerarTerreno() {
		Random rnd = new Random();
		int p = rnd.nextInt(100);
		
		// Deserto
		if(p < 13)
			return "Deserto";
		// Floresta
		else if(p >= 13 && p < 25)
			return "Floresta";
		// Tundra
		else if(p >= 25 && p < 37)
			return "Tundra";
		// Oceano
		else if(p >= 37 && p < 50)
			return "Oceano";
		// Vulcanico
		else if(p >= 50 && p < 63)
			return "Vulcanico";
		// Montanha
		else if(p >= 63 && p < 76)
			return "Montanha";
		// Planicie
		else if(p >= 76 && p < 86)
			return "Planicie";
		// Caverna
		else
			return "Caverna";
	}
	
	public Mensagem gerarPacoteInicial(int playerId) {
		Mensagem pi = new Mensagem();
		
		pi.playerId = playerId;
		pi.command = "inicializar";
		pi.msg = "Inicializando cartas e terrenos";
		pi.cartaId = -1;
		pi.posTabuleiro = null;
		pi.tabuleiro = tabuleiro;
		
		if(playerId == 0) {
			pi.deck = deckPlayer0;
			pi.deckInimigo = deckPlayer1;
		} else {
			pi.deck = deckPlayer1;
			pi.deckInimigo = deckPlayer0;
		}
		
		return pi;
	}
}
