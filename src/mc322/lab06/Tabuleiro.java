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
		controle.setDataSource(dataSource);
		controle.setDataExport(dataExport);
		
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
	
	public String[] rodarComandos() {
		String [] saida = new String[controle.requestCommands().length+1];
		String [] state = new String[64];
		
		int i = 0;
		boolean erro = false;
		
		System.out.println("Tabuleiro inicial:");
		imprimirTabuleiro();
		saida[i] = toString();
		i++;
		
		while(!jogoAcabou() && !erro) {
			String origem = controle.requestCommands()[cmdDaVez].split(":")[0];
			String destino = controle.requestCommands()[cmdDaVez].split(":")[1];
			
			if(solicitaMovimento()) {
				System.out.println("Source: " + origem);
				System.out.println("Target: " + destino);
				imprimirTabuleiro();
				
				saida[i] = toString();
				i++;
			}
			else
				erro = true;
		}
		
		if(erro) {
			System.out.println("Movimento invalido");
			saida[i] = "Erro";
			state[0] = "Erro";
			controle.exportState(state);
		}
		else {
			int j = 0;
			for(char col = 'a'; col <= 'h'; col++) {
				for(char lin = '1'; lin <= '8'; lin++) {
					state[j] = "" + col + lin + ((getPeca(col,lin)==null) ? "_" : getPeca(col,lin).toString());
					j++;
				}
			}
			controle.exportState(state);
		}
		
		return saida;
	}

	public boolean solicitaMovimento() {
		
		if(jogoAcabou())
			return false;
		
		String origem = controle.requestCommands()[cmdDaVez].split(":")[0];
		String destino = controle.requestCommands()[cmdDaVez].split(":")[1];
		
		if(posicaoValida(origem) && posicaoValida(destino)) {
			if(mesmaDiagonal(origem, destino)) {
				Peca[] trajetoria = gerarTrajetoria(origem, destino);
				if(getPeca(origem).movimentoEhPossivel(trajetoria)) {
					
					// Caso houve capturas, remove peças do tabuleiro
					for(int i = 0; i < trajetoria.length-1; i++) {
						if(trajetoria[i] != null) {
						
							if(trajetoria[i].getCor() == CorPeca.BRANCA)
								pecasBrancas--;
							else
								pecasPretas--;
						
							tab[charToIndex(trajetoria[i].getColuna())][charToIndex(trajetoria[i].getLinha())] = null;
						}
					}
					
					// Atualiza posição da peça no tabuleiro
					tab[charToIndex(destino.charAt(0))][charToIndex(destino.charAt(1))] = getPeca(origem);
					tab[charToIndex(origem.charAt(0))][charToIndex(origem.charAt(1))] = null;
					getPeca(destino).setColuna(destino.charAt(0));
					getPeca(destino).setLinha(destino.charAt(1));
					
					// Verifica se peça virou dama
					if(destino.charAt(1) == '8' && getPeca(destino).getCor() == CorPeca.BRANCA)
						tab[charToIndex(destino.charAt(0))][charToIndex(destino.charAt(1))] = getPeca(destino).virarDama();
					
					if(destino.charAt(1) == '1' && getPeca(destino).getCor() == CorPeca.PRETA)
						tab[charToIndex(destino.charAt(0))][charToIndex(destino.charAt(1))] = getPeca(destino).virarDama();
					
					cmdDaVez++;
					return true;
				}
			}
		}
		
		cmdDaVez++;
		
		return false;
	}
	
	private boolean mesmaDiagonal(String origem, String destino) {
		return Math.abs(origem.charAt(0)-destino.charAt(0)) == Math.abs(origem.charAt(1)-destino.charAt(1));
	}
	
	private Peca[] gerarTrajetoria(String origem, String destino) {
		int distancia = calcularDistancia(origem, destino);
		
		Peca[] trajetoria = new Peca[distancia];
		
		for(int i = 1; i <= distancia; i++) {
			int c = (origem.charAt(0) < destino.charAt(0)) ? i : -i;
			int l = (origem.charAt(1) < destino.charAt(1)) ? i : -i;
			
			trajetoria[i-1] = getPeca((char)(origem.charAt(0) + c), (char)(origem.charAt(1) + l));
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
	
	private boolean jogoAcabou() {
		boolean temPecas = pecasBrancas > 0 && pecasPretas > 0;
		boolean temComandos = cmdDaVez < controle.requestCommands().length;
		return !temPecas || !temComandos;
	}


}
