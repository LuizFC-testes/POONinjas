package mc322.lab05;

public class AppDamas {

	public static void main(String[] args) {
		if(args.length != 2)
			System.out.println("Número incorreto de argumentos");
		
		String[] jogo = executaJogo(args[0], args[1]);
	}
	
	static String[] executaJogo(String fileSource, String fileExport) {
		Tabuleiro jogo = new Tabuleiro(fileSource, fileExport);
		
		// String para armazenar o estado do tabuleiro após cada comando
		String[] saida = jogo.rodarComandos();

		return saida;
	}
}
