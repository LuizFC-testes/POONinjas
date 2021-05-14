package mc322.lab06;

import java.util.Scanner;

public class Controle {
	private Heroi hero;
	private int score;
	
	public Controle(Heroi hero) {
		score = 0;
		this.hero = hero;
	}
	
	public void play() {
		Scanner keyboard = new Scanner(System.in);
		boolean playing = true;
		
		System.out.println("------- Bem-vindo ao Mundo de Wumpus! ------- ");
		System.out.println("Tente resgatar o ouro da caverna sem ser pego pelo Wumpus.");
		System.out.println("Insira o nome do jogador: ");
		
		String cmd = keyboard.nextLine();
		
		hero.setName(cmd);
		
		System.out.println("Vamos lá " + hero.getNome() + "!\nDica: a qualquer momento digite /ajuda para obter lista de comandos. Bom jogo!\n");
		
		while(playing) {
			imprimirInterface();
			cmd = keyboard.nextLine();
			
			playing = executarComando(cmd);
		}
		
		quit();
	}
	
	private void imprimirInterface() {
		hero.exibirMapa();
		System.out.println("Player: " + hero.getNome());
		System.out.println("Score: " + score);
		System.out.print("Flechas: " + hero.contarFlechas());
		if (hero.flechaEquipada()) {
			System.out.print(" (equipada)");
		}
		System.out.print("\n");
		// Imprimir quantidade de ouros
	}
	
	private boolean executarComando(String cmd) {
		switch(cmd) {
		case "w":
		// bizuzin
			/*score += hero.moverHeroi(cmd);
			break;*/
			
		case "s":
			/*score += hero.moverHeroi(cmd);
			break;*/
			
		case "d":
			/*score += hero.moverHeroi(cmd);
			break;*/
			
		case "a":
			score += hero.moverHeroi(cmd);
			break;
			
		case "k":
			hero.equiparFlecha();
			break;
			
		case "c":
			hero.capturarTesouro();
			break;
			
		case "q":
			return false;
			
		case "/list":
			listCommands();
			break;
			
		default:
			System.out.println("Entrada inválida. Digite /list para lista de comandos");
		}
		
		return hero.getStatusVivo();
	}
	
	private void quit() {
		int fortuna = hero.contarFortuna();
		
		System.out.println("------ Fim de jogo -------");
		
		if(hero.getStatusVivo()) {
			if(hero.estaNaPorta() && fortuna > 0) {
				score += fortuna;
			
				imprimirInterface();
				System.out.println("Parabéns " + hero.getNome() + ", você ganhou !!!");
			} else {
				imprimirInterface();
				System.out.println("Volte sempre!");
			}
		} else {
			imprimirInterface();
			System.out.println("Você perdeu...");
		}
	}
	
	private void listCommands() {
		System.out.println("Lista de comandos");
		System.out.println("w/a/s/d -> mover herói");
		System.out.println("k -> equipar flecha");
		System.out.println("c -> capturar ouro");
		System.out.println("q -> sair");
	}
}
