package wumpusProc;

public class AppMundoWumpus {

	public static void main(String[] args) throws ClassNotFoundException {
		MontadorProced montador = new MontadorProced(4, 4, 4);
		
		Controle jogo = montador.gerarControle();
		
		jogo.play();
	}
}
