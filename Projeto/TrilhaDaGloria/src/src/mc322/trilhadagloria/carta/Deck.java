package mc322.trilhadagloria.carta;

import java.util.ArrayList;
import mc322.trilhadagloria.exceptions.EmptyDeckException;
import mc322.trilhadagloria.monarch.Monarca;
import mc322.trilhadagloria.gui.telaPrinc.ICardCount;

public class Deck extends GrupoCartas {
	
	ICardCount deckV;
	
	public Deck(String[] deck, Monarca dono) {
		this.cartas = gerarDeck(deck, dono);
	}
	
	public Carta comprarCarta() throws EmptyDeckException {
		if(cartas.size() <= 0) {
			throw new EmptyDeckException("Nao foi possivel comprar carta do deck");
		}
		deckV.reduzirContador();
		return cartas.remove(0);
	}
	
	private ArrayList<Carta> gerarDeck(String[] deck, Monarca dono) {
		ArrayList<Carta> deckArray = new ArrayList<Carta>();
		Carta c;
		
		for(int i = 0; i < deck.length; i++) {
			String[] code = deck[i].split(";");
		
			switch(code[1]) {
			case "warlock":
				c = new Warlock(Integer.parseInt(code[0]), Dominio.valueOf(code[2]));
				break;
			case "bardo":
				c = new Bardo(Integer.parseInt(code[0]), Dominio.valueOf(code[2]));
				break;
			case "clerigo":
				c = new Clerigo(Integer.parseInt(code[0]), Dominio.valueOf(code[2]));
				break;
			case "druida":
				c = new Druida(Integer.parseInt(code[0]), Dominio.valueOf(code[2]));
				break;
			case "guerreiro":
				c = new Guerreiro(Integer.parseInt(code[0]), Dominio.valueOf(code[2]));
				break;
			case "ladino":
				c = new Ladino(Integer.parseInt(code[0]), Dominio.valueOf(code[2]));
				break;
			case "mago":
				c = new Mago(Integer.parseInt(code[0]), Dominio.valueOf(code[2]));
				break;
			case "monge":
				c = new Monge(Integer.parseInt(code[0]), Dominio.valueOf(code[2]));
				break;
			case "paladino":
				c = new Paladino(Integer.parseInt(code[0]), Dominio.valueOf(code[2]));
				break;
			case "ranger":
				c = new Ranger(Integer.parseInt(code[0]), Dominio.valueOf(code[2]));
				break;
			case "sorcerer":
				c = new Sorcerer(Integer.parseInt(code[0]), Dominio.valueOf(code[2]));
				break;
			case "armadilha":
				c = new Armadilha(Integer.parseInt(code[0]), Dominio.valueOf(code[2]));
				break;
			case "magia":
				c = new Magia(Integer.parseInt(code[0]));
				break;
			default:
				c = new Barbaro(Integer.parseInt(code[0]), Dominio.valueOf(code[2]));
				break;
			}
			c.setDono(dono);
			deckArray.add(c);
		}
		
		return deckArray;
	}
	
	public void connect(ICardCount deckV) {
		this.deckV = deckV;
	}
}
