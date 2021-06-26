package mc322.trilhadagloria.monarch;

import java.util.ArrayList;

import mc322.trilhadagloria.battlefield.ISummon;
import mc322.trilhadagloria.battlefield.Terreno;
import mc322.trilhadagloria.exceptions.EmptyDeckException;
import mc322.trilhadagloria.exceptions.GameExceptions;
import mc322.trilhadagloria.exceptions.NotEnoughManaException;

public class Monarca implements IMonarca{
	private Deck deck;
	private GrupoCartas mao;
	private GrupoCartas cemiterio;
	private ISummon battleField;
	private int mana;
	private int playerId;
	private int inimigoId;
	
	public Monarca(int playerId, ArrayList<Carta> deckInicial) {
		deck = new Deck(deckInicial);
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
		
		this.playerId = playerId;
		
		if(playerId == 0) {
			inimigoId = 1;
		} else {
			inimigoId = 0;
		}
	}
	
	public int getMana() {
		return this.mana;
	}
	
	public int getInimigoId() {
		return inimigoId;
	}
	
	public void setInimigoId(int id) {
		inimigoId = id;
	}
	
	public void comprarCarta() throws EmptyDeckException {
		Carta c = deck.comprarCarta();
		mao.adicionarCarta(c);
	}

	public void enviarCemiterio(Carta c) {
		cemiterio.adicionarCarta(c);
	}

	public void invocarCarta(Carta c, Terreno t) throws GameExceptions {
		if(battleField != null) {
			if(mana < c.getPreco()) {
				throw new NotEnoughManaException("Não foi possível invocar. Mana insuficiente");
			} else {
				battleField.invocarCarta(c, t);
				mao.removerCarta(c);
				mana -= c.getPreco();
			}
		} else {
			System.err.println("Impossivel invocar carta, battlefield não está conectado ao monarca.");
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

	public void setMana(int mana) {
		this.mana = mana;
	}
	
	public void setPlayerId(int id) {
		playerId = id;
	}
	
	public int getPlayerId() {
		return playerId;
	}
}
