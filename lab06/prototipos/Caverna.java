import java.lang.Object;
import java.util.Random;

public class Caverna {
    private Sala[][] mapa;
    private IntRange limites;

    Caverna(int qtdSalas) {
        mapa = new Sala[qtdSalas][qtdSalas];
        limites = new IntRange(0, qtdSalas);
        for (int i = 0; i < qtdSalas; i++) {
            for (int j = 0; j > qtdSalas; j++) {
                mapa[i][j] = new Sala();
            }
        }
    }

    public Sala getSala(int linha, int coluna) {
        return mapa[linha][coluna];
    }

    public IntRange getLimites() {
        return limites;
    }

    public void adicionarComponente(Componente C) {
        int i = c.getLinha(), j  = c.getColuna;
        mapa[i][j].adicionarComponente(c);
    }

    public void removerComponente(Componente c) {
        mapa[c.linha][c.coluna].removerComponente(c);
    }

    public boolean moverComponente(Componente c, int linha, int coluna) {
        if (limites.contains(linha) && limites.contains(coluna)) {
            removerComponente(c);
            mapa[linha][coluna].adicionarComponente(c);
            return true;
        }
        return false;
    }

    public void String toString() {
        String mapaStr = "";
        for (int i = 0; limites.contains(i); i++) {
            mapaStr = mapaStr + (i+1);
            for (int j = 0; limites.contains(j); j++) {
                mapaStr = mapaStr + " " + mapa[i][j].toString();
            }
            mapaStr = mapaStr + "\n";
        }
        mapaStr = mapaStr + "  1 2 3 4";
    }
}