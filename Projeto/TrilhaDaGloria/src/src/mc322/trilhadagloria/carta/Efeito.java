package mc322.trilhadagloria.carta;

public class Efeito {
	private Heroi alvo;
	private Integer turnosRestantes;
	private float bonusDeResistencia;
	private float bonusDeForca;
	
	public Efeito(float bonusResistencia, float bonusForca, Integer turnos) {
		bonusDeResistencia = bonusResistencia;
		bonusDeForca = bonusForca;
		turnosRestantes = turnos;
	}
	
	public void aplicarEfeito(Heroi alvo) {
		this.alvo = alvo;
		alvo.adicionarEfeito(this);
	}
	
	public void aplicarEfeitoBioma(Heroi alvo) {
		this.alvo = alvo;
		alvo.adicionarEfeitoBioma(this);
	}

	public float getBonusDeResistencia() {
		return bonusDeResistencia;
	}

	public float getBonusDeForca() {
		return bonusDeForca;
	}

	public void eliminar() {
		alvo.removerEfeito(this);
	}
	
	public void updateTurno() {
		// Se turno for null, então efeito é permanente
		if(turnosRestantes != null) {
			
			// Se efeito chegou ao fim, elimina-o
			turnosRestantes--;
			
			if(turnosRestantes <= 0) {
				eliminar();
			}
		}
	}

	public void modificarEfeito(float forca, float resistencia) {
		bonusDeForca += forca;
		bonusDeResistencia += resistencia;
	}
}
