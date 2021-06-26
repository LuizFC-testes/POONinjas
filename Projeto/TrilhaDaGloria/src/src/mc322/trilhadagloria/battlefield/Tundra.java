package mc322.trilhadagloria.battlefield;

import mc322.trilhadagloria.monarch.Dominio;

public class Tundra extends Terreno {

	public float getBonus(Dominio d) {
		switch(d) {
		case FLORA:
			return 0.9f;
		case GELO:
			return 1.2f;
		case FOGO:
			return 0.9f;
		case AR:
			return 1.05f;
		default:
			return 1.0f;
		}
	}
}
