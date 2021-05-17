package mc322.lab06;

public class Montador {
	CSVHandling csv;
	Caverna cave;
	Heroi hero;

	public Montador(String file) {
		csv = new CSVHandling();
		csv.setDataSource(file);
		
		cave = new Caverna(4);
		
		boolean hasWumpus = false, hasOuro = false, hasHero = false, erro = false;
		int nBuracos = 0;
		
		
		for(int i = 0; i < 16 && !erro; i++) {
			String posicao = csv.requestCommands()[i][0];
			String peca = csv.requestCommands()[i][1];
			
			int linha = Integer.parseInt(posicao.split(":")[0]) - 1;
			int coluna = Integer.parseInt(posicao.split(":")[1]) - 1;
			
			switch(peca) {
			case "P":
				if(!hasHero) {
					hero = new Heroi(linha, coluna, cave);
					hasHero = true;
				} else {
					erro = true;
				}
				break;
				
			case "B":
				if(nBuracos < 3) {
					new Buraco(linha, coluna, cave);
					nBuracos++;
				} else {
					erro = true;
				}
				break;
				
			case "W":
				if(!hasWumpus) {
					new Wumpus(linha, coluna, cave);
					hasWumpus = true;
				} else {
					erro = true;
				}
				break;
				
			case "O":
				if(!hasOuro) {
					new Ouro(linha, coluna, cave);
					hasOuro = true;
				} else {
					erro = true;
				}
				break;
			}
		}
		
		if(erro || !hasHero || !hasOuro || !hasWumpus || nBuracos < 2) {
			System.out.println("Arquivo de entrada inválido.");
			hero = null;
			cave = null;
			csv = null;
		}
	}
	
	public Controle gerarControle() {
		if(hero != null) {
			return new Controle(hero);
		}
		return null;
	}

}
