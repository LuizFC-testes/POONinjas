package mc322.trilhadagloria.battlefield;

import java.util.ArrayList;

import mc322.trilhadagloria.exceptions.GameExceptions;
import mc322.trilhadagloria.monarch.Armadilha;
import mc322.trilhadagloria.monarch.Carta;
import mc322.trilhadagloria.monarch.Heroi;

public class Tabuleiro implements IBattleField {
	public static final int MAPSIZE = 5;
	
	private Terreno mapa[][];
	private ArrayList<Heroi> herois;
	private ArrayList<Armadilha> armadilhas;
	private GerenciadorDeBatalhas gdb;
	
	public Tabuleiro(String[][] tabuleiro) {
		mapa = new Terreno[MAPSIZE][MAPSIZE];
		
		// Cria terrenos a partir de dados enviados pelo servidor
		for(int i = 0; i < MAPSIZE; i++) {
			for(int j = 0; j < MAPSIZE; j++) {
				mapa[i][j] = gerarTerreno(tabuleiro[i][j]);
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
		
		gdb = new GerenciadorDeBatalhas(this);
	}

	public void invocarCarta(Carta c, Terreno t) throws GameExceptions {
		t.invocarCarta(c);
		
		if(c instanceof Heroi) {
			herois.add((Heroi)c);
		} else if(c instanceof Armadilha) {
			armadilhas.add((Armadilha)c);
		}
	}

	public void iniciarBatalha(int atacanteId) {
		gdb.gerarBatalhas(atacanteId);
		gdb.gerarFlanqueamento();
		gdb.iniciarBatalhas();
	}
	
	public void ativarArmadilhas() {
		gdb.atualizarArmadilhas();
		gdb.ativarArmadilhas();
	}

	public Terreno getTerreno(int i, int j) {
		return mapa[i][j];
	}

	public void remover(Carta carta) {
		if(carta != null) {
			int posicao[] = carta.getTerreno().getPosicao();
			mapa[posicao[0]][posicao[1]].setCarta(carta.getDono().getPlayerId(), null);
		}
	}

	public ArrayList<Armadilha> getArmadilhas() {
		return armadilhas;
	}
	
	private Terreno gerarTerreno(String code) {
		// Deserto
		switch(code) {
		case "Deserto":
			return new Deserto();
		// Floresta
		case "Floresta":
			return new Floresta();
		// Tundra
		case "Tundra":
			return new Tundra();
		// Oceano
		case "Oceano":
			return new Oceano();
		// Vulcanico
		case "Vulcanico":
			return new Vulcanico();
		// Montanha
		case "Montanha":
			return new Montanha();
		// Planicie
		case "Planicie":
			return new Planicie();
		// Caverna
		case "Caverna":
			return new Caverna();
		}
		return null;
	}
}
