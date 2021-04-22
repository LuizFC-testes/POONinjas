package mc322.damas;

public class Peao {
	// Cor da peça
	private CorPeca cor;
	
	// Posição no tabuleiro
	private char linha, coluna;
	
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
		this.cor = cor;
		this.coluna = coluna;
		this.linha = linha;
		
		peaoVizinhoNE = null;
		peaoVizinhoNO = null;
		peaoVizinhoSO = null;
		peaoVizinhoSE = null;
		damaVizinhaNE = null;
		damaVizinhaNO = null;
		damaVizinhaSO = null;
		damaVizinhaSE = null;
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
	
	public Boolean ehPossivelCapturar() {
		if(peaoVizinhoNE != null && peaoVizinhoNE.cor != this.cor)
			if(peaoVizinhoNE.peaoVizinhoNE == null && peaoVizinhoNE.linha < '8' && peaoVizinhoNE.coluna < 'h')
				return true;
		
		if(peaoVizinhoNO != null && peaoVizinhoNO.cor != this.cor)
			if(peaoVizinhoNO.peaoVizinhoNO == null && peaoVizinhoNO.linha < '8' && peaoVizinhoNO.coluna > 'a')
				return true;
		
		if(peaoVizinhoSE != null && peaoVizinhoSE.cor != this.cor)
			if(peaoVizinhoSE.peaoVizinhoSE == null && peaoVizinhoSE.linha > '1' && peaoVizinhoSE.coluna < 'h')
				return true;
		
		if(peaoVizinhoSO != null && peaoVizinhoSO.cor != this.cor)
			if(peaoVizinhoSO.peaoVizinhoSO == null && peaoVizinhoSO.linha > '1' && peaoVizinhoSO.coluna > 'a')
				return true;
		
		return false;
	}
}
