package wumpusProc;

public class AppMundoWumpus {

	public static void main(String[] args) throws ClassNotFoundException {
		if(args.length != 1) {
			System.out.println("Número incorreto de argumentos. Indique o caminho do arquivo com os dados iniciais do jogo.");
			return;
		}
		
		MontadorProced montador = new MontadorProced(4, 4, 4);
		
		Controle jogo = montador.gerarControle();
		
		jogo.play();
	}
}
