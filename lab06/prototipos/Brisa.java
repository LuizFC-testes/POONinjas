package prototipos;

import java.util.Random;

public class Brisa extends Componente {

    public Brisa(int linha, int coluna, Caverna cave) {
        super(linha, coluna, cave);
    }

    protected void prioridadeEAdd() {
        this.prioridade = 4;
        this.cave.adicionarComponente(this);
    }

    public void anunciar() {
        Random sorteio = new Random();
        int sort = sorteio.nextInt(10);
        if (sort < 8) {
            System.out.println("Você sente uma brisa");
        } else {
            System.out.println("Você se arrepende de não ter trazido um agasalho na mochila");
        }
    }

    public String toString() {
        return "b";
    }
}