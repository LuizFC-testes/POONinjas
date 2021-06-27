package mc322.trilhadagloria.monarch;

import java.util.ArrayList;

import mc322.trilhadagloria.battle.Batalha;
import mc322.trilhadagloria.field.BonusDatabase;
import mc322.trilhadagloria.field.Terreno;

public abstract class Heroi extends Carta implements IStatusHeroi {
	protected int forca[];
	protected int resistencia[];
	protected int alcance;
	private Dominio dominio;
	private Efeito efeitoBioma;
	protected ArrayList<Efeito> sobEfeito;
	
	
	public Heroi(int id, Dominio dominio) {
		super(id);
		this.dominio = dominio;
		preco = 0;
	}
	
	public int getAlcance() {
		return alcance;
	}

	public int[] getForcaBase() {
		return forca;
	}

	public int[] getResistBase() {
		return resistencia;
	}
	
	public float[] getBonusHero() {
		return BonusDatabase.getBonusDeBiomaPara(dominio);
	}
	
	public Dominio getDominio() {
		return dominio;
	}
	
	public void adicionarEfeito(Efeito efeito) {
		sobEfeito.add(efeito);
	}
	
	public void adicionarEfeitoBioma(Efeito efeito) {
		efeitoBioma = efeito;
	}
	
	public Efeito getEfeitoBioma() {
		return this.efeitoBioma;
	}
	
	public void removerEfeito(Efeito efeito) {
		sobEfeito.remove(efeito);
	}
	
	public void limparEfeitos() {
		sobEfeito.clear();
	}

	public ArrayList<Batalha> procurarBatalhas() {
		ArrayList<Terreno> visitados = new ArrayList<Terreno>();
		ArrayList<Batalha> cartasAoAlcance = new ArrayList<Batalha>();
		
		// Procura oponentes dentro do alcance e cria uma batalha
		procurarInimigosRecursivo(terreno, cartasAoAlcance, visitados, 0);
		
		return cartasAoAlcance;
	}
	
	private void procurarInimigosRecursivo(Terreno atual, ArrayList<Batalha> batalhas, ArrayList<Terreno> visitados, int alcanceRecursivo) {
		// Verifica se terreno ainda não foi visitado
		if(atual != null && !visitados.contains(atual)) {
			// Adiciona terreno atual na lista de visitados
			visitados.add(atual);
		
			// Se o heroi alcançar o terreno atual e houver uma carta inimiga, cria uma nova batalha
			if(alcanceRecursivo <= this.alcance) {
				Carta oponente = atual.getCarta(dono.getInimigoId());
				
				if(oponente != null && oponente instanceof Heroi) {
					batalhas.add(new Batalha(this, (Heroi)oponente));
				}
			}
			
			// Se o herói alcançar, procura recursivamente nos terrenos vizinhos
			if(alcanceRecursivo < this.alcance) {
				procurarInimigosRecursivo(atual.getVizinho(0), batalhas, visitados, alcanceRecursivo+1);
				procurarInimigosRecursivo(atual.getVizinho(1), batalhas, visitados, alcanceRecursivo+1);
				procurarInimigosRecursivo(atual.getVizinho(2), batalhas, visitados, alcanceRecursivo+1);
				procurarInimigosRecursivo(atual.getVizinho(3), batalhas, visitados, alcanceRecursivo+1);
			}
		}
	}
	
	public boolean atacar(Heroi defensor, float bonusAtaque, float bonusDefesa) {
		
		bonusAtaque += getBonusDeEfeitosForca();
		bonusDefesa += defensor.getBonusDeEfeitosResistencia();
		
		// Combate corpo a corpo
		if(defensor.terreno == this.terreno) {
			if((forca[0]*(1+bonusAtaque)) > (defensor.resistencia[0]*(1+bonusDefesa))) {
				return true;
			} else {
				return false;
			}
		}
		
		// Combate a distancia
		if((forca[1]*(1+bonusAtaque)) > (defensor.resistencia[1]*(1+bonusDefesa))) {
			return true;
		} else {
			return false;
		}
	}

	public float getBonusDeEfeitosForca() {
		float bonus = 0;
		
		// Aplica multiplicadores de efeitos
		for(Efeito ef : sobEfeito) {
			bonus += ef.getBonusDeForca();
		}
		
		if(efeitoBioma != null) {
			bonus += efeitoBioma.getBonusDeForca();
		}
		
		return bonus;
	}

	public float getBonusDeEfeitosResistencia() {
		float bonus = 0;
		
		// Aplica multiplicadores de efeitos
		for(Efeito ef : sobEfeito) {
			bonus += ef.getBonusDeResistencia();
		}
		
		if(efeitoBioma != null) {
			bonus += efeitoBioma.getBonusDeResistencia();
		}
		
		return bonus;
	}

	public boolean cairNaArmadilha(Armadilha armadilha, float bonusArmadilha) {
		
		float bonusDefesa = getBonusDeEfeitosResistencia();
		
		// Combate corpo a corpo
		if(armadilha.terreno == this.terreno) {
			if((armadilha.getPoder()*(1+bonusArmadilha)) > resistencia[0]*(1+bonusDefesa)) {
				return true;
			} else {
				return false;
			}
		}
		
		// Combate a distancia
		if((armadilha.getPoder()*(1+bonusArmadilha)) > resistencia[1]*(1+bonusDefesa)) {
			return true;
		} else {
			return false;
		}
	}

	public float[] getForcaComBonus() {
		return new float[] { forca[0] * (1+getBonusDeEfeitosForca()), forca[1]*(1+getBonusDeEfeitosForca()) };
	}
	
	@Override
	public void proximoTurno() {
		super.proximoTurno();
		
		if(turnosInvocada >= 5) {
			conquistarTerreno();
		}
	}
	
	public void conquistarTerreno() {
		terreno.conquistar(dono.getPlayerId());
	}
}
