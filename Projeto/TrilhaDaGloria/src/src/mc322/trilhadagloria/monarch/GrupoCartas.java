package mc322.trilhadagloria.monarch;

import java.util.ArrayList;

public class GrupoCartas {
	protected ArrayList<Carta> cartas;
	
	public GrupoCartas() {
		cartas = new ArrayList<Carta>();
	}
	
	public int getNCartas() {
		return cartas.size();
	}

	public void adicionarCarta(Carta c) {
		cartas.add(c);
	}

	public boolean removerCarta(Carta c) {
		if(cartas.contains(c)) {
			cartas.remove(c);
			return true;
		}
		
		return false;
	}

	public Carta buscarCartaPorId(int cartaId) {
		for(Carta c : cartas) {
			if(c.getId() == cartaId) {
				return c;
			}
		}
		return null;
	}
}
