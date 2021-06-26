package mc322.trilhadagloria.monarch;

import java.util.ArrayList;

public abstract class Efeito {
	protected Carta carta;
	protected ArrayList<Heroi> alvos;
	protected ArrayList<Heroi> aliados;
	protected int turnosRestantes;
	protected int numeroMaximoDeAlvos;
	protected int numeroMaximoDeAliados;
	protected int alcance;
	
	public abstract void passiva();
	
	public abstract void ativa();
	
	public abstract void eliminar();

	public void adicionarHeroi(Heroi heroi) {
		if(heroi.getDono().getPlayerId() == carta.getDono().getPlayerId()) {
			if(aliados.size() < numeroMaximoDeAliados) {
				aliados.add(heroi);
			}
		} else {
			if(alvos.size() < numeroMaximoDeAlvos) {
				alvos.add(heroi);
			}
		}
	}
	
	public int getAlcance() {
		return alcance;
	}

	public abstract int bonusResistencia(Heroi h);

	public abstract float bonusForca(Heroi h);

	protected abstract void ativarEfeitoPreCombate();
}
