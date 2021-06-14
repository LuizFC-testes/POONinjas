package mc322.trilhadagloria.monarch;

import mc322.trilhadagloria.battlefield.Terreno;

public abstract class Carta {
	protected boolean invocada = false;
	protected int turnosInvocada = 0;
	protected Terreno terreno = null;
	
	public void proximoTurno() {
		if(invocada) {
			turnosInvocada++;
		}
	}
	
	public abstract void invocar();
}
