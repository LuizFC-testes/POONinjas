package mc322.lab06;

public class Dama extends Peca {
	
    private Dama[] supEsqD,
                supDirD,
                infDirD,
                infEsqD;

    private Peao[] supEsqP,
                supDirP,
                infDirP,
                infEsqP;
    
    Dama[] obterVetorDama (Direcao dir) {
        if (dir == Direcao.NO) {
            return supEsqD;
        } else if (dir == Direcao.NE) {
            return supDirD;
        } else if (dir == Direcao.SE) {
            return infDirD;
        } else {
            return infEsqD;
        }
    }

    Peao[] obterVetorPeao (Direcao dir) {
        if (dir == Direcao.NO) {
            return supEsqP;
        } else if (dir == Direcao.NE) {
            return supDirP;
        } else if (dir == Direcao.SE) {
            return infDirP;
        } else {
            return infEsqP;
        }
    }

    void atualizarVetoresDama(Dama[] supEsq, Dama[] supDir, Dama[] infDir, Dama[] infEsq) {
        this.supEsqD = supEsq;
        this.supDirD = supDir;
        this.infDirD = infDir;
        this.infEsqD = infEsq;
    }

    void atualizarVetoresPeao(Peao[] supEsq, Peao[] supDir, Peao[] infDir, Peao[] infEsq) {
        this.supEsqP = supEsq;
        this.supDirP = supDir;
        this.infDirP = infDir;
        this.infEsqP = infEsq;
    }

    // Construtor

    Dama(CorPeca cor, char coluna, char linha) {
    	super(cor, coluna, linha);
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
        if (i == (distMax - 1) && vetorDirec[i] == null) {
            return -1;
        }
        return i;
    }   

    // Procurar peões

    private int primeiroPeaoNaDirecao(Direcao dir) {
        int distMax, i;
        Peao[] vetorDirec;
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
        if (i == (distMax - 1) && vetorDirec[i] == null) {
            return -1;
        }
        return i;
    }

    boolean temVizinho(Direcao dir) {
        Peao[] vetorDirecP;
        Dama[] vetorDirecD;
        if (dir == Direcao.NO) {
            vetorDirecP = this.supEsqP;
            vetorDirecD = this.supEsqD;
        } else if (dir == Direcao.NE) {
            vetorDirecP = this.supDirP;
            vetorDirecD = this.supDirD;
        } else if (dir == Direcao.SE) {
            vetorDirecP = this.infDirP;
            vetorDirecD = this.infDirD;
        } else {
            vetorDirecP = this.infEsqP;
            vetorDirecD = this.infEsqD;
        }
        if (vetorDirecP[0] != null || vetorDirecD[0] != null) {
            return true;
        }
        return false;
    }

    boolean coresSaoIguaisPeao(Peao p) {
        CorPeca corP = p.getCor();
        if (cor == corP) {
            return true;
        }
        return false;
    }

    boolean coresSaoIguaisDama(Dama d) {
        CorPeca corD = d.getCor();
        if (cor == corD) {
            return true;
        }
        return false;
    }
        
    Direcao procurarJogadaObrigatoriaDama() {
        Direcao[] direcoes = {Direcao.NO, Direcao.NE, Direcao.SE, Direcao.SO};
        int posVetor;
        Dama[] vetorDirecD;
        Peao[] vetorDirecP;
        for (int i = 0; i < 4; i++) {
            vetorDirecD = obterVetorDama(direcoes[i]);
            posVetor = primeiraDamaNaDirecao(direcoes[i]);
            if (posVetor >= 0 && posVetor < (vetorDirecD.length - 1)) {
                if (vetorDirecD[posVetor + 1] == null && !coresSaoIguaisDama(vetorDirecD[posVetor])) {
                    return direcoes[i];
                }
            }
            vetorDirecP = obterVetorPeao(direcoes[i]);
            posVetor = primeiroPeaoNaDirecao(direcoes[i]);
            if (posVetor >= 0 && posVetor < (vetorDirecP.length - 1)) {
                if (vetorDirecP[posVetor + 1] == null && !coresSaoIguaisPeao(vetorDirecP[posVetor])) {
                    return direcoes[i];
                }
            }
        }
        return null;
    }

}