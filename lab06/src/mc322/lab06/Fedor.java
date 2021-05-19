package mc322.lab06;

import java.util.Random;

/**
 * @author João Victor Matoso
 * @author Luiz Felipe Cezar
 */
public class Fedor extends Componente {
	/** Construtor */
    public Fedor(int linha, int coluna, Caverna cave) {
        super(linha, coluna, cave);
    }

    /**
     * Atualiza atributo prioridade com a prioridade da classe herdeira e adiciona componente na caverna
     */
    protected void prioridadeEAdd() {
        this.prioridade = 3;
        this.cave.adicionarComponente(this);
    }

    /**
     * Ação de anunciar a presença do componente no console
     */
    public void anunciar() {
        Random sorteio = new Random();
        int sort = sorteio.nextInt();
        if (sort < 8) {
            System.out.println("Você sente uma catinga nauseante");
        } else {
            System.out.println("Você se pergunta quando foi a última vez que tomou banho");
        }
    }

    /**
     * Caractere usado na representação no tabuleiro
     */
    public String toString() {
        return "f";
    }
}