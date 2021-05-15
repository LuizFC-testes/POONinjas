package mc322.lab06;

public class Montador {
	CSVHandling csv;
	Caverna cave;
	Heroi hero;

	public Montador(String file) {
		csv = new CSVHandling();
		csv.setDataSource(file);
		
		cave = new Caverna(4);
		
		for(int i = 0; i < 16; i++) {
			String posicao = csv.requestCommands()[i][0];
			String peca = csv.requestCommands()[i][1];
			
			int linha = Integer.parseInt(posicao.split(":")[0]);
			int coluna = Integer.parseInt(posicao.split(":")[1]);
			
			switch(peca) {
			case "P":
				hero = new Heroi(linha, coluna, cave);
				break;
				
			case "B":
				new Buraco(linha, coluna, cave);
				break;
				
			case "W":
				new Wumpus(linha, coluna, cave);
				break;
				
			case "O":
				new Ouro(linha, coluna, cave);
				break;
			}
		}
	}
	
	public Controle gerarControle() {
		Controle controle = new Controle(hero);
		return controle;
	}

}
