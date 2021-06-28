package mc322.trilhadagloria.carta;

import java.util.ArrayList;

import mc322.trilhadagloria.field.BonusDatabase;
import mc322.trilhadagloria.field.Terreno;

public class Armadilha extends Carta {
	private int alcance;
	private Heroi alvo;
	private int poder;
	private Dominio dominio;
	
	public Armadilha(int id, Dominio dom) {
		super(id);
		preco = 1;
		alvo = null;
		poder = 100;
		dominio = dom;
	}

	public boolean estaArmada() {
		return alvo != null;
	}

	public void buscarAlvo() {
		if(!estaArmada()) {
			ArrayList<Terreno> visitados = new ArrayList<Terreno>();
			ArrayList<Heroi> inimigos = new ArrayList<Heroi>();
		
			// Procura oponentes dentro do alcance que foram invocados após a armadilha
			alvo = buscarAlvoRecursivo(terreno, inimigos, visitados, getDono().getInimigoId(), 0);
		}
	}
	
	private Heroi buscarAlvoRecursivo(Terreno atual, ArrayList<Heroi> batalhas, ArrayList<Terreno> visitados, int inimigoId, int alcanceRecursivo) {
		// Verifica se terreno ainda não foi visitado
		if(atual != null && !visitados.contains(atual)) {
			// Adiciona terreno atual na lista de visitados
			visitados.add(atual);
	
			// Verifica a existencia de um possível alvo
			if(alcanceRecursivo <= this.alcance) {
				if(atual.getCarta(inimigoId) != null) {
					if(atual.getCarta(inimigoId) instanceof Heroi && atual.getCarta(inimigoId).turnosInvocada < this.turnosInvocada)
						return (Heroi) atual.getCarta(inimigoId);
				}
			}
	
			// Se o herói alcançar, procura recursivamente nos terrenos vizinhos
			if(alcanceRecursivo < this.alcance) {
				Heroi h = buscarAlvoRecursivo(atual.getVizinho(0), batalhas, visitados, inimigoId, alcanceRecursivo+1);
				if(h != null)
					return h;
				
				h = buscarAlvoRecursivo(atual.getVizinho(1), batalhas, visitados, inimigoId, alcanceRecursivo+1);
				if(h != null)
					return h;

				h = buscarAlvoRecursivo(atual.getVizinho(2), batalhas, visitados, inimigoId, alcanceRecursivo+1);
				if(h != null)
					return h;
				
				return buscarAlvoRecursivo(atual.getVizinho(3), batalhas, visitados, inimigoId, alcanceRecursivo+1);
			}
		}
		return null;
	}

	public Heroi ativar() {
		if(estaArmada()) {
			float bonus = 0;
			
			if(dominio != null) {
				bonus = BonusDatabase.getBonusArmadilhaPoder(this.dominio, alvo.getDominio());
			}
			
			if(alvo.cairNaArmadilha(this, bonus)) {
				alvo.morrer();
				return alvo;
			}
		}
		return null;
	}

	public float getPoder() {
		return poder;
	}
}
