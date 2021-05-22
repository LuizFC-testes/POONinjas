package prototipos;

public class Caverna {
    private Sala[][] mapa;

    Caverna(int qtdSalas) {
        mapa = new Sala[qtdSalas][qtdSalas];
        for (int i = 0; i < qtdSalas; i++) {
            for (int j = 0; j < qtdSalas; j++) {
                mapa[i][j] = new Sala(i, j, 4);
            }
        }
    }

    public Sala getSala(int linha, int coluna) {
        return mapa[linha][coluna];
    }

    public void adicionarComponente(Componente c) {
        int i = c.getLinha(), j  = c.getColuna();
        //System.out.println(i + ", " + j);
        mapa[i][j].adicionarComponente(c);
    }

    public void removerComponente(Componente c) {
        mapa[c.linha][c.coluna].removerComponente(c);
    }

    public boolean moverComponente(Componente c, int linha, int coluna) {
        if (posicaoValida(linha,coluna)) {
            removerComponente(c);
            c.atualizarCoord(linha, coluna);
            mapa[linha][coluna].adicionarComponente(c);
            return true;
        }
        return false;
    }

    public String toString() {
        String mapaStr = "";
        for (int i = 0; i < mapa.length; i++) { //Voltar para o genérico depois
            mapaStr = mapaStr + (i+1);
            for (int j = 0; j < mapa[0].length; j++) { //Voltar para o genérico depois
                //System.out.println("[" + mapa.length + ", " + mapa[0].length + "]");
                //System.out.println(i + ", " + j);
                mapaStr = mapaStr + " " + mapa[i][j].toString();
            }
            mapaStr = mapaStr + "\n";
        }
        mapaStr = mapaStr + "  1 2 3 4";
        return mapaStr;
    }

    public boolean posicaoValida(int linha, int coluna) {
    	return linha >= 0 && coluna >= 0 && linha < mapa.length && coluna < mapa[0].length;
    }
}