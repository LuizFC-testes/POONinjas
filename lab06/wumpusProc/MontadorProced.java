package wumpusProc;
import java.util.Random;
import java.lang.math;

public class MontadorProced {
	Caverna cave;
	Heroi hero;

	public Montador(int qtdLinhas, int qtdColunas, int maxComp) {
		cave = new Caverna(qtdLinhas, qtdColunas, maxComp);
        hero = new Heroi(0, 0, cave);
        // Implementar o criador aleatório de Componente

	}

    private criarCompPosAleat(String nome) {
        String classpath = "wumpusProc." + nome;
        int[] dimCave = cave.dimensoesCaverna();
        int[] coord = sortearCoord(dimCave[0] - 1, dimCave[1] - 1);
        boolean posValida = false;
        while (!posValida) {
            Componente novoComp = //Continuar usando Reflection
        }
    }

    private sortearCoord(int maxLinha, int maxColuna) {
        Random sorteador = new Random();
        int[] coord = new int[2];
        coord[0] = sorteador.nextInt(maxLinha + 1);
        coord[1] = sorteador.nextInt(maxColuna + 1);
        return coord;
    }
	
	public Controle gerarControle() {
		Controle controle = new Controle(hero);
		return controle;
	}
}