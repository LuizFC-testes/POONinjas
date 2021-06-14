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

public class Gerador {
	
	/**
	 * Gerador de Deck
	 * @param nHerois - número de cartas do tipo Heroi
	 * @param nMagias - número de cartas do tipo Magia
	 * @param nArmadilhas - número de cartas do tipo Armadilha
	 * @return ArrayList de cartas geradas aleatoriamente conforme especificado 
	 */
	public static ArrayList<Carta> gerarDeck(int nHerois, int nMagias, int nArmadilhas) {
		ArrayList<Carta> deck = new ArrayList<Carta>();
		
		for(int i = 0; i < nHerois; i++) {
			deck.add(Gerador.gerarHeroi());
		}
		
		for(int i = 0; i < nMagias; i++) {
			deck.add(Gerador.gerarMagia());
		}
		
		for(int i = 0; i < nArmadilhas; i++) {
			deck.add(Gerador.gerarArmadilha());
		}
		
		Collections.shuffle(deck);
		
		return deck;
	}
	
	/**
	 * Gera aleatoriamente um objeto do tipo Heroi. Os Herois possuem probabilidade iguais de geração.
	 * @return  objeto do tipo Carta/Heroi
	 */
	private static Carta gerarHeroi() {
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
	
	private static Carta gerarMagia() {
		return new Magia();
	}
	
	private static Carta gerarArmadilha() {
		return new Armadilha();
	}
	
	public static Terreno gerarTerreno() {
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
	
}
