package mc322.lab05;

/**
 * @author João Victor Matoso
 * @author Luiz Felipe Cezar
 */
public class AppDamas {

	/**
	 * Função main - necessita dois argumentos: caminho do arquivo de entrada com as jogadas a serem realizadas, 
	 *               caminho do arquivo de saída com estado final do tabuleiro
	 */
	public static void main(String[] args) {
		if(args.length != 2)
			System.out.println("Número incorreto de argumentos");
		else {
			String[] jogo = executaJogo(args[0], args[1]);
		}
	}
	
	/**
	 * Função que executa todas as jogadas do arquivo de entrada, e escreve no arquivo de saída
	 * o estado final do tabuleiro após todas as jogadas
	 * @param fileSource - caminho do arquivo de entrada
	 * @param fileExport - caminho do arquivo de saída
	 * @return vetor de strings com estados intermediarios do tabuleiro após cada jogada
	 */
	static String[] executaJogo(String fileSource, String fileExport) {
		Tabuleiro jogo = new Tabuleiro(fileSource, fileExport);
		
		// String para armazenar o estado do tabuleiro após cada comando
		String[] saida = jogo.rodarComandos();

		return saida;
	}
}
