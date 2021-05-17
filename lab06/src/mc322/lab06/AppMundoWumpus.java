package mc322.lab06;

public class AppMundoWumpus {

	public static void main(String[] args) throws ClassNotFoundException {
		if(args.length != 1) {
			System.out.println("Número incorreto de argumentos. Indique o caminho do arquivo com os dados iniciais do jogo.");
			return;
		}
		
		Montador montador = new Montador();
		
		if(montador.montar(args[0])) {		
			Controle jogo = montador.gerarControle();
			jogo.play();
		}
	}
}
