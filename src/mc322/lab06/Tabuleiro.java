package mc322.lab06;

import java.lang.Math;

public class Tabuleiro {
	/** Matriz de representação do tabuleiro */
	private Peca[][] tab;
	
	/** Contagem de peças restantes */
	private int pecasBrancas;
	private int pecasPretas;
	
	/** Leitura e escrita dos arquivos CSV */
	private CSVHandling controle;
	
	/** Variavel para controle da jogada da vez */
	private int cmdDaVez;
	
	/** Construtor */
	public Tabuleiro(String dataSource, String dataExport) {
		// Inicializa objeto para leitura e escrita de CSVs
		controle = new CSVHandling();
		controle.setDataSource(dataSource);
		controle.setDataExport(dataExport);
		
		// Inicializa tabuleiro
		tab = new Peca[8][8];
		
		// Inicializa peões brancos
		for(char lin = '1'; lin <= '3'; lin++)
			for(char col = 'a'; col <= 'h'; col++)
				if(posicaoValida(col,lin))
					tab[charToIndex(col)][charToIndex(lin)] = new Peao(CorPeca.BRANCA, col, lin);
		
		// Inicializa peões pretos
		for(char lin = '6'; lin <= '8'; lin++)
			for(char col = 'a'; col <= 'h'; col++)
				if(posicaoValida(col,lin))
					tab[charToIndex(col)][charToIndex(lin)] = new Peao(CorPeca.PRETA, col, lin);
		
		// Inicializa atributos
		pecasBrancas = 12;
		pecasPretas = 12;
		cmdDaVez = 0;
	}
	
	/****************** Metodos públicos *********************/
	/**
	 * Imprime tabuleiro na saída padrão com coordenadas
	 */
	public void imprimirTabuleiro() {
		String[] sTab = toString().split("\n");
		for (int i = 0; i < 8; i++) {
			System.out.println((8-i) + " " + sTab[i]);
		}
		System.out.println("  a b c d e f g h\n");
	}
	
	/**
	 * Representa o tabuleiro atual em una string
	 * @return String com oito linhas representando o tabuleiro
	 */
	public String toString() {
		String s = "";
		
		for(char lin = '8'; lin >= '1'; lin--) {
			for(char col = 'a'; col <= 'h'; col++) {
				if(getPeca(col,lin) == null) {
					s += "-";
				} else {
					s += getPeca(col,lin).toString();
				}
				s += " ";
			}
			s += "\n";
		}
		return s;
	}
	
	/**
	 * Executa todos as jogadas do arquivo de entradam, imprime no console resultados
	 * intermediarios e escreve o estado final do tabuleiro no arquivo de saida
	 * @return Vetor de strings com representação do tabuleiro apos cada jogada
	 */
	public String[] rodarComandos() {
		// Vetor de strings para retorno da função
		String [] saida = new String[controle.requestCommands().length+1];
		
		// Vetor de strings que sera escrito no arquivo de saida
		String [] state = new String[64];
		
		//int i = 0;
		boolean erro = false;
		
		// Estado inicial do tabuleiro
		System.out.println("Tabuleiro inicial:");
		imprimirTabuleiro();
		saida[0] = toString();
		
		// Execução das jogadas
		while(!jogoAcabou() && !erro) {
			//i++;
			String origem = controle.requestCommands()[cmdDaVez].split(":")[0];
			String destino = controle.requestCommands()[cmdDaVez].split(":")[1];
			
			if(solicitaMovimento()) {
				//Aumentou o cmdDaVez
				System.out.println("Source: " + origem);
				System.out.println("Target: " + destino);
				imprimirTabuleiro();
				
				saida[cmdDaVez] = toString();
			} else {
				erro = true;
			}
		}
		
		if(erro) {
			System.out.println("Movimento invalido");
			saida[cmdDaVez] = "Erro"; // Permite uppercase?
			state[0] = "Erro";
		} else {
			int j = 0;
			for(char col = 'a'; col <= 'h'; col++) {
				for(char lin = '1'; lin <= '8'; lin++) {
					state[j] = "" + col + lin + ((getPeca(col,lin)==null) ? "_" : getPeca(col,lin).toString());
					j++;
				}
			}
		}
		controle.exportState(state);
		return saida;
	}

	/**
	 * Executa a proxima jogada
	 * @return true se a jogada foi executadam false senão
	 */
	public boolean solicitaMovimento() { //Pq public?
		// Verifica se jogo acabou por falta de peças ou jogadas
		if(jogoAcabou()) {
			return false;
		}
		
		String origem = controle.requestCommands()[cmdDaVez].split(":")[0];
		String destino = controle.requestCommands()[cmdDaVez].split(":")[1];
		
		// Verifica se posição é valida
		if(posicaoValida(origem) && posicaoValida(destino)) {
			
			// Verifica se o movimento a ser realizado está na mesma direção
			if(mesmaDiagonal(origem, destino)) {
				
				// Gera um vetor com todas as peças entre origem e destino
				Peca[] trajetoria = gerarTrajetoria(origem, destino);
				
				// Verifica se a peça consegue realizar o movimento
				if(getPeca(origem) != null && getPeca(origem).movimentoEhPossivel(trajetoria)) {
					
					// Caso houve capturas, remove peças do tabuleiro
					for(int i = 0; i < trajetoria.length-1; i++) {
						if(trajetoria[i] != null) {
						
							// Atualiza contagem de peças
							if(trajetoria[i].getCor() == CorPeca.BRANCA) {
								pecasBrancas--;
							} else {
								pecasPretas--;
							}
							// Exclui peça do tabuleiro
							tab[charToIndex(trajetoria[i].getColuna())][charToIndex(trajetoria[i].getLinha())] = null;
						}
					}
					
					// Atualiza posição da peça movida
					tab[charToIndex(destino.charAt(0))][charToIndex(destino.charAt(1))] = getPeca(origem);
					tab[charToIndex(origem.charAt(0))][charToIndex(origem.charAt(1))] = null;
					getPeca(destino).setColuna(destino.charAt(0));
					getPeca(destino).setLinha(destino.charAt(1));
					
					// Verifica se peça virou dama
					if(getPeca(destino).getLinha() == '8' && getPeca(destino).getCor() == CorPeca.BRANCA)
						tab[charToIndex(destino.charAt(0))][charToIndex(destino.charAt(1))] = getPeca(destino).virarDama();
					
					else if(getPeca(destino).getLinha() == '1' && getPeca(destino).getCor() == CorPeca.PRETA)
						tab[charToIndex(destino.charAt(0))][charToIndex(destino.charAt(1))] = getPeca(destino).virarDama();
					
					cmdDaVez++;
					return true;
				}
			}
		}
		
		cmdDaVez++;
		return false;
	}
	
	/********************* Métodos privados ************************/
	
	private Peca getPeca(String coord) {
		return getPeca(coord.charAt(0), coord.charAt(1));
	}
	
	private Peca getPeca(char col, char lin) {
		return tab[charToIndex(col)][charToIndex(lin)];
	}
	
	/**
	 * Verifica se o movimento está na mesma diagonal
	 * @param origem - Coordenada da posição de origem
	 * @param destino - Coordenada da posição de destino
	 * @return true se está na mesma diagonal, false senão
	 */
	private boolean mesmaDiagonal(String origem, String destino) {
		return Math.abs(origem.charAt(0)-destino.charAt(0)) == Math.abs(origem.charAt(1)-destino.charAt(1));
	}
	
	/**
	 * Gera um vetor com todas as peças entre a posição de origem e destino
	 * @param origem - Coordenada da posição de origem
	 * @param destino - Coordenada da posição de destino
	 * @return vetor de Pecas
	 * */
	private Peca[] gerarTrajetoria(String origem, String destino) {
		int distancia = calcularDistancia(origem, destino), c, l;
		
		Peca[] trajetoria = new Peca[distancia];
		
		for(int i = 1; i <= distancia; i++) {
			c = (origem.charAt(0) < destino.charAt(0)) ? i : -i;
			l = (origem.charAt(1) < destino.charAt(1)) ? i : -i;
			
			trajetoria[i-1] = getPeca((char)(origem.charAt(0) + c), (char)(origem.charAt(1) + l));
		}
		
		return trajetoria;
	}
	
	/**
	 * Calcula quantas casas serão percorridas pela peça saindo de origem até destino
	 * @param origem - Coordenada da posição de origem
	 * @param destino - Coordenada da posição de destino
	 * @return Número de casas a percorrer
	 */
	private int calcularDistancia(String origem, String destino) {
		return Math.abs(origem.charAt(0) - destino.charAt(0));
	}

	/**
	 * Correlaciona o char que representa a linha ou coluna do tabuleiro e o índice na matriz tab
	 */
	private int charToIndex(char c) {
		int index = (Math.abs(c-'a') > Math.abs(c-'1')) ? Math.abs(c-'1') : Math.abs(c-'a');
		return (index < 8 && index >= 0) ? index : -1;
	}
	
	/**
	 * Verifica se a string contem uma posição valida do tabuleiro
	 */
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
	
	
	/**
	 * Verifica se o jogo chegou ao fim por falta de peças ou jogadas
	 * @return true se jogo acabou
	 */
	private boolean jogoAcabou() {
		boolean temPecas = pecasBrancas > 0 && pecasPretas > 0;
		boolean temComandos = cmdDaVez < controle.requestCommands().length;
		return !temPecas || !temComandos;
	}


}
