package mc322.trilhadagloria.field;

import mc322.trilhadagloria.monarch.Dominio;

public class BonusBioma {
	
	private static final float[][] BONUSBIOMA = {{0.20f, -0.10f,  0.00f, -0.10f,  0.15f, -0.20f,  0.00f,  0.10f},
												{-0.10f,  0.20f, -0.10f,  0.10f, -0.10f, -0.05f,  0.10f, -0.10f},
												{-0.05f, -0.10f,  0.20f,  0.10f, -0.20f,  0.05f,  0.00f,  0.00f},
												{-0.20f,  0.10f,  0.00f,  0.20f, -0.10f,  0.05f,  0.00f,  0.00f},
												{ 0.10f, -0.05f, -0.10f, -0.20f,  0.20f,  0.00f,  0.10f,  0.00f},
												{ 0.05f,  0.00f,  0.05f, -0.10f, -0.10f,  0.20f,  0.00f, -0.05f},
												{ 0.00f,  0.00f,  0.00f,  0.00f,  0.15f,  0.05f,  0.20f, -0.20f},
												{ 0.00f,  0.00f,  0.00f,  0.00f,  0.00f, -0.10f, -0.20f,  0.20f}};
	
	
	public static float getBonusHeroi(Bioma bio, Dominio dom) {
		return BONUSBIOMA[dom.getValue()][bio.getValue()];
	}
}
