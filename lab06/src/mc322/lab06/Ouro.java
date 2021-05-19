package mc322.lab06;

/**
 * @author João Victor Matoso
 * @author Luiz Felipe Cezar
 */
public class Ouro extends Tesouro {
	/** Construtor */
    public Ouro(int linha, int coluna, Caverna cave) {
        super(linha, coluna, cave, 1000);
    }

    /**
     * Ação de anunciar a presença do componente no console
     */
    public void anunciar() {
        System.out.println("Você encontrou ouro!");
    }
    
    /**
     * Caractere usado na representação no tabuleiro
     */
    public String toString() {
        return "O";
    }
}