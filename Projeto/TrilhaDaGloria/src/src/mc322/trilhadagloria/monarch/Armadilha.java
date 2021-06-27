package mc322.trilhadagloria.monarch;

import java.util.ArrayList;

import mc322.trilhadagloria.field.Terreno;

public class Armadilha extends Carta {
	private boolean armada;
	private int alcance;
	private Efeito efeito;
	private Heroi alvo;
	
	public Armadilha(int id) {
		super(id);
		this.preco = 1;
		armada = false;
	}
	
	public void armar(Heroi heroi) {
		if(heroi != null) {
			armada = true;
			alvo = heroi;
		}
	}

	public boolean estaArmada() {
		return armada;
	}
	
	public int getAlcance() {
		return alcance;
	}

	public Heroi buscarAlvo() {
		if(!armada) {
			ArrayList<Terreno> visitados = new ArrayList<Terreno>();
			ArrayList<Heroi> inimigos = new ArrayList<Heroi>();
		
			// Procura oponentes dentro do alcance que foram invocados após a armadilha
			return buscarHeroisRecursivo(terreno, inimigos, visitados, getDono().getInimigoId(), 0);
		}
		return null;
	}
	
	private Heroi buscarHeroisRecursivo(Terreno atual, ArrayList<Heroi> batalhas, ArrayList<Terreno> visitados, int playerId, int alcanceRecursivo) {
		// Verifica se terreno ainda não foi visitado
		if(!armada && atual != null && !visitados.contains(atual)) {
			// Adiciona terreno atual na lista de visitados
			visitados.add(atual);
	
			// Se o heroi alcançar o terreno atual e houver uma carta inimiga, cria uma nova batalha
			if(alcanceRecursivo <= this.alcance) {
				if(atual.getCarta(playerId) != null) {
					if(atual.getCarta(playerId) instanceof Heroi && atual.getCarta(playerId).turnosInvocada < this.turnosInvocada)
						return (Heroi) atual.getCarta(playerId);
				}
			}
	
			// Se o herói alcançar, procura recursivamente nos terrenos vizinhos
			if(!armada && alcanceRecursivo < this.alcance) {
				Heroi h = buscarHeroisRecursivo(atual.getVizinho(0), batalhas, visitados, playerId, alcanceRecursivo+1);
				if(h != null) {
					return h;
				}
				h = buscarHeroisRecursivo(atual.getVizinho(1), batalhas, visitados, playerId, alcanceRecursivo+1);
				if(h != null) {
					return h;
				}
				h = buscarHeroisRecursivo(atual.getVizinho(2), batalhas, visitados, playerId, alcanceRecursivo+1);
				if(h != null) {
					return h;
				}
				h = buscarHeroisRecursivo(atual.getVizinho(3), batalhas, visitados, playerId, alcanceRecursivo+1);
				if(h != null) {
					return h;
				}
			}
		}
		return null;
	}

	public void ativar() {
		efeito.adicionarHeroi(alvo);
		efeito.ativarEfeitoPreCombate();
	}
}
