package mc322.lab06;

import java.util.Random;

/**
 * @author João Victor Matoso
 * @author Luiz Felipe Cezar
 */
public class Brisa extends Componente {
	/** Construtor */
    public Brisa(int linha, int coluna, Caverna cave) {
        super(linha, coluna, cave);
    }

    /**
     * Atualiza atributo prioridade com a prioridade da classe herdeira e adiciona componente na caverna
     */
    protected void prioridadeEAdd() {
        this.prioridade = 4;
        this.cave.adicionarComponente(this);
    }

    /**
     * Ação de anunciar a presença do componente no console
     */
    public void anunciar() {
        Random sorteio = new Random();
        int sort = sorteio.nextInt(10);
        if (sort < 8) {
            System.out.println("Você sente uma brisa");
        } else {
            System.out.println("Você se arrepende de não ter trazido um agasalho na mochila");
        }
    }

    /**
     * Caractere usado na representação do tabuleiro
     */
    public String toString() {
        return "b";
    }
}