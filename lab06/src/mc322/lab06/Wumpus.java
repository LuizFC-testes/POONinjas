import java.util.Random;

public class Wumpus extends Monstro {
    Wumpus(int linha, int coluna, Caverna cave) {
        super(linha, coluna, cave, 50, 500);
    }

    private void gerarEfeito() {
        String direcoes = {"w", "a", "s", "d"};
        Fedor catinga;
        boolean moveuUltimo;
        for (int i = 0; i < 4; i++) {
            catinga = new Fedor(linha, coluna, cave);
            //cave.getSala(linha, coluna).adicionarComponente(catinga);
            moveuUltimo = catinga.mover(direcoes[i]);
        }
        if (!moveuUltimo) {
            cave.getSala(linha, coluna).removerComponente(catinga);
        }
    }

    private void anularEfeito() {
        Fedor f = new Fedor(linha, coluna, cave);
        int priori = f.getPrioridade();
        for (int i = 0; i < 2; i++) {
            if (cave.getLimites().contains(linha -1 + 2*i)) {
                cave.getSala(linha -1 + 2*i, coluna).removerComponente(priori);
                //remover o fedor da sala (linha -1 + 2*i, coluna)
            }
            if (cave.getLimites().contains(coluna -1 + 2*i)) {
                cave.getSala(linha, coluna -1 + 2*i).removerComponente(priori);
                //remover o fedor da sala (linha, coluna -1 + 2*i)
            }
            cave.getSala(linha, coluna).removerComponente(priori);
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
}