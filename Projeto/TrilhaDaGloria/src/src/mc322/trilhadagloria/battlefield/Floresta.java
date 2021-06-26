package mc322.trilhadagloria.battlefield;

import mc322.trilhadagloria.monarch.Dominio;

public class Floresta extends Terreno {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6279516990934155932L;

	public float getBonus(Dominio d) {
		switch(d) {
		case TERRA:
			return 0.9f;
		case FLORA:
			return 1.2f;
		case GELO:
			return 0.9f;
		case AGUA:
			return 1.1f;
		case FOGO:
			return 0.95f;
		default:
			return 1.0f;
		}
	}
}
