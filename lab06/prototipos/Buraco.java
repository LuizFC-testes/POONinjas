import java.util.Random;

public class Buraco extends Componente {

    private Heroi jogador;

    public Buraco(int linha, int coluna, Caverna cave) {
        super(linha, coluna, cave);
        jogador = null;
        this.prioridade = 1;
        gerarEfeito();
    }

    public int capturarHeroi(Heroi jogador) {
        this.jogador = jogador;
        cave.getSala(linha, coluna).removerComponente(jogador);
        anunciar();
        return jogador.morrer();
    }

    public String toString() {
        return "B";
    }

    private void gerarEfeito() {
        String direcoes = {"w", "a", "s", "d"};
        Brisa brisa;
        boolean moveuUltimo;
        for (int i = 0; i < 4; i++) {
            brisa = new Brisa(linha, coluna, cave);
            cave.getSala(linha, coluna).adicionarComponente(brisa);
            moveuUltimo = brisa.mover(direcoes[i]);
        }
        if (!moveuUltimo) {
            cave.getSala(linha, coluna).removerComponente(brisa);
        }
    }

    public void anunciar() {
        Random sorteio = new Random();
        int sorteado = sorteio.nextInt;
        if (sorteado < 3) {
            System.out.println("Você se sente sem chão...");
        } else if (sorteado < 8) {
            System.out.println("Você caiu em um buraco!");
        } else {
            System.out.println("Você sente falta de um lugar para pisar...");
        }
    }
}