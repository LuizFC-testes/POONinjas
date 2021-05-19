package mc322.lab06;

import java.util.Random;

/**
 * @author João Victor Matoso
 * @author Luiz Felipe Cezar
 */
public class Wumpus extends Monstro {
	/** Efeito de fedor gerado pelo monstro */
    Fedor[] cheiro;

    /** Construtor */
    Wumpus(int linha, int coluna, Caverna cave) {
        super(linha, coluna, cave, 50, 500);
    }

    /**
     * Gera o efeito de fedor nas redondezas do Wumpus
     */
    protected void gerarEfeito() {
        String[] direcoes = {"w", "a", "s", "d"};
        
        if(cheiro != null)
        	return;
        else
        	cheiro = new Fedor[4];
        
        for(int i = 0; i < 4; i++) {
            cheiro[i] = new Fedor(linha, coluna, cave);
            
            if (!cheiro[i].mover(direcoes[i])) {
            	cave.removerComponente(cheiro[i]);
            	cheiro[i] = null;
            }
        }
    }

    /**
     * Elimina o efeito de fedor das redondezas do Wumpus
     */
    protected void anularEfeito() {
        if(cheiro == null)
    		return;
    	
        for (int i = 0; i < 4; i++) {
            if(cheiro[i] != null) {
            	cave.removerComponente(cheiro[i]);
            	cheiro[i] = null;
            }
        }
    }

    /**
     * Ação de anunciar a presença do componente no console
     */
    public void anunciar() {
        System.out.println("Você ouve um rugido estrondoso!");
    }

    /**
     * Anucia vitória do monstro no caso de combate
     */
    public void mensagemDeVitoria() {
        Random rand = new Random();
        int sorteio = rand.nextInt(10);
        if (sorteio < 8) {
            System.out.println("Wumpus levou a melhor...");
        } else if (sorteio == 8) {
            System.out.println("Wumpus te fez picadinho...");
        } else {
            System.out.println("Wumpus agora pede pelo prato principal");
        }
    }

    /**
     * Anuncia a morte do monstro
     */
    public void mensagemDeMorte() {
        System.out.println("Você matou Wumpus!");
    }

    /**
     * Caractere usado na representação no tabuleiro
     */
    public String toString() {
        return "W";
    }
}