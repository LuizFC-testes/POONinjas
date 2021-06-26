package mc322.trilhadagloria.controle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import mc322.trilhadagloria.battlefield.Caverna;
import mc322.trilhadagloria.battlefield.Deserto;
import mc322.trilhadagloria.battlefield.Floresta;
import mc322.trilhadagloria.battlefield.Montanha;
import mc322.trilhadagloria.battlefield.Oceano;
import mc322.trilhadagloria.battlefield.Planicie;
import mc322.trilhadagloria.battlefield.Tabuleiro;
import mc322.trilhadagloria.battlefield.Terreno;
import mc322.trilhadagloria.battlefield.Tundra;
import mc322.trilhadagloria.battlefield.Vulcanico;
import mc322.trilhadagloria.monarch.Armadilha;
import mc322.trilhadagloria.monarch.Barbaro;
import mc322.trilhadagloria.monarch.Bardo;
import mc322.trilhadagloria.monarch.Carta;
import mc322.trilhadagloria.monarch.Clerigo;
import mc322.trilhadagloria.monarch.Dominio;
import mc322.trilhadagloria.monarch.Druida;
import mc322.trilhadagloria.monarch.Guerreiro;
import mc322.trilhadagloria.monarch.Ladino;
import mc322.trilhadagloria.monarch.Magia;
import mc322.trilhadagloria.monarch.Mago;
import mc322.trilhadagloria.monarch.Monge;
import mc322.trilhadagloria.monarch.Paladino;
import mc322.trilhadagloria.monarch.Ranger;
import mc322.trilhadagloria.monarch.Sorcerer;
import mc322.trilhadagloria.monarch.Warlock;

public class GeradorServer {
	private ArrayList<Carta> deckPlayer0;
	private ArrayList<Carta> deckPlayer1;
	private ArrayList<Terreno> tabuleiro;
	
	public GeradorServer() {
		// Gerar decks
		deckPlayer0 = gerarDeck(20,5,5);
		deckPlayer1 = gerarDeck(20,5,5);
		
		// Gerar terrenos
		tabuleiro = new ArrayList<Terreno>();
		
		for(int i = 0; i < Tabuleiro.MAPSIZE*Tabuleiro.MAPSIZE; i++) {
			tabuleiro.add(gerarTerreno());
		}
	}
	
	/**
	 * Gerador de Deck
	 * @param nHerois - número de cartas do tipo Heroi
	 * @param nMagias - número de cartas do tipo Magia
	 * @param nArmadilhas - número de cartas do tipo Armadilha
	 * @return ArrayList de cartas geradas aleatoriamente conforme especificado 
	 */
	private ArrayList<Carta> gerarDeck(int nHerois, int nMagias, int nArmadilhas) {
		ArrayList<Carta> deck = new ArrayList<Carta>();
		
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
		
		return deck;
	}
	
	/**
	 * Gera aleatoriamente um objeto do tipo Heroi. Os Herois possuem probabilidade iguais de geração.
	 * @return  objeto do tipo Carta/Heroi
	 */
	private Carta gerarHeroi() {
		Random rnd = new Random();
		
		// Escolhe um dominio aleatório
		Dominio dom = Dominio.values()[rnd.nextInt(Dominio.values().length)];
		
		switch(rnd.nextInt(12)) {
		case 0:
			return new Warlock(dom);
		case 1:
			return new Bardo(dom);
		case 2:
			return new Clerigo(dom);
		case 3:
			return new Druida(dom);
		case 4:
			return new Guerreiro(dom);
		case 5:
			return new Ladino(dom);
		case 6:
			return new Mago(dom);
		case 7:
			return new Monge(dom);
		case 8:
			return new Paladino(dom);
		case 9:
			return new Ranger(dom);
		case 10:
			return new Sorcerer(dom);
		default:
			return new Barbaro(dom);
		}
	}
	
	private Carta gerarMagia() {
		return new Magia();
	}
	
	private Carta gerarArmadilha() {
		return new Armadilha();
	}
	
	private Terreno gerarTerreno() {
		Random rnd = new Random();
		int p = rnd.nextInt(100);
		
		if(p < 13)
			return new Deserto();
		else if(p >= 13 && p < 25)
			return new Floresta();
		else if(p >= 25 && p < 37)
			return new Tundra();
		else if(p >= 37 && p < 50)
			return new Oceano();
		else if(p >= 50 && p < 63)
			return new Vulcanico();
		else if(p >= 63 && p < 76)
			return new Montanha();
		else if(p >= 76 && p < 86)
			return new Planicie();
		else
			return new Caverna();
	}
	
	public PacketInicial gerarPacoteInicial(int playerId) {
		PacketInicial pi = new PacketInicial(playerId);
		
		pi.deckPlayer0 = new Carta[this.deckPlayer0.size()];
		pi.deckPlayer1 = new Carta[this.deckPlayer1.size()];
		pi.tabuleiro = new Terreno[this.tabuleiro.size()];
		
		pi.deckPlayer0 = this.deckPlayer0.toArray(pi.deckPlayer0);
		pi.deckPlayer1 = this.deckPlayer1.toArray(pi.deckPlayer1);
		pi.tabuleiro = this.tabuleiro.toArray(pi.tabuleiro);
		
		return pi;
	}
}
