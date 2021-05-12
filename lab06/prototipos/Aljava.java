public class Aljava {
    private int qtdFlechas;
    Flecha flechaAtual;

    Aljava(int qtdFlechas) {
        this.qtdFlechas = qtdFlechas;
        if (this.qtdFlechas > 0) {
            flechaAtual = new Flecha();
        }
    }

    public void equiparFlecha() {
        if (qtdFlechas > 0) {
            flechaAtual.equipar();
        }
    }

    public int contarFlechas() {
        return qtdFlechas;
    }

    public boolean checarFlechaEquip() {
        if (qtdFlechas > 0) {
            return flechaAtual.statusEquipada();
        }
        return false;
    }

    public void dispararFlecha() {
        // Só vai ser chamada se for previamente confirmado de que há uma flecha equipada no momento
        qtdFlechas--;
        if (qtdFlechas > 0) {
            flechaAtual = new Flecha();
        } else {
            flechaAtual = null;
        }
    }
}