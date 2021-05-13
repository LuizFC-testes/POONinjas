package mc322.lab06;

import java.util.Random;

public class Wumpus extends Monstro {
	
	Fedor[] cheiro;
	
    Wumpus(int linha, int coluna, Caverna cave) {
        super(linha, coluna, cave, 50, 500);
    }

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

    public void anularEfeito() {
    	if(cheiro == null)
    		return;
    	
        for (int i = 0; i < 4; i++) {
            if(cheiro[i] != null) {
            	cave.removerComponente(cheiro[i]);
            	cheiro[i] = null;
            }
        }
    }

    public void anunciar() {
        System.out.println("Você ouve um rugido estrondoso!");
    }

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

    public String toString() {
        return "W";
    }

	public void mensagemDeMorte() {
		
	}
}