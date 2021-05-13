package mc322.lab06;

public class Caverna {

	private Sala[][] salas;
	
	public Caverna() {
		salas = new Sala[4][4];
		
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				salas[i][j] = new Sala();
			}
		}
	}
	
	public Sala getSala(int linha, int coluna) {
		return salas[linha][coluna];
	}
	
	public boolean adicionarComponente(Componente c, int lin, int col) {
		if(posicaoValida(lin, col)) {
			return salas[lin][col].adicionarComponente(c);
		} else {
			return false;
		}
	}
	
	public void removerComponente(Componente c, int lin, int col) {
		salas[lin][col].removerComponente(c);
	}
	
	public boolean moverComponente(Componente c, String wasd) {
		int lin = c.getLinha();
		int col = c.getColuna();
		
		switch(wasd) {
		case "w":
			lin--;
			break;
		case "a":
			col--;
			break;
		case "s":
			lin++;
			break;
		case "d":
			col++;
			break;
		}
		
		if(!posicaoValida(lin, col))
			return false;
		
		if(adicionarComponente(c, c.getLinha(), c.getColuna())) {
			removerComponente(c, c.getLinha(), c.getColuna()));
		}
	}
	
	private boolean posicaoValida(int lin, int col) {
		return lin >= 0 && lin < 4 && col >= 0 && col < 4;
	}
}
