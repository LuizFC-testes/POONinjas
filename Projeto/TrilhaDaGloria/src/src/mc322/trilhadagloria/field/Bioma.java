package mc322.trilhadagloria.field;

public enum Bioma {
	DESERTO(0), FLORESTA(1), TUNDRA(2), OCEANO(3), VULCANICO(4), MONTANHAS(5), PLANICIE(6), CAVERNA(7);
	
	private int value;

	Bioma(int i) {
		this.value = i;
	}
	
	public int getValue() {
		return value;
	}
}
