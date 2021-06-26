package mc322.trilhadagloria.battlefield;

import mc322.trilhadagloria.monarch.Dominio;

public class Oceano extends Terreno {

	public float getBonus(Dominio d) {
		switch(d) {
		case TERRA:
			return 0.9f;
		case FLORA:
			return 1.1f;
		case GELO:
			return 1.1f;
		case AGUA:
			return 1.2f;
		case FOGO:
			return 0.8f;
		case AR:
			return 0.9f;
		default:
			return 1.0f;
		}
	}
}
