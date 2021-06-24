package mc322.trilhadagloria.monarch;

import java.util.ArrayList;

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
	
	public int[] getForca() {
		return forca;
	}
	
	public int[] getResistencia() {
		return resistencia;
	}
	
	public int getAlcance() {
		return alcance;
	}
	
	public Dominio getDominio() {
		return dominio;
	}
	
	public void adicionarEfeito(Efeito efeito) {
		sobEfeito.add(efeito);
		efeito.adicionarHeroi(this);
	}
}
