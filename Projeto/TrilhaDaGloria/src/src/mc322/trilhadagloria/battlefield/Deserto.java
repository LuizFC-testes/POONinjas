package mc322.trilhadagloria.battlefield;

import mc322.trilhadagloria.monarch.Dominio;

public class Deserto extends Terreno {

	public float getBonus(Dominio d) {
		switch(d) {
		case TERRA:
			return 1.2f;
		case FLORA:
			return 0.9f;
		case GELO:
			return 0.95f;
		case AGUA:
			return 0.8f;
		case FOGO:
			return 1.1f;
		case AR:
			return 1.05f;
		default:
			return 1.0f;
		}
	}
}
