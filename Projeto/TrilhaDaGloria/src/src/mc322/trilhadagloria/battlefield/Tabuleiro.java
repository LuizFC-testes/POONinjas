package mc322.trilhadagloria.battlefield;

import mc322.trilhadagloria.controle.Gerador;

public class Tabuleiro {
	private Terreno mapa[][];
	
	public Tabuleiro() {
		mapa = new Terreno[5][5];
		
		for(int i = 0; i < 5; i++)
			for(int j = 0; j < 5; j++)
				mapa[i][j]= Gerador.gerarTerreno();
	}
}
