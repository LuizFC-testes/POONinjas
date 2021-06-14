package mc322.trilhadagloria.monarch;

public abstract class Heroi extends Carta {
	protected int forca[];
	protected int resistencia[];
	protected int alcance;
	protected Dominio dominio;
	
	public Heroi(Dominio dominio) {
		this.dominio = dominio;
	}
	
	public int[] getForca() {
		return forca;
	}
	
	public void setForca(int[] forca) {
		this.forca = forca;
	}
	
	public int[] getResistencia() {
		return resistencia;
	}
	
	public void setResistencia(int[] resistencia) {
		this.resistencia = resistencia;
	}
	
	public int getAlcance() {
		return alcance;
	}
	
	public void setAlcance(int alcance) {
		this.alcance = alcance;
	}
	
	public Dominio getDominio() {
		return dominio;
	}
	
	public void setDominio(Dominio dominio) {
		this.dominio = dominio;
	}
	
	public void invocar() {
		invocada = true;
	}
}
