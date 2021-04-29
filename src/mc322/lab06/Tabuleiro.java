package mc322.lab06;

public class Tabuleiro {
	
	private Peca[][] tab;
	private int pecasBrancas;
	private int pecasPretas;
	private int cmdDaVez;
	private CSVHandling controle;
	
	public Tabuleiro(String dataSource, String dataExport) {
		controle = new CSVHandling();
//		controle.setDataSource(dataSource);
//		controle.setDataExport(dataExport);
		
		tab = new Peca[8][8];
		
		// Inicializa peões brancos
		for(char lin = '1'; lin <= '3'; lin++) {
			for(char col = 'a'; col <= 'h'; col++) {
				if(posicaoValida(col,lin)) {
					tab[charToIndex(col)][charToIndex(lin)] = new Peao(CorPeca.BRANCA, col, lin);
				}
			}
		}
		
		// Inicializa peões pretos
		for(char lin = '6'; lin <= '8'; lin++) {
			for(char col = 'a'; col <= 'h'; col++) {
				if(posicaoValida(col,lin)) {
					tab[charToIndex(col)][charToIndex(lin)] = new Peao(CorPeca.PRETA, col, lin);
				}
			}
		}
		
		pecasBrancas = 12;
		pecasPretas = 12;
		cmdDaVez = 0;
	}
	
	public Peca getPeca(String coord) {
		return tab[charToIndex(coord.charAt(0))][charToIndex(coord.charAt(1))];
	}
	
	public Peca getPeca(char col, char lin) {
		return tab[charToIndex(col)][charToIndex(lin)];
	}
	
	/** Imprime tabuleiro na saída padrão com coordenadas */
	public void imprimirTabuleiro() {
		String[] sTab = toString().split("\n");
		
		System.out.println("8 " + sTab[0]);
		System.out.println("7 " + sTab[1]);
		System.out.println("6 " + sTab[2]);
		System.out.println("5 " + sTab[3]);
		System.out.println("4 " + sTab[4]);
		System.out.println("3 " + sTab[5]);
		System.out.println("2 " + sTab[6]);
		System.out.println("1 " + sTab[7]);
		System.out.println("  a b c d e f g h\n");
	}
	
	public String toString() {
		String s = "";
		
		for(char lin = '8'; lin >= '1'; lin--) {
			for(char col = 'a'; col <= 'h'; col++) {
				if(getPeca(col,lin) == null)
					s += "- ";
				else
					s += getPeca(col,lin).toString() + " ";
			}
			s += "\n";
		}
		
		return s;
	}

	public boolean solicitaMovimento() {
		
		if(cmdDaVez >= controle.requestCommands().length)
			return false;
		
		String origem = controle.requestCommands()[cmdDaVez].split(":")[0];
		String destino = controle.requestCommands()[cmdDaVez].split(":")[1];
		
		if(posicaoValida(origem) && posicaoValida(destino)) {
			if(getPeca(origem).movimentoEhPossivel(gerarTrajetoria(origem, destino))) {
				tab[charToIndex(destino.charAt(0))][charToIndex(destino.charAt(1))] = getPeca(origem);
				tab[charToIndex(origem.charAt(0))][charToIndex(origem.charAt(1))] = null;
			}
		}
		
		cmdDaVez++;
		
		return false;
	}
	
	private Peca[] gerarTrajetoria(String origem, String destino) {
		int distancia = calcularDistancia(origem, destino);
		
		Peca[] trajetoria = new Peca[distancia];
		
		
		
		return  trajetoria;
	}
	
	private int calcularDistancia(String origem, String destino) {
		int dist = 
		return 0;
	}

	private int charToIndex(char c) {
		if(c == 'a' || c == '1')
			return 0;
		if(c == 'b' || c == '2')
			return 1;
		if(c == 'c' || c == '3')
			return 2;
		if(c == 'd' || c == '4')
			return 3;
		if(c == 'e' || c == '5')
			return 4;
		if(c == 'f' || c == '6')
			return 5;
		if(c == 'g' || c == '7')
			return 6;
		if(c == 'h' || c == '8')
			return 7;
		return -1;
	}
	
	/** Verifica se string contem uma posição valida do tabuleiro */
	private Boolean posicaoValida(char col, char lin) {
		return posicaoValida("" + col + lin);
	}
	
	private Boolean posicaoValida(String cmd) {
		if(cmd.matches("^[a-h][1-8]$")) {
			char col = cmd.charAt(0);
			char lin = cmd.charAt(1);
			
			if((col == 'a' || col == 'c' || col == 'e' || col == 'g') && (lin == '1' || lin == '3' || lin == '5' || lin == '7'))
				return true;
			
			if((col == 'b' || col == 'd' || col == 'f' || col == 'h') && (lin == '2' || lin == '4' || lin == '6' || lin == '8'))
				return true;
		}
		return false;
	}
}
