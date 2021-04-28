package mc322.damas;

public class AppDamas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	String[] executaJogo(String file) {
		// Le e extrai jogadas do arquivo CSV
		CSVReader csv = new CSVReader();
		csv.setDataSource(file);
		String commands[] = csv.requestCommands();
		
		// String para armazenar resultados intermediarios
		String[] saida = new String[commands.length+1];
		
		// Inicia um novo jogo
		JogoDamas jogo = new JogoDamas();
		
		// Estado inicial do tabuleiro
		saida[0] = jogo.getTabuleiro();
		System.out.println("Tabuleiro inicial:");
		jogo.imprimirTabuleiro();
		
		for(int i = 1; i <= commands.length; i++) {
			// Extrai informações sobre origem e destino
			String origem = commands[i-1].toLowerCase().split(":")[0];
			String destino = commands[i-1].toLowerCase().split(":")[1];
			
			// Efetua a jogada
			jogo.efetuarJogada(origem, destino);
			
			// Salva e imprime estado do tabuleiro após jogada
			saida[i] = jogo.getTabuleiro();
			System.out.println("Source: " + origem);
			System.out.println("Target: " + destino);
			jogo.imprimirTabuleiro();
		}

		return saida;
	}
}
