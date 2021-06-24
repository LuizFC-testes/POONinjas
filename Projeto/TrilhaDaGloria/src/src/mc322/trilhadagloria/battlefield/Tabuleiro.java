package mc322.trilhadagloria.battlefield;

import mc322.trilhadagloria.controle.Gerador;
import mc322.trilhadagloria.exceptions.GameExceptions;
import mc322.trilhadagloria.monarch.Carta;

public class Tabuleiro implements ISummon {
	private Terreno mapa[][];
	
	public Tabuleiro() {
		mapa = new Terreno[5][5];
		
		for(int i = 0; i < 5; i++)
			for(int j = 0; j < 5; j++)
				mapa[i][j]= Gerador.gerarTerreno();
	}

	public void invocarCarta(Carta c, Terreno t) throws GameExceptions {
		t.invocarCarta(c);
	}
}
