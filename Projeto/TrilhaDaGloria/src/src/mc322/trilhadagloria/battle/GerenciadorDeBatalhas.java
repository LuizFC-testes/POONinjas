package mc322.trilhadagloria.battle;

import java.util.ArrayList;

import mc322.trilhadagloria.carta.Armadilha;
import mc322.trilhadagloria.carta.Heroi;
import mc322.trilhadagloria.field.IBattleField;
import mc322.trilhadagloria.monarch.HabilidadeEspecial;

public class GerenciadorDeBatalhas implements IBattle {
	IBattleField tabuleiro;
	ArrayList<Batalha> filaDeBatalhas;
	ArrayList<Armadilha> armadilhasArmadas;

	public GerenciadorDeBatalhas() {
		filaDeBatalhas = new ArrayList<Batalha>();
		armadilhasArmadas = new ArrayList<Armadilha>();
	}
	
	public void conecta(IBattleField bf) {
		this.tabuleiro = bf;
	}

	public void gerarBatalhas(int atacanteId) {
		filaDeBatalhas.clear();
		// Percorre todas as cartas atacantes
		for(Heroi h : tabuleiro.getHeroisInvocados()) {
			
			// Para cada heroi, cria uma lista de batalhas e adiciona a fila
			if(h.getDono().getPlayerId() == atacanteId) {
				filaDeBatalhas.addAll(h.procurarBatalhas());
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

	public void ativarArmadilhas() {
		while(armadilhasArmadas.size() > 0) {
			Armadilha a = armadilhasArmadas.remove(0);
			
			Heroi morto = a.ativar();
			
			if(morto != null) {
				tabuleiro.remover(morto);
			}
			
			tabuleiro.remover(a);
			a.morrer();
		}
	}

	public void revelarArmadilhas() {
		armadilhasArmadas.clear();
		
		for(Armadilha a : tabuleiro.getArmadilhasInvocadas()) {
			a.buscarAlvo();
			if(a.estaArmada()) {
				a.setVisibilidadeAoInimigo(true);
				armadilhasArmadas.add(a);
			}
		}
	}
	
	public void ativarHabilidadesPassivas() {
		for(Heroi h : tabuleiro.getHeroisInvocados()) {
			if(h instanceof HabilidadeEspecial) {
				HabilidadeEspecial hs = (HabilidadeEspecial) h;
				hs.passiva();
			}
		}
	}

}
