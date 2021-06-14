package mc322.trilhadagloria.monarch;

import mc322.trilhadagloria.battlefield.ISummon;
import mc322.trilhadagloria.battlefield.Terreno;
import mc322.trilhadagloria.exceptions.EmptyDeckException;

public class Monarca implements IMonarca{
	private Deck deck;
	private GrupoCartas mao;
	private GrupoCartas cemiterio;
	private ISummon battleField;
	
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

	public void invocarCarta(Carta c, Terreno t) {
		if(battleField != null) {
			if(c instanceof Armadilha) {
				if(((Armadilha) c).getPreco() > this.mana) {
					return;
				}
			} else if(c instanceof Magia) {
				if(((Magia) c).getPreco() > this.mana) {
					return;
				}
			}
			battleField.invocarCarta(c, t);
			mao.removerCarta(c);
		}
	}
	
	public void sacrificarCarta(Carta c) {
		if(mao.removerCarta(c)) {
			enviarCemiterio(c);
			mana++;
		}
	}

	public void connect(ISummon battleField) {
		this.battleField = battleField;
	}
}
