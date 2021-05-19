package mc322.lab06;

import java.util.Random;

/**
 * @author João Victor Matoso
 * @author Luiz Felipe Cezar
 */
public class Buraco extends Componente {
	/** Objeto heroi que aponta para o heroi que está atualmente dentro do buraco */
    private Heroi jogador;

    /** Construtor */
    public Buraco(int linha, int coluna, Caverna cave) {
        super(linha, coluna, cave);
        jogador = null;
        gerarEfeito();
    }

    /**
     * Atualiza atributo prioridade com a prioridade da classe e adiciona componente na caverna
     */
    protected void prioridadeEAdd() {
        this.prioridade = 1;
        this.cave.adicionarComponente(this);
    }

    /**
     * Função que captura o heroi, o matando
     * @return score desta ação
     */
    public int capturarHeroi(Heroi jogador) {
        this.jogador = jogador;
        cave.getSala(linha, coluna).removerComponente(jogador);
        return jogador.morrer();
    }

    /**
     * Caractere usado na representação no tabuleiro
     */
    public String toString() {
        return "B";
    }

    /**
     * Gera o efeito de brisa nas redondezas do buraco
     */
    protected void gerarEfeito() {
        String[] direcoes = {"w", "a", "s", "d"};
        
        for(int i = 0; i < 4; i++) {
            Brisa brisa = new Brisa(linha, coluna, cave);
            
            if (!brisa.mover(direcoes[i])) {
            	cave.removerComponente(brisa);
            }
        }
    }

    /**
     * Ação de anunciar a presença do componente no console
     */
    public void anunciar() {
        Random sorteio = new Random();
        int sorteado = sorteio.nextInt();
        if (sorteado < 3) {
            System.out.println("Você se sente sem chão...");
        } else if (sorteado < 8) {
            System.out.println("Você caiu em um buraco!");
        } else {
            System.out.println("Você sente falta de um lugar para pisar...");
        }
    }
}