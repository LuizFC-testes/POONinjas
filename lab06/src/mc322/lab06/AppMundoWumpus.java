package mc322.lab06;

/**
 * @author João Victor Matoso
 * @author Luiz Felipe Cezar
 */
public class AppMundoWumpus {

	public static void main(String[] args) throws ClassNotFoundException {
		// Verificação do número correto de argumentos
		// O caminho do arquivo CSV com os dados iniciais da caverna é esperado como argumento
		if(args.length != 1) {
			System.out.println("Número incorreto de argumentos. Indique o caminho do arquivo com os dados iniciais do jogo.");
			return;
		}
		
		Montador montador = new Montador();
		
		// Monta e inicia jogo a partir do arquivo de entrada 
		if(montador.montar(args[0])) {		
			Controle jogo = montador.gerarControle();
			jogo.play();
		}
	}
}
