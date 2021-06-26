package mc322.trilhadagloria.monarch;

import java.util.ArrayList;
import mc322.trilhadagloria.exceptions.EmptyDeckException;

public class Deck extends GrupoCartas{
	
	public Deck(String[] deck) {
		this.cartas = gerarDeck(deck);
	}
	
	public Carta comprarCarta() throws EmptyDeckException {
		if(cartas.size() <= 0) {
			throw new EmptyDeckException("Nao foi possivel comprar carta do deck");
		}
		return cartas.remove(0);
	}
	
	private ArrayList<Carta> gerarDeck(String[] deck) {
		ArrayList<Carta> deckArray = new ArrayList<Carta>();
		
		for(int i = 0; i < deck.length; i++) {
			String[] code = deck[i].split(";");
		
			switch(code[1]) {
			case "warlock":
				deckArray.add(new Warlock(Integer.parseInt(code[0]), Dominio.valueOf(code[2])));
				break;
			case "bardo":
				deckArray.add(new Bardo(Integer.parseInt(code[0]), Dominio.valueOf(code[2])));
				break;
			case "clerigo":
				deckArray.add(new Clerigo(Integer.parseInt(code[0]), Dominio.valueOf(code[2])));
				break;
			case "druida":
				deckArray.add(new Druida(Integer.parseInt(code[0]), Dominio.valueOf(code[2])));
				break;
			case "guerreiro":
				deckArray.add(new Guerreiro(Integer.parseInt(code[0]), Dominio.valueOf(code[2])));
				break;
			case "ladino":
				deckArray.add(new Ladino(Integer.parseInt(code[0]), Dominio.valueOf(code[2])));
				break;
			case "mago":
				deckArray.add(new Mago(Integer.parseInt(code[0]), Dominio.valueOf(code[2])));
				break;
			case "monge":
				deckArray.add(new Monge(Integer.parseInt(code[0]), Dominio.valueOf(code[2])));
				break;
			case "paladino":
				deckArray.add(new Paladino(Integer.parseInt(code[0]), Dominio.valueOf(code[2])));
				break;
			case "ranger":
				deckArray.add(new Ranger(Integer.parseInt(code[0]), Dominio.valueOf(code[2])));
				break;
			case "sorcerer":
				deckArray.add(new Sorcerer(Integer.parseInt(code[0]), Dominio.valueOf(code[2])));
				break;
			case "barbaro":
				deckArray.add(new Barbaro(Integer.parseInt(code[0]), Dominio.valueOf(code[2])));
				break;
			case "armadilha":
				deckArray.add(new Armadilha(Integer.parseInt(code[0])));
				break;
			case "magia":
				deckArray.add(new Magia(Integer.parseInt(code[0])));
			}
		}
		
		return deckArray;
	}
}
