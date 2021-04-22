package mc322.damas;

public class Dama {
    private CorPeca cor;
    private char linha,
                coluna;
    private Dama[] supEsqD,
                supDirD,
                infDirD,
                infEsqD;

    private Peao[] supEsqP,
                supDirP,
                infDirP,
                infEsqP;
    
    char getColuna() {
        return this.coluna;
    }

    void setColuna(char novaColuna) {
        this.coluna = novaColuna;
    }

    char getLinha() {
        return this.linha;
    }

    void setLinha(char novaLinha) {
        this.linha = novaLinha;
    }

    Dama(CorPeca cor, char coluna, char linha) {
        this.cor = cor;
        setColuna(coluna);
        setLinha(linha);
    }

    // Converter posições relativas dos vetores

    String converterPosicaoSE(int posSE) {
        // Obtém a coordenada da casa indicada pela posição de um
        // vetor "superior esquerdo"
        char colunaPos = this.coluna - posSE, 
            linhaPos = this.linha + posSE;
        return "" + colunaPos + linhaPos;
    }

    String converterPosicaoSE(int posSE) {
        // Obtém a coordenada da casa indicada pela posição de um
        // vetor "superior esquerdo"
        char colunaPos = this.coluna - posSE, 
            linhaPos = this.linha + posSE;
        return "" + colunaPos + linhaPos;
    }

    // Procurar damas

    private int primeiraDamaSupEsq() {
        int distMax = supEsqD.length;
        for (int i = 0; i < distMax; i++) {
            if (supEsqD[i] != null) {
                break;
            }
        }
        return i;
    }

    private int primeiraDamaSupDir() {
        int distMax = supDirD.length;
        for (int i = 0; i < distMax; i++) {
            if (supDirD[i] != null) {
                break;
            }
        }
        return i;
    }

    private int primeiraDamaInfDir() {
        int distMax = infDirD.length;
        for (int i = 0; i < distMax; i++) {
            if (infDirD[i] != null) {
                break;
            }
        }
        return i;
    }    

    private int primeiraDamaInfEsq() {
        int distMax = infEsqD.length;
        for (int i = 0; i < distMax; i++) {
            if (infEsqD[i] != null) {
                break;
            }
        }
        return i;
    }        

    // Procurar peões

    private int primeiroPeaoSupEsq() {
        int distMax = supEsqP.length;
        for (int i = 0; i < distMax; i++) {
            if (supEsqP[i] != null) {
                break;
            }
        }
        return i;
    }

    private int primeiroPeaoSupDir() {
        int distMax = supDirP.length;
        for (int i = 0; i < distMax; i++) {
            if (supDirP[i] != null) {
                break;
            }
        }
        return i;
    }

    private int primeiroPeaoInfDir() {
        int distMax = infDirP.length;
        for (int i = 0; i < distMax; i++) {
            if (infDirP[i] != null) {
                break;
            }
        }
        return i;
    }    

    private int primeiroPeaoInfEsq() {
        int distMax = infEsqP.length;
        for (int i = 0; i < distMax; i++) {
            if (infEsqP[i] != null) {
                break;
            }
        }
        return i;
    }
}