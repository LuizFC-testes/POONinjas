package mc322.trilhadagloria.carta;

import mc322.trilhadagloria.field.Terreno;
import mc322.trilhadagloria.monarch.Monarca;

public abstract class Carta implements IStatusCarta {
	private Integer id;
	protected int turnosInvocada = 0;
	protected Terreno terreno = null;
	protected int preco;
	protected Monarca dono;
	private boolean visivelAoInimigo = false;
	protected Dominio dominio;
	
	public Carta(int id) {
		this.id = id;
	}

	public void proximoTurno() {
		turnosInvocada++;
	}
	
	public Dominio getDominio() {
		return dominio;
	}
	
	public Integer getId() {
		return id;
	}
	
	public int getTurnosInvocada() {
		return turnosInvocada;
	}
	
	public void invocar(Terreno t) {
		terreno = t;
	}

	public int getPreco() {
		return preco;
	}
	
	public boolean estaVisivelAoOponente() {
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
		dono.enviarCemiterio(this);
	}

	public Terreno getTerreno() {
		return terreno;
	}

	public void setDono(Monarca dono) {
		this.dono = dono;
	}
}
