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

    String converterPosicaoVetores(int pos, Direcao dir) {
        char colunaPos = this.coluna,
            linhaPos = this.linha;
        if (dir == Direcao.NE || dir == Direcao.NO) {
            linhaPos += (pos + 1);
        } else {
            linhaPos -= (pos + 1);
        }
        if (dir == Direcao.NO || dir == Direcao.SO) {
            colunaPos -= (pos + 1);
        } else {
            colunaPos += (pos + 1);
        }
        return "" + colunaPos + linhaPos;
    }

    // Procurar damas

    private int primeiraDamaNaDirecao(Direcao dir) {
        int distMax, i;
        Dama[] vetorDirec;
        if (dir == Direcao.NO) {
            vetorDirec = supEsqD;
        } else if (dir == Direcao.NE) {
            vetorDirec = supDirD;
        } else if (dir == Direcao.SE) {
            vetorDirec = infDirD;
        } else {
            vetorDirec = infEsqD;
        }
        distMax = vetorDirec.length;
        for (i = 0; i < distMax; i++) {
            if (vetorDirec[i] != null) {
                break;
            }
        }
        return i;
    }   

    // Procurar peões

    private int primeiroPeaoNaDirecao(Direcao dir) {
        int distMax, i;
        Dama[] vetorDirec;
        if (dir == Direcao.NO) {
            vetorDirec = supEsqP;
        } else if (dir == Direcao.NE) {
            vetorDirec = supDirP;
        } else if (dir == Direcao.SE) {
            vetorDirec = infDirP;
        } else {
            vetorDirec = infEsqP;
        }
        distMax = vetorDirec.length;
        for (i = 0; i < distMax; i++) {
            if (vetorDirec[i] != null) {
                break;
            }
        }
        return i;
    }

}