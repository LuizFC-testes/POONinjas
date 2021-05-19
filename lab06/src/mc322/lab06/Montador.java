package mc322.lab06;

/**
 * @author João Victor Matoso
 * @author Luiz Felipe Cezar
 */
public class Montador {
	/** Leitor de arquivos CSV */
	CSVHandling csv;
	/** Ponteiro para a caverna gerada */
	Caverna cave;
	/** Ponteiro para o heroi gerado */
	Heroi hero;

	/**
	 * Função montar jogo - Monta uma caverna a partir do arquivo fornecido
	 * @return true se montou com sucesso, false se erro
	 */
	public boolean montar(String file) {
		csv = new CSVHandling();
		csv.setDataSource(file);
		
		// Cria uma nova caverna de 4x4 salas
		cave = new Caverna(4);
		
		// Flags para verificação da existencia dos componentes
		boolean hasWumpus = false, hasOuro = false, hasHero = false, erro = false;
		int nBuracos = 0;
		
		for(int i = 0; i < 16 && !erro; i++) {
			String posicao = csv.requestCommands()[i][0];
			String peca = csv.requestCommands()[i][1];
			
			int linha = Integer.parseInt(posicao.split(":")[0]) - 1;
			int coluna = Integer.parseInt(posicao.split(":")[1]) - 1;
			
			switch(peca) {
			case "P":
				// Verifica se já foi adicionado um heroi
				if(!hasHero) {
					hero = new Heroi(linha, coluna, cave);
					hasHero = true;
				} else {
					erro = true;
				}
				break;
				
			case "B":
				// Verifica se o número de buracos não ultrapassou o limite de 3
				if(nBuracos < 3) {
					new Buraco(linha, coluna, cave);
					nBuracos++;
				} else {
					erro = true;
				}
				break;
				
			case "W":
				// Verifica se já foi adicionado um Wumpus
				if(!hasWumpus) {
					new Wumpus(linha, coluna, cave);
					hasWumpus = true;
				} else {
					erro = true;
				}
				break;
				
			case "O":
				// Verifica se já foi adicionado um Ouro
				if(!hasOuro) {
					new Ouro(linha, coluna, cave);
					hasOuro = true;
				} else {
					erro = true;
				}
				break;
			}
		}
		
		// Caso houve erro nas etapas anteriores ou caso falte componentes, anula montagem
		if(erro || !hasHero || !hasOuro || !hasWumpus || nBuracos < 2) {
			System.out.println("Arquivo de entrada inválido.");
			hero = null;
			cave = null;
			csv = null;
			return false;
		}
		
		return true;
	}
	
	/**
	 * Gera um objeto controle para executar a partida montada
	 */
	public Controle gerarControle() {
		if(hero != null) {
			return new Controle(hero);
		}
		return null;
	}
}
