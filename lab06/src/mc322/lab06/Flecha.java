package mc322.lab06;

/**
 * @author João Victor Matoso
 * @author Luiz Felipe Cezar
 */
public class Flecha {
	/** Status da flecha, se equipada ou não */
    boolean equipada;

    /** Construtor */
    public Flecha() {
        equipada = false;
    }

    /**
     * Equipar a flecha, altera seu status
     */
    public void equipar() {
        equipada = true;
    }

    /**
     * Retorna o status da flecha
     */
    public boolean statusEquipada() {
        return equipada;
    }
}