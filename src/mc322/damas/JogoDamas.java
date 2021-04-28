package mc322.damas;

public class JogoDamas {
	
	private Tabuleiro tabuleiro;
	private CorPeca corDaVez;
	
	/** Construtor */
	JogoDamas () {
		tabuleiro = new Tabuleiro();
		corDaVez = null;
	}

	/** Executa uma jogada no tabuleiro 
	 * @param origem - String de dois char com [coluna,linha] da posição de origem
	 * @param destino - String de dois char com [coluna,linha] da posição de destino
	 * @return true - jogada realizada, false senão
	 */
	public boolean efetuarJogada(String origem, String destino) {
		// Verica se posições são validas
		if(isValidPositionString(origem) && isValidPositionString(destino)) {
			
			// Verifica se tem peça na origem
			if(tabuleiro.temPeca(origem)) {
				
				CorPeca corPecaOrigem = tabuleiro.getPeca(origem).getCor();
			
				// Verifica se esta correta a cor da vez
				if(corDaVez == null || corDaVez == corPecaOrigem) {
					
					// Atualiza a cor da próxima vez
					if(corPecaOrigem == CorPeca.BRANCA)
						corDaVez = CorPeca.PRETA;
					else
						corDaVez = CorPeca.BRANCA;
					
					// Move peca se for possível
					return tabuleiro.moverPeca(origem, destino);
				}
			}				
		}
		
		return false;
	}
	
	public String getTabuleiro() {
		return tabuleiro.toString();
	}
	
	/** Imprime tabuleiro na saída padrão com coordenadas */
	public void imprimirTabuleiro() {
		String[] tab = getTabuleiro().split("\n");
		System.out.println("7 " + tab[0]);
		System.out.println("6 " + tab[1]);
		System.out.println("5 " + tab[2]);
		System.out.println("4 " + tab[3]);
		System.out.println("3 " + tab[4]);
		System.out.println("2 " + tab[5]);
		System.out.println("1 " + tab[6]);
		System.out.println("  a b c d e f g\n");
	}
	
	/** Verifica se string contem dois char, uma letra entre a-g e um numero entre 1-7 */
	private Boolean isValidPositionString(String cmd) {
		return cmd.matches("^[a-g][1-7]$");
	}
}