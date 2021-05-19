package mc322.lab06;

/**
 * @author João Victor Matoso
 * @author Luiz Felipe Cezar
 */
public class Caverna {
	/** Mapa da caverna constituído a partir de salas */
    private Sala[][] mapa;

    /** Construtor */
    Caverna(int qtdSalas) {
        mapa = new Sala[qtdSalas][qtdSalas];
        for (int i = 0; i < qtdSalas; i++) {
            for (int j = 0; j < qtdSalas; j++) {
                mapa[i][j] = new Sala(i, j, 4);
            }
        }
    }

    /**
     * Retorna uma sala da caverna localizada na linha e coluna especificadas
     */
    public Sala getSala(int linha, int coluna) {
        return mapa[linha][coluna];
    }

    /**
     * Adiciona uma componente na sala que ele deveria estar
     */
    public void adicionarComponente(Componente c) {
        int i = c.getLinha(), j  = c.getColuna();
        mapa[i][j].adicionarComponente(c);
    }

    /**
     * Remove o componente indicado do mapa
     */
    public void removerComponente(Componente c) {
        mapa[c.linha][c.coluna].removerComponente(c);
    }

    /**
     * Move um componente para uma nova posição na caverna
     * @param c - Componente a ser movido
     * @param linha - posição de destino do componente
     * @param coluna - posição de destino do componente
     * @return true se foi possível mover, false senão
     */
    public boolean moverComponente(Componente c, int linha, int coluna) {
        if (posicaoValida(linha,coluna)) {
            removerComponente(c);
            c.atualizarCoord(linha, coluna);
            mapa[linha][coluna].adicionarComponente(c);
            return true;
        }
        return false;
    }

    /**
     * Retorna uma representação atual da caverna. Omite salas que ainda não foram expostas
     */
    public String toString() {
        String mapaStr = "";
        
        for (int i = 0; i < mapa.length; i++) {
            mapaStr += (i+1);
            
            for (int j = 0; j < mapa[0].length; j++) {
                mapaStr += " " + mapa[i][j].toString();
            }
            
            mapaStr += "\n";
        }
        
        mapaStr += "  1 2 3 4";
        
        return mapaStr;
    }

    /**
     * Verifica se uma posição de sala é valida,
     * ou seja, se a sala existe na caverna
     * @return true se sala existe, false senão
     */
    public boolean posicaoValida(int linha, int coluna) {
    	return linha >= 0 && coluna >= 0 && linha < mapa.length && coluna < mapa[0].length;
    }
}