package mc322.lab06;

public class Ouro extends Tesouro {

    public Ouro(int linha, int coluna, Caverna cave) {
        super(linha, coluna, cave, 1000);
    }

    public void anunciar() {
        System.out.println("Você encontrou ouro!");
    }

    public String toString() {
        return "O";
    }
}