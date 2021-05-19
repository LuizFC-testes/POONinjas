package mc322.lab06;

import java.util.Scanner;

/**
 * @author João Victor Matoso
 * @author Luiz Felipe Cezar
 */
public class Controle {
	/** Ponteiro para o personagem principal do jogo */
	private Heroi hero;
	/** Pontuação atual do jogo */
	private int score;
	
	/** Construtor */
	public Controle(Heroi hero) {
		score = 0;
		this.hero = hero;
	}
	
	/**
	 * Função play
	 * Executa o jogo a partir de comandos lidos do teclado
	 */
	public void play() throws ClassNotFoundException {
		Scanner keyboard = new Scanner(System.in);
		boolean playing = true;
		
		System.out.println("------- Bem-vindo ao Mundo de Wumpus! ------- ");
		System.out.println("Tente resgatar o ouro da caverna sem ser pego pelo Wumpus.");
		
		// Escolha do nome do personagem
		System.out.println("Insira o nome do jogador: ");
		String cmd = keyboard.nextLine();
		
		hero.setName(cmd);
		
		System.out.println("Vamos lá " + hero.getNome() + "!\nDica: a qualquer momento digite /ajuda para obter lista de comandos. Bom jogo!\n");
		
		// Laço principal do jogo
		while(playing) {
			imprimirInterface();
			cmd = keyboard.nextLine();
			playing = executarComando(cmd);
		}
		
		quit();
	}
	
	/**
	 * Imprime no console a interface de jogo para o user final
	 * Imprime mapa e informações adicionais
	 */
	private void imprimirInterface() throws ClassNotFoundException {
		// Imprimir mapa da caverna
		hero.exibirMapa();
		
		// Dados e status atuais da partida
		System.out.println("Player: " + hero.getNome());
		System.out.println("Score: " + score);
		System.out.print("Flechas: " + hero.contarFlechas());
		if (hero.flechaEquipada()) {
			System.out.print(" (equipada)");
		}
		System.out.print("\n");
		
		// Contagem de tesouros
		String[] tiposTesouros = {"mc322.lab06.Ouro"};
		int[] contagemEspolios = hero.checarEspolios(tiposTesouros);
		for (int i = 0; i < tiposTesouros.length; i++) {
			System.out.print(Class.forName(tiposTesouros[i]).getSimpleName() + ": " + contagemEspolios[i] + "	");
		}
		System.out.println("\n");
	}
	
	/**
	 * Executa um comando do teclado dado pelo usuário
	 * @return true se o jogo ainda está rodando, false se o jogo acabou
	 */
	private boolean executarComando(String cmd) {
		switch(cmd) {
		// Caso seja um comando de movimento, score é acumulado
		case "w":
		case "s":
		case "d":
		case "a":
			score += hero.moverHeroi(cmd);
			break;
		
		// Equipar uma flecha
		case "k":
			hero.equiparFlecha();
			break;
		
		// Capturar o tesouro
		case "c":
			hero.capturarTesouro();
			break;
		
		// Sair do jogo
		case "q":
			return false;
		
		// Obter ajuda
		case "/ajuda":
			listCommands();
			break;
		
		// Entrada inválida
		default:
			System.out.println("Entrada inválida. Digite /ajuda para lista de comandos");
		}
		
		// Jogo continuará enquanto heroi estiver vivo
		return hero.getStatusVivo();
	}
	
	/**
	 * Função de fim de jogo. Verifica se jogador ganhou, perdeu ou simplesmente saiu
	 * Imprime no console um resumo da partida
	 */
	private void quit() throws ClassNotFoundException {
		int fortuna = hero.contarFortuna();
		
		System.out.println("------ Fim de jogo -------");
		
		// Caso heroi ainda está vivo
		if(hero.getStatusVivo()) {
			// Se heroi está na porta da caverna e com algum tesouro, ele ganha
			if(hero.estaNaPorta() && fortuna > 0) {
				score += fortuna;
			
				imprimirInterface();
				System.out.println("Parabéns " + hero.getNome() + ", você ganhou !!!");
			} else {
				imprimirInterface();
				System.out.println("Volte sempre!");
			}
		}
		// Caso heroi morreu
		else {
			imprimirInterface();
			System.out.println("Você perdeu...");
		}
	}
	
	/**
	 * Função de ajuda. Lista os comandos possíveis do jogo
	 */
	private void listCommands() {
		System.out.println("\n------ Lista de comandos ------");
		System.out.println("w/a/s/d -> mover herói");
		System.out.println("k -> equipar flecha");
		System.out.println("c -> capturar ouro");
		System.out.println("q -> sair");
		System.out.println("-------------------------------\n");
	}
}
