package mc322.trilhadagloria.monarch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import mc322.trilhadagloria.exceptions.EmptyDeckException;

public class Deck extends GrupoCartas{
	
	public Deck() {
		cartas = gerarDeck(20,5,5);
	}
	
	public Carta comprarCarta() throws EmptyDeckException {
		if(cartas.size() <= 0) {
			throw new EmptyDeckException("Nao foi possivel comprar carta do deck");
		}
		return cartas.remove(0);
	}
	
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
	
	private Carta gerarHeroi() {
		Random rnd = new Random();
		
		switch(rnd.nextInt(12)) {
		case 0:
			return new Barbaro();
		case 1:
			return new Bardo();
		case 2:
			return new Clerigo();
		case 3:
			return new Druida();
		case 4:
			return new Guerreiro();
		case 5:
			return new Ladino();
		case 6:
			return new Mago();
		case 7:
			return new Monge();
		case 8:
			return new Paladino();
		case 9:
			return new Ranger();
		case 10:
			return new Sorcerer();
		case 11:
			return new Warlock();
		default:
			return new Barbaro();
		}
		
	}
	
	private Carta gerarMagia() {
		return new Magia();
	}
	
	private Carta gerarArmadilha() {
		return new Armadilha();
	}
}
