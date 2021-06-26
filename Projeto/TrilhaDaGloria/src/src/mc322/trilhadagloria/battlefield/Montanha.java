package mc322.trilhadagloria.battlefield;

import mc322.trilhadagloria.monarch.Dominio;

public class Montanha extends Terreno {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1297096898951643520L;

	public float getBonus(Dominio d) {
		switch(d) {
		case TERRA:
			return 0.8f;
		case FLORA:
			return 0.95f;
		case GELO:
			return 1.05f;
		case AGUA:
			return 1.05f;
		case AR:
			return 1.2f;
		case LUZ:
			return 1.05f;
		case SOMBRA:
			return 0.8f;
		default:
			return 1.0f;
		}
	}
}
