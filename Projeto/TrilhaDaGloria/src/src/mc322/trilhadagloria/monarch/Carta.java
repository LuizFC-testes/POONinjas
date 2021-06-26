package mc322.trilhadagloria.monarch;

import mc322.trilhadagloria.battlefield.Terreno;

public abstract class Carta {
	private int id;
	protected boolean invocada = false;
	protected int turnosInvocada = 0;
	protected Terreno terreno = null;
	protected Efeito efeito;
	protected int preco;
	protected Monarca dono;
	private boolean visivelAoInimigo = false;
	
	public Carta(int id) {
		this.id = id;
	}

	public void proximoTurno() {
		if(invocada) {
			turnosInvocada++;
		}
	}
	
	public void invocar(Terreno t) {
		invocada = true;
		terreno = t;
	}

	public int getPreco() {
		return preco;
	}
	
	public boolean ehVisivelAoInimigo() {
		return visivelAoInimigo;
	}
	
	public void setVisibilidadeAoInimigo(boolean b) {
		visivelAoInimigo = b;
	}
	
	public Monarca getDono() {
		return dono;
	}
	
	public void morrer() {
		terreno = null;
		invocada = false;
		dono.enviarCemiterio(this);
	}

	public Terreno getTerreno() {
		return terreno;
	}
}
