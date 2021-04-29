package mc322.lab06;

public class Dama extends Peca {
    
    Dama(CorPeca cor, char coluna, char linha) {
        super(cor, coluna, linha);
    }

    public String toString() {
        if (cor == CorPeca.BRANCA) {
            return "B";
        } else {
            return "P";
        }
    }

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