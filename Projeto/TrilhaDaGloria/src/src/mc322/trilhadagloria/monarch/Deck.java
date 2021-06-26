package mc322.trilhadagloria.monarch;

import java.util.ArrayList;
import mc322.trilhadagloria.exceptions.EmptyDeckException;

public class Deck extends GrupoCartas{
	
	public Deck(ArrayList<Carta> cartas) {
		this.cartas = cartas;
	}
	
	public Carta comprarCarta() throws EmptyDeckException {
		if(cartas.size() <= 0) {
			throw new EmptyDeckException("Nao foi possivel comprar carta do deck");
		}
		return cartas.remove(0);
	}
}
