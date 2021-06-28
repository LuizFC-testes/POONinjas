package mc322.trilhadagloria.carta;

import java.awt.Color;

public interface IStatusHeroi {

    public Color getCorReino();

    public String getClasse();

    public int getAlcance();

    public int[] getForcaBase();

    public int[] getResistBase();

    public float[] getBonusHero();

    public String getHabPass();

    public String getHabAt();
    
    public Dominio getDominio();

}