package mc322.trilhadagloria.monarch;

public enum Dominio {
	TERRA(0), FLORA(1), GELO(2), AGUA(3), FOGO(4), AR(5), LUZ(6), SOMBRA(7);

	private int value;

	Dominio(int i) {
		this.value = i;
	}
	
	public int getValue() {
		return value;
	}
}
