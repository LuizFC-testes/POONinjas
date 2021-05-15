package mc322.lab05a;

/**
 * @author João Victor Matoso
 * @author Luiz Felipe Cezar
 */
public class Dama extends Peca {
    /** Construtor */
    Dama(CorPeca cor, char coluna, char linha) {
        super(cor, coluna, linha);
    }

    /****************** Metodos públicos *********************/
    /**
     * Retorna uma representação da dama dependendo de sua cor
     */
    public String toString() {
        if (cor == CorPeca.BRANCA) {
            return "B";
        } else {
            return "P";
        }
    }

	/**
	 * Dada uma trajetoria com o caminho que uma peça passará,
	 * decide se o movimento é realizavel ou não
	 * @param trajetoria - array de peças com a trajetória do movimento
	 * @return true se é possível, false se não é possível
	 */
    public boolean movimentoEhPossivel(Peca[] trajetoria) {
        int distancia = trajetoria.length;
        for (int i = 0; i < distancia - 1; i++) {
            if (trajetoria[i] != null) {
                if (trajetoria[i].getCor() == cor) {
                    return false;
                } else {
                    if (trajetoria[i+1] != null) {
                        return false;
                    }
                }
            }
        }
        if (trajetoria[distancia-1] == null) {
            return true;
        } else {
            return false;
        }
    }

}