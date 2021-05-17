package mc322.lab06;

import java.util.Random;

public class Buraco extends Componente {

    private Heroi jogador;

    public Buraco(int linha, int coluna, Caverna cave) {
        super(linha, coluna, cave);
        jogador = null;
        gerarEfeito();
    }

    protected void prioridadeEAdd() {
        this.prioridade = 1;
        this.cave.adicionarComponente(this);
    }

    public int capturarHeroi(Heroi jogador) {
        this.jogador = jogador;
        cave.getSala(linha, coluna).removerComponente(jogador);
        return jogador.morrer();
    }

    public String toString() {
        return "B";
    }

    protected void gerarEfeito() {
        String[] direcoes = {"w", "a", "s", "d"};
                
        for(int i = 0; i < 4; i++) {
            Brisa brisa = new Brisa(linha, coluna, cave);
            
            if (!brisa.mover(direcoes[i])) {
            	cave.removerComponente(brisa);
            }
        }
    }

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