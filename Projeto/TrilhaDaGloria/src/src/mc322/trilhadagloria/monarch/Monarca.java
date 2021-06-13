package mc322.trilhadagloria.monarch;

import mc322.trilhadagloria.exceptions.EmptyDeckException;

public class Monarca implements IMonarca{
	private Deck deck;
	private GrupoCartas mao;
	private GrupoCartas cemiterio;
	
	private int mana;
	
	public Monarca() {
		deck = new Deck();
		mao = new GrupoCartas();
		cemiterio = new GrupoCartas();
		mana = 5;
	
		try {
			for(int i = 0; i < 5; i++) {
				mao.adicionarCarta(deck.comprarCarta());
			}
		}
		catch(EmptyDeckException error) {
			System.err.println("*** Error: " + error.getMessage());
		}
	}
	
	public void comprarCarta() throws EmptyDeckException {
		Carta c = deck.comprarCarta();
		mao.adicionarCarta(c);
	}

	public void enviarCemiterio(Carta c) {
		cemiterio.adicionarCarta(c);
	}

	public void invocarCarta(Carta c/*, Terreno t*/) {
		mao.removerCarta(c);
		// ISummon invocar no battlefield
	}
	
	public void sacrificarCarta(Carta c) {
		if(mao.removerCarta(c)) {
			cemiterio.adicionarCarta(c);
		}
	}
}
