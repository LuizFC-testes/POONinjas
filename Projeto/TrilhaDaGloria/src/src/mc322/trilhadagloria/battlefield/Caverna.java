package mc322.trilhadagloria.battlefield;

import mc322.trilhadagloria.monarch.Dominio;

public class Caverna extends Terreno {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7603867789440250231L;

	public float getBonus(Dominio d) {
		switch(d) {
		case TERRA:
			return 1.1f;
		case FLORA:
			return 0.9f;
		case AR:
			return 0.95f;
		case LUZ:
			return 0.8f;
		case SOMBRA:
			return 1.2f;
		default:
			return 1.0f;
		}
	}

}
