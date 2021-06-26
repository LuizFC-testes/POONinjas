package mc322.trilhadagloria.battlefield;

import mc322.trilhadagloria.monarch.Dominio;

public class Planicie extends Terreno {

	public float getBonus(Dominio d) {
		switch(d) {
		case FLORA:
			return 1.1f;
		case FOGO:
			return 1.1f;
		case LUZ:
			return 1.2f;
		case SOMBRA:
			return 0.8f;
		default:
			return 1.0f;
		}
	}
}
