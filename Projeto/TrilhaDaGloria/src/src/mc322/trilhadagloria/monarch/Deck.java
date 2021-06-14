package mc322.trilhadagloria.monarch;

import mc322.trilhadagloria.controle.Gerador;
import mc322.trilhadagloria.exceptions.EmptyDeckException;

public class Deck extends GrupoCartas{
	
	public Deck() {
		cartas = Gerador.gerarDeck(20,5,5);
	}
	
	public Carta comprarCarta() throws EmptyDeckException {
		if(cartas.size() <= 0) {
			throw new EmptyDeckException("Nao foi possivel comprar carta do deck");
		}
		return cartas.remove(0);
	}
}
