package wumpusProc;
import java.util.Random;
//import java.lang.math;

public class MontadorProced {
	Caverna cave;
	Heroi hero;

	public MontadorProced(int qtdLinhas, int qtdColunas, int maxComp) {
		cave = new Caverna(qtdLinhas, qtdColunas, maxComp);
        int[] dimCave = cave.dimensoesCaverna();
        hero = new Heroi(0, 0, cave);
        Random rand = new Random();
        int qtdBuracos = Math.min(dimCave[0], dimCave[1]) - 2 + rand.nextInt(2);
        criarVariosCompAleat("Buraco", qtdBuracos);
        criarCompPosAleat("Wumpus");
        criarCompPosAleat("Ouro");
	}

    private boolean jaExiste(int[] coord, int[][] coords) {
        for (int i = 0; i < coords.length; i++) {
            if (coords[i].equals(coord)) {
                return true;
            }
        }
        return false;
    }

    private int[][] adicionarCoord(int[] coord, int[][] coords) {
        for (int i = 0; i < coords.length; i++) {
            if (coords[i] == null) {
                coords[i] = coord;
                break;
            }
        }
        return coords;
    }

    private void criarVariosCompAleat(String nome, int qtd) {
        int[][] coordenadas = new int[qtd][2];
        for (int i = 0; i < qtd; i++) {
            coordenadas = criarCompPosAleat(nome, coordenadas);
        }
    }

    private int[][] criarCompPosAleat(String nome, int[][] coordenadas) {
        String classpath = "wumpusProc." + nome;
        int[] dimCave = cave.dimensoesCaverna();
        boolean posValida = false;
        Componente novoComp = null;
        int[] coord;
        do {
            coord = sortearCoord(dimCave[0] - 1, dimCave[1] - 1);
            switch (nome) {
                case "Buraco":
                    novoComp = new Buraco(coord[0], coord[1], cave);
                    break;
                case "Wumpus":
                    novoComp = new Wumpus(coord[0], coord[1], cave);
                    break;
                case "Ouro":
                    novoComp = new Ouro(coord[0], coord[1], cave);
                    break;
            }
            posValida = novoComp.salaValida();
            /*System.out.println(nome);
            System.out.println("[" + coord[0] + ", " + coord[1] + "]");
            System.out.println("posValida: " + posValida);
            System.out.println("estaNaCaverna: " + cave.estaNaCaverna(novoComp));
            System.out.println("jaExiste: " + jaExiste(coord, coordenadas));*/
        } while (!posValida || jaExiste(coord, coordenadas) || !cave.estaNaCaverna(novoComp));
        return adicionarCoord(coord, coordenadas);
    }

    private void criarCompPosAleat(String nome) {
        String classpath = "wumpusProc." + nome;
        int[] dimCave = cave.dimensoesCaverna();
        boolean posValida = false;
        Componente novoComp = null;
        do {
            int[] coord = sortearCoord(dimCave[0] - 1, dimCave[1] - 1);
            switch (nome) {
                case "Buraco":
                    novoComp = new Buraco(coord[0], coord[1], cave);
                    break;
                case "Wumpus":
                    novoComp = new Wumpus(coord[0], coord[1], cave);
                    break;
                case "Ouro":
                    novoComp = new Ouro(coord[0], coord[1], cave);
                    break;
            }
            posValida = novoComp.salaValida();
            /*System.out.println(nome);
            System.out.println("[" + coord[0] + ", " + coord[1] + "]");
            System.out.println("posValida: " + posValida);
            System.out.println("estaNaCaverna: " + cave.estaNaCaverna(novoComp));*/
        } while (!posValida || !cave.estaNaCaverna(novoComp));
    }


    private int[] sortearCoord(int maxLinha, int maxColuna) {
        Random sorteador = new Random();
        int[] coord = new int[2];
        do {
            coord[0] = sorteador.nextInt(maxLinha + 1);
            coord[1] = sorteador.nextInt(maxColuna + 1);
        } while (coord[0] == 0 && coord[1] == 0);

        return coord;
    }
	
	public Controle gerarControle() {
		Controle controle = new Controle(hero);
		return controle;
	}
}