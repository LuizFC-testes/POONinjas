package mc322.lab06;

import java.lang.Math;

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

	public int getPecasBrancas() {
		return pecasBrancas;
	}

	public void setPecasBrancas(int pecasBrancas) {
		this.pecasBrancas = pecasBrancas;
	}

	public int getPecasPretas() {
		return pecasPretas;
	}

	public void setPecasPretas(int pecasPretas) {
		this.pecasPretas = pecasPretas;
	}
	
	public Peca getPeca(String coord) {
		char coluna = coord.charAt(0),
			 linha = coord.charAt(1);
		return getPeca(coluna, linha);
	}
	
	public Peca getPeca(char col, char lin) {
		return tab[charToIndex(col)][charToIndex(lin)];
	}
	
	/** Imprime tabuleiro na saída padrão com coordenadas */
	public void imprimirTabuleiro() {
		String[] sTab = toString().split("\n");
		
		System.out.println("8" + sTab[0]);
		System.out.println("7" + sTab[1]);
		System.out.println("6" + sTab[2]);
		System.out.println("5" + sTab[3]);
		System.out.println("4" + sTab[4]);
		System.out.println("3" + sTab[5]);
		System.out.println("2" + sTab[6]);
		System.out.println("1" + sTab[7]);
		System.out.println("  a b c d e f g h");
	}
	
	public String toString() {
		String s = "";
		
		for(char lin = '8'; lin >= '1'; lin--) {
			for(char col = 'a'; col <= 'h'; col++) {
				s += " ";
				if(getPeca(col,lin) == null) {
					s += "-";
				} else {
					s += getPeca(col,lin).toString();
				}
			}
			s += "\n";
		}
		
		return s;
	}

	public void capturarPecasNoCaminho(String origem, String destino) {
		String coord;
		for (int i = 0; i < calcularDistancia(origem, destino) - 1; i++) {
			coord = obterPosicao(origem, destino, i);
			if (getPeca(coord) != null) {
				pecasBrancas -= (getPeca(coord).getCor() == CorPeca.BRANCA) ? 1 : 0;
				pecasPretas -= (getPeca(coord).getCor() == CorPeca.PRETA) ? 1 : 0;
			}
			tab[coord.charAt(0)-'a'][coord.charAt(1)-'1'] = null;
		}
	}

	public void solicitaMovimento() {
		
		if(cmdDaVez >= controle.requestCommands().length)
			return ;
		
		String origem = controle.requestCommands()[cmdDaVez].split(":")[0];
		String destino = controle.requestCommands()[cmdDaVez].split(":")[1];
		
		if(posicaoValida(origem) && posicaoValida(destino)) {
			if (Math.abs(destino.charAt(0) - origem.charAt(0)) == Math.abs(destino.charAt(1) - origem.charAt(1))) { 
				if(getPeca(origem).movimentoEhPossivel(gerarTrajetoria(origem, destino))) {
					tab[charToIndex(destino.charAt(0))][charToIndex(destino.charAt(1))] = getPeca(origem);
					tab[charToIndex(origem.charAt(0))][charToIndex(origem.charAt(1))] = null;
					capturarPecasNoCaminho(origem, destino);
				}
			}
		}
		cmdDaVez++;
	}

	private String obterPosicao(String origem, String destino, int posRelTraj) {
		char coluna = (char)(origem.charAt(0) + 1),
			 linha = (char)(origem.charAt(1) + 1);
		int c = (origem.charAt(0) < destino.charAt(0)) ? posRelTraj : -posRelTraj,
			l = (origem.charAt(1) < destino.charAt(1)) ? posRelTraj : -posRelTraj;
		linha = (char)(linha + l);
		coluna = (char)(coluna + c);
		return "" + coluna + linha;
	}
	
	private Peca[] gerarTrajetoria(String origem, String destino) {
		int distancia = calcularDistancia(origem, destino);
		Peca[] trajetoria = new Peca[distancia];
		for(int i = 1; i <= distancia; i++) {
			trajetoria[i-1] = getPeca(obterPosicao(origem, destino, i));
		}
		return trajetoria;
	}
	
	private int calcularDistancia(String origem, String destino) {
		return Math.abs(origem.charAt(0) - destino.charAt(0));
	}

	private int charToIndex(char c) {
		int index = (Math.abs(c-'a') > Math.abs(c-'1')) ? Math.abs(c-'1') : Math.abs(c-'a');
		return (index < 8 && index >= 0) ? index : -1;
	}
	
	/** Verifica se string contem uma posição valida para posicionamento de peças no tabuleiro */

	private Boolean posicaoValida(char col, char lin) {
		String cmd = "" + col + lin;
		if(cmd.matches("^[a-h][1-8]$")) {
			int pos = (lin - '1')*8 + (col - 'a');
			return ((lin - '1')%2 == 0) ^ (pos%2 == 0);
		}
		return false;
	}

	private Boolean posicaoValida(String pos) {
		char coluna = pos.charAt(0),
			 linha = pos.charAt(1);
		return posicaoValida(coluna, linha);
	}
}
