package mc322.lab06;

/**
 * @author João Victor Matoso
 * @author Luiz Felipe Cezar
 */
public class Aljava {
	/** Número de flechas disponíveis */
    private int qtdFlechas;
    
    /** Objeto flecha para armazenar estado da flecha */
    private Flecha flechaAtual;

    /** Construtor */
    Aljava(int qtdFlechas) {
        this.qtdFlechas = qtdFlechas;
        if (this.qtdFlechas > 0) {
            flechaAtual = new Flecha();
        }
    }

    /**
     * Equipa uma das flechas da aljava no arco do personagem
     * @return true se foi possível equipar a flecha, false senão
     */
    public boolean equiparFlecha() {
        if (qtdFlechas > 0) {
            flechaAtual.equipar();
            return true;
        }
        return false;
    }

    /**
     * Retorna o número de flechas na aljava
     */
    public int contarFlechas() {
        return qtdFlechas;
    }

    /**
     * Verifica se existe alguma flecha atualmente equipada
     * @return true se flecha equipada, false senão
     */
    public boolean checarFlechaEquip() {
        if (qtdFlechas > 0) {
            return flechaAtual.statusEquipada();
        }
        return false;
    }

    /**
     * Dispara a flecha atualmente equipada no arco
     */
    public void dispararFlecha() {
        if(checarFlechaEquip()) {
	        qtdFlechas--;
	        if (qtdFlechas > 0) {
	            flechaAtual = new Flecha();
	        } else {
	            flechaAtual = null;
	        }
        }
    }
}