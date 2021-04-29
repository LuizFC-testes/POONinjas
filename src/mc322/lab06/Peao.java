package mc322.lab06;

public class Peao extends Peca {
	// Ponteiros para vizinhos 
	private Peao peaoVizinhoNE;
	private Peao peaoVizinhoNO;
	private Peao peaoVizinhoSO;
	private Peao peaoVizinhoSE;
	private Dama damaVizinhaNE;
	private Dama damaVizinhaNO;
	private Dama damaVizinhaSO;
	private Dama damaVizinhaSE;
	
	Peao(CorPeca cor, char coluna, char linha){
		super(cor, coluna, linha);
	}
	
	public Peao getPeaoVizinhoNE() {
		return peaoVizinhoNE;
	}
	
	public void setPeaoVizinhoNE(Peao peaoVizinhoNE) {
		this.peaoVizinhoNE = peaoVizinhoNE;
	}
	
	public Peao getPeaoVizinhoNO() {
		return peaoVizinhoNO;
	}
	
	public void setPeaoVizinhoNO(Peao peaoVizinhoNO) {
		this.peaoVizinhoNO = peaoVizinhoNO;
	}
	
	public Peao getPeaoVizinhoSO() {
		return peaoVizinhoSO;
	}
	
	public void setPeaoVizinhoSO(Peao peaoVizinhoSO) {
		this.peaoVizinhoSO = peaoVizinhoSO;
	}
	
	public Peao getPeaoVizinhoSE() {
		return peaoVizinhoSE;
	}
	
	public void setPeaoVizinhoSE(Peao peaoVizinhoSE) {
		this.peaoVizinhoSE = peaoVizinhoSE;
	}
	
	public Dama getDamaVizinhaNE() {
		return damaVizinhaNE;
	}
	
	public void setDamaVizinhaNE(Dama damaVizinhaNE) {
		this.damaVizinhaNE = damaVizinhaNE;
	}
	
	public Dama getDamaVizinhaNO() {
		return damaVizinhaNO;
	}
	
	public void setDamaVizinhaNO(Dama damaVizinhaNO) {
		this.damaVizinhaNO = damaVizinhaNO;
	}
	
	public Dama getDamaVizinhaSO() {
		return damaVizinhaSO;
	}
	
	public void setDamaVizinhaSO(Dama damaVizinhaSO) {
		this.damaVizinhaSO = damaVizinhaSO;
	}
	
	public Dama getDamaVizinhaSE() {
		return damaVizinhaSE;
	}
	
	public void setDamaVizinhaSE(Dama damaVizinhaSE) {
		this.damaVizinhaSE = damaVizinhaSE;
	}
	
	public CorPeca getCor() {
		return cor;
	}
	
	public void setCor(CorPeca cor) {
		this.cor = cor;
	}
	
	public char getLinha() {
		return linha;
	}
	
	public void setLinha(char linha) {
		this.linha = linha;
	}

	public char getColuna() {
		return coluna;
	}

	public void setColuna(char coluna) {
		this.coluna = coluna;
	}

	/** Retorna true se esse peão pode capturar alguma peça, false senão */
	public boolean ehPossivelCapturar() {
		return ehPossivelCapturar(Direcao.NE) || ehPossivelCapturar(Direcao.NO) || ehPossivelCapturar(Direcao.SE) || ehPossivelCapturar(Direcao.SO);
	}
	
	/** Retorna true se esse peão pode capturar a peça vizinha na direção indicada, false senão */
	public boolean ehPossivelCapturar(Direcao dir) {
		switch(dir) {
		case NE:
			if(peaoVizinhoNE != null && peaoVizinhoNE.getCor() != this.cor)
				if(peaoVizinhoNE.getPeaoVizinhoNE() == null && peaoVizinhoNE.getLinha() < '8' && peaoVizinhoNE.getColuna() < 'h')
					return true;
			
			if(damaVizinhaNE != null && damaVizinhaNE.getCor() != this.cor)
				if(damaVizinhaNE.temVizinho(Direcao.NE) == false && damaVizinhaNE.getLinha() < '8' && damaVizinhaNE.getColuna() < 'h')
					return true;
			break;
			
		case NO:
			if(peaoVizinhoNO != null && peaoVizinhoNO.getCor() != this.cor)
				if(peaoVizinhoNO.getPeaoVizinhoNO() == null && peaoVizinhoNO.getLinha() < '8' && peaoVizinhoNO.getColuna() > 'a')
					return true;
			
			if(damaVizinhaNO != null && damaVizinhaNO.getCor() != this.cor)
				if(damaVizinhaNO.temVizinho(Direcao.NO) == false && damaVizinhaNO.getLinha() < '8' && damaVizinhaNO.getColuna() > 'a')
					return true;
			break;
			
		case SE:
			if(peaoVizinhoSE != null && peaoVizinhoSE.getCor() != this.cor)
				if(peaoVizinhoSE.getPeaoVizinhoSE() == null && peaoVizinhoSE.getLinha() > '1' && peaoVizinhoSE.getColuna() < 'h')
					return true;
			
			if(damaVizinhaSE != null && damaVizinhaSE.getCor() != this.cor)
				if(damaVizinhaSE.temVizinho(Direcao.SE) == false && damaVizinhaSE.getLinha() > '1' && damaVizinhaSE.getColuna() < 'h')
					return true;
			break;
			
		case SO:
			if(peaoVizinhoSO != null && peaoVizinhoSO.getCor() != this.cor)
				if(peaoVizinhoSO.getPeaoVizinhoSO() == null && peaoVizinhoSO.getLinha() > '1' && peaoVizinhoSO.getColuna() > 'a')
					return true;
			
			if(damaVizinhaSO != null && damaVizinhaSO.getCor() != this.cor)
				if(damaVizinhaSO.temVizinho(Direcao.SO) == false && damaVizinhaSO.getLinha() > '1' && damaVizinhaSO.getColuna() > 'a')
					return true;
			break;
		}
		
		return false;
	}
	
	public boolean temVizinho(Direcao dir) {
		switch(dir) {
		case NE:
			return peaoVizinhoNE != null;
		case NO:
			return peaoVizinhoNO != null;
		case SE:
			return peaoVizinhoSE != null;
		case SO:
			return peaoVizinhoSO != null;
		}
		
		return false;
	}
}
