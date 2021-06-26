package mc322.trilhadagloria.monarch;

import java.util.ArrayList;

import mc322.trilhadagloria.battlefield.Batalha;
import mc322.trilhadagloria.battlefield.Terreno;

public abstract class Heroi extends Carta {
	protected int forca[];
	protected int resistencia[];
	protected int alcance;
	protected Dominio dominio;
	protected ArrayList<Efeito> sobEfeito;
	
	public Heroi(Dominio dominio) {
		this.dominio = dominio;
		preco = 0;
	}
	
	public Dominio getDominio() {
		return dominio;
	}
	
	public void adicionarEfeito(Efeito efeito) {
		sobEfeito.add(efeito);
		efeito.adicionarHeroi(this);
	}

	public ArrayList<Batalha> procurarBatalhas() {
		ArrayList<Terreno> visitados = new ArrayList<Terreno>();
		ArrayList<Batalha> batalhas = new ArrayList<Batalha>();
		
		// Procura oponentes dentro do alcance e cria uma batalha
		procurarBatalhasRecursivo(terreno, batalhas, visitados, 0);
		
		return batalhas;
	}
	
	private void procurarBatalhasRecursivo(Terreno atual, ArrayList<Batalha> batalhas, ArrayList<Terreno> visitados, int alcanceRecursivo) {
		// Verifica se terreno ainda não foi visitado
		if(atual != null && !visitados.contains(atual)) {
			// Adiciona terreno atual na lista de visitados
			visitados.add(atual);
		
			// Se o heroi alcançar o terreno atual e houver uma carta inimiga, cria uma nova batalha
			if(alcanceRecursivo <= this.alcance) {
				if(atual.getCarta(dono.getInimigoId()) != null) {
					batalhas.add(new Batalha(this, atual.getCarta(dono.getInimigoId())));
				}
			}
			
			// Se o herói alcançar, procura recursivamente nos terrenos vizinhos
			if(alcanceRecursivo < this.alcance) {
				procurarBatalhasRecursivo(atual.getVizinho(0), batalhas, visitados, alcanceRecursivo+1);
				procurarBatalhasRecursivo(atual.getVizinho(1), batalhas, visitados, alcanceRecursivo+1);
				procurarBatalhasRecursivo(atual.getVizinho(2), batalhas, visitados, alcanceRecursivo+1);
				procurarBatalhasRecursivo(atual.getVizinho(3), batalhas, visitados, alcanceRecursivo+1);
			}
		}
	}

	public boolean atacar(Heroi defensor) {
		int forca[] = this.getForcaComBonus();
		int resistencia[] = defensor.getResistenciaComBonus();
		
		// Combate corpo a corpo
		if(defensor.terreno == this.terreno) {
			if(forca[0] > resistencia[0]) {
				return true;
			} else {
				return false;
			}
		}
		
		// Combate a distancia
		if(forca[1] > resistencia[1]) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean atacar(Heroi defensor, int numAtacantes) {
		int forca[] = this.getForcaComBonus();
		int resistencia[] = defensor.getResistenciaComBonus();
		
		// Bonus de flanqueamento
		forca[0] *= Math.pow(1.05, numAtacantes-1);
		forca[1] *= Math.pow(1.05, numAtacantes-1);
		
		// Combate corpo a corpo
		if(defensor.terreno == this.terreno) {
			if(forca[0] > resistencia[0]) {
				return true;
			} else {
				return false;
			}
		}
		
		// Combate a distancia
		if(forca[1] > resistencia[1]) {
			return true;
		} else {
			return false;
		}
	}

	public int[] getResistenciaComBonus() {
		int resBonus[] = new int[2];
		
		// Inicializa com valores de base
		resBonus[0] = this.resistencia[0];
		resBonus[1] = this.resistencia[1];
		
		// Aplica multiplicadores de efeitos
		for(Efeito ef : sobEfeito) {
			resBonus[0] *= ef.bonusResistencia(this);
			resBonus[1] *= ef.bonusResistencia(this);
		}
		
		// Aplica bonus do bioma
		resBonus[0] *= terreno.getBonus(dominio);
		resBonus[1] *= terreno.getBonus(dominio);;
		
		return resBonus;
	}

	public int[] getForcaComBonus() {
		int forBonus[] = new int[2];
		
		// Inicializa com valores de base
		forBonus[0] = this.forca[0];
		forBonus[1] = this.forca[1];
		
		// Aplica multiplicadores de efeitos
		for(Efeito ef : sobEfeito) {
			forBonus[0] *= ef.bonusForca(this);
			forBonus[1] *= ef.bonusForca(this);
		}
		
		// Aplica bonus do bioma
		forBonus[0] *= terreno.getBonus(dominio);
		forBonus[1] *= terreno.getBonus(dominio);;
		
		return forBonus;
	}
}
