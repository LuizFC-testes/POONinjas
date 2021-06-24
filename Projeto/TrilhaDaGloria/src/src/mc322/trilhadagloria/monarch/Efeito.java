package mc322.trilhadagloria.monarch;

import java.util.ArrayList;

public abstract class Efeito {
	protected Carta carta;
	protected ArrayList<Heroi> heroisAfetados;
	
	public abstract void passiva();
	
	public abstract void ativa();
	
	public abstract void eliminar();

	public void adicionarHeroi(Heroi heroi) {
		heroisAfetados.add(heroi);
	}
}
