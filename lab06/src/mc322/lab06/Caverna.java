package mc322.lab06;

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
        mapa[i][j].adicionarComponente(c);
    }

    public void removerComponente(Componente c) {
        mapa[c.linha][c.coluna].removerComponente(c);
    }

    public boolean moverComponente(Componente c, int linha, int coluna) {
        if (linha >= 0 && coluna >= 0 && linha < mapa.length && coluna < mapa[0].length) {
            removerComponente(c);
            c.atualizarCoord(linha, coluna);
            mapa[linha][coluna].adicionarComponente(c);
            return true;
        }
        return false;
    }

    public String toString() {
        String mapaStr = "";
        for (int i = 0; i < mapa.length; i++) {
            mapaStr = mapaStr + (i+1);
            for (int j = 0; i < mapa[0].length; j++) {
                mapaStr = mapaStr + " " + mapa[i][j].toString();
            }
            mapaStr = mapaStr + "\n";
        }
        mapaStr = mapaStr + "  1 2 3 4";
        return mapaStr;
    }
}