package mc322.trilhadagloria.field;

import java.util.ArrayList;

import mc322.trilhadagloria.exceptions.GameExceptions;
import mc322.trilhadagloria.monarch.Armadilha;
import mc322.trilhadagloria.monarch.Carta;
import mc322.trilhadagloria.monarch.Heroi;
import mc322.trilhadagloria.monarch.IPlayerEffects;

public class Tabuleiro implements IField {
	public static final int MAPSIZE = 5;
	
	private Terreno mapa[][];
	private ArrayList<Heroi> herois;
	private ArrayList<Armadilha> armadilhas;
	
	public Tabuleiro(String[][] tabuleiro) {
		mapa = new Terreno[MAPSIZE][MAPSIZE];
		
		// Cria terrenos a partir de dados enviados pelo servidor
		for(int i = 0; i < MAPSIZE; i++) {
			for(int j = 0; j < MAPSIZE; j++) {
				mapa[i][j] = new Terreno(Bioma.valueOf(tabuleiro[i][j]));
				mapa[i][j].setPosicao(i, j);
			}
		}
		
		for(int i = 0; i < MAPSIZE; i++) {
			for(int j = 0; j < MAPSIZE; j++) {
				if(i < MAPSIZE-1)
					mapa[i][j].setVizinho(0, mapa[i+1][j]);
				if(j < MAPSIZE-1)
					mapa[i][j].setVizinho(1, mapa[i][j+1]);
				if(i >= 1)
					mapa[i][j].setVizinho(2, mapa[i-1][j]);
				if(j >= 1)
					mapa[i][j].setVizinho(3, mapa[i][j-1]);
			}
		}
	}

	public void invocarCarta(Carta c, Terreno t, int playerId) throws GameExceptions {
		t.invocarCarta(c, playerId);
		
		if(c instanceof Heroi) {
			herois.add((Heroi)c);
		} else if(c instanceof Armadilha) {
			armadilhas.add((Armadilha)c);
		}
	}

	public Terreno getTerreno(int i, int j) {
		return mapa[i][j];
	}

	public void remover(Carta carta) {
		if(carta != null) {
			// Remove carta do terreno
			carta.getTerreno().removerCarta(carta.getDono().getPlayerId());
			
			// Remove da lista de cartas invocadas
			if(carta instanceof Heroi) {
				herois.remove(carta);
			} else if(carta instanceof Armadilha) {
				armadilhas.remove(carta);
			}
		}
	}

	public ArrayList<Armadilha> getArmadilhasInvocadas() {
		return armadilhas;
	}

	public void incrementarTurnoCartasInvocadas() {
		for(Armadilha a : armadilhas) {
			a.proximoTurno();
		}
		
		for(Heroi h : herois) {
			h.proximoTurno();
		}
	}

	public ArrayList<Heroi> getHeroisInvocados() {
		return herois;
	}

	@Override
	public void conecta(IPlayerEffects monarca) {
		
	}

	@Override
	public boolean verificarCaminhoFechado(int playerId) {
		for(Heroi h : herois) {
			if(h.getDono().getPlayerId() == playerId) {
				if(h.getTerreno().getPosicao()[0] == 0) {
					ArrayList<Terreno> visitados = new ArrayList<Terreno>();
					
					boolean b = verificarCaminhoRecursivo(h.getTerreno(), playerId, visitados);
					
					if(b == true) {
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	public boolean verificarCaminhoRecursivo(Terreno atual, int playerId, ArrayList<Terreno> visitados) {
		visitados.add(atual);
		
		// Cancela busca se territorio não estiver consquisatado
		if(!atual.estaConquistado() || atual.getIdDono() != playerId)
			return false;
		
		// Se o território conquistado estiver do lado oposto do tabuleiro, então existe um caminho fechado
		if(atual.getPosicao()[0] == MAPSIZE-1) {
			return true;
		}
		
		// Caso contrário, busca por territorios vizinhos conquistados
		for(Terreno t : atual.getVizinhos()) {
			if(!visitados.contains(t)) {
				
				boolean b = verificarCaminhoRecursivo(t, playerId, visitados);
				
				if(b == true) {
					return true;
				}
			}
		}
		
		return false;
	}
}
