package wumpusProc;

public class Flecha {
    boolean equipada;

    public Flecha() {
        equipada = false;
    }

    public void equipar() {
        equipada = true;
    }

    public boolean statusEquipada() {
        return equipada;
    }
}