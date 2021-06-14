package mc322.trilhadagloria.monarch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import mc322.trilhadagloria.controle.Gerador;
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
}
