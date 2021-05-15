package prototipos;

import java.util.Random;

public class Fedor extends Componente {

    public Fedor(int linha, int coluna, Caverna cave) {
        super(linha, coluna, cave);
        this.prioridade = 3;
    }

    public void anunciar() {
        Random sorteio = new Random();
        int sort = sorteio.nextInt();
        if (sort < 8) {
            System.out.println("Você sente uma catinga nauseante");
        } else {
            System.out.println("Você se pergunta quando foi a última vez que tomou banho");
        }
    }

    public String toString() {
        return "f";
    }
}