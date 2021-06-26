package mc322.trilhadagloria.battlefield;

import mc322.trilhadagloria.monarch.Dominio;

public class Vulcanico extends Terreno {

	public float getBonus(Dominio d) {
		switch(d) {
		case TERRA:
			return 1.15f;
		case FLORA:
			return 0.9f;
		case GELO:
			return 0.8f;
		case AGUA:
			return 0.9f;
		case FOGO:
			return 1.2f;
		case AR:
			return 0.9f;
		case LUZ:
			return 1.15f;
		default:
			return 1.0f;
		}
	}
}
