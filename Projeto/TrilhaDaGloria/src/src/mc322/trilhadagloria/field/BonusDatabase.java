package mc322.trilhadagloria.field;

import mc322.trilhadagloria.carta.Dominio;

public class BonusDatabase {
	
	private static final float[][] BONUSBIOMA = {{0.20f, -0.10f,  0.00f, -0.10f,  0.15f, -0.20f,  0.00f,  0.10f},
												{-0.10f,  0.20f, -0.10f,  0.10f, -0.10f, -0.05f,  0.10f, -0.10f},
												{-0.05f, -0.10f,  0.20f,  0.10f, -0.20f,  0.05f,  0.00f,  0.00f},
												{-0.20f,  0.10f,  0.00f,  0.20f, -0.10f,  0.05f,  0.00f,  0.00f},
												{ 0.10f, -0.05f, -0.10f, -0.20f,  0.20f,  0.00f,  0.10f,  0.00f},
												{ 0.05f,  0.00f,  0.05f, -0.10f, -0.10f,  0.20f,  0.00f, -0.05f},
												{ 0.00f,  0.00f,  0.00f,  0.00f,  0.15f,  0.05f,  0.20f, -0.20f},
												{ 0.00f,  0.00f,  0.00f,  0.00f,  0.00f, -0.10f, -0.20f,  0.20f}};
	
	                                                       // TERRA(0), FLORA(1), GELO(2), AGUA(3), FOGO(4), AR(5), LUZ(6), SOMBRA(7);
	private static final float[][] BONUSARMADILHAPODER = 	{{-0.20f,   0.00f,    0.00f,   0.00f,   0.00f,   0.20f, 0.00f,  0.00f},
															{0.20f,    -0.20f,    0.00f,   0.00f,   0.00f,   0.00f, 0.00f,  0.00f},
															{0.00f,     0.00f,   -0.20f,   0.00f,   0.20f,   0.00f, 0.00f,  0.00f},
															{0.00f,     0.00f,    0.00f,  -0.20f,   0.20f,   0.00f, 0.00f,  0.00f},
															{0.00f,     0.00f,    0.20f,   0.00f,  -0.20f,   0.00f, 0.00f,  0.00f},
															{0.20f,     0.00f,    0.00f,   0.00f,   0.00f,  -0.20f, 0.00f,  0.00f},
															{0.00f,     0.00f,    0.00f,   0.00f,   0.00f,   0.00f,-0.20f,  0.20f},
															{0.00f,     0.00f,    0.00f,   0.00f,   0.00f,   0.00f, 0.20f, -0.20f}};
	
	public static float getBonusBiomaHeroi(Bioma bio, Dominio dom) {
		return BONUSBIOMA[dom.getValue()][bio.getValue()];
	}
	
	public static float getBonusArmadilhaPoder(Dominio armadilha, Dominio heroi) {
		return BONUSARMADILHAPODER[armadilha.getValue()][heroi.getValue()];
	}
	
	public static float[] getBonusDeBiomaPara(Dominio dom) {
		float[] bonus = new float[BONUSBIOMA.length];
		
		for(int i = 0; i < BONUSBIOMA.length; i++) {
			bonus[i] = BONUSBIOMA[dom.getValue()][i];
		}
		
		return bonus;
	}
}
