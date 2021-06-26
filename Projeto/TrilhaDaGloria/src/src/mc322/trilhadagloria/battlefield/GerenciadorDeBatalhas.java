package mc322.trilhadagloria.battlefield;

import java.util.ArrayList;

import mc322.trilhadagloria.monarch.Heroi;

public class GerenciadorDeBatalhas {
	Tabuleiro tabuleiro;
	ArrayList<Batalha> filaDeBatalhas;

	public GerenciadorDeBatalhas(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
		filaDeBatalhas = new ArrayList<Batalha>();
	}

	public void gerarBatalhas(int atacanteId) {
		// Percorre todas as cartas atacantes
		for(int i = 0; i < Tabuleiro.MAPSIZE; i++) {
			for(int j = 0; j < Tabuleiro.MAPSIZE; j++) {
				if(tabuleiro.getTerreno(i,j).getCarta(atacanteId) != null) {
					
					// Para cada heroi, cria uma lista de batalhas e adiciona a fila
					if(tabuleiro.getTerreno(i,j).getCarta(atacanteId) instanceof Heroi) {
						Heroi heroi = (Heroi) tabuleiro.getTerreno(i,j).getCarta(atacanteId);
						filaDeBatalhas.addAll(heroi.procurarBatalhas());
					}
				}
			}
		}
	}
	
	public void gerarFlanqueamento() {
		// Para cada batalha, verifica se as seguintes possuem os mesmos defensores
		for(int i = 0; i < filaDeBatalhas.size(); i++) {
			ArrayList<Batalha> mesmoInimigo = new ArrayList<Batalha>();
			Batalha b1 = filaDeBatalhas.get(i);		
			
			for(int j = i+1; j < filaDeBatalhas.size(); j++) {
				Batalha b2 = filaDeBatalhas.get(j);
				
				if(b1.mesmoDefensor(b2)) {
					mesmoInimigo.add(b2);
				}
			}
			
			// Caso tenha flanqueamento, substitui batalhas da fila por um unico Flanqueamento
			if(mesmoInimigo.size() > 0) {
				mesmoInimigo.add(b1);
				filaDeBatalhas.removeAll(mesmoInimigo);
				filaDeBatalhas.add(new Flanqueamento(mesmoInimigo));
			}
		}
	}
	
	public void iniciarBatalhas() {
		while(filaDeBatalhas.size() > 0) {
			Batalha b = filaDeBatalhas.remove(0);
			Heroi perdedor = b.batalhar();
			tabuleiro.remover(perdedor);
		}
	}
	

}
