package mc322.trilhadagloria.field;

import java.util.ArrayList;
import java.util.Arrays;

import mc322.trilhadagloria.carta.Carta;
import mc322.trilhadagloria.carta.Efeito;
import mc322.trilhadagloria.carta.Heroi;
import mc322.trilhadagloria.exceptions.GameExceptions;
import mc322.trilhadagloria.gui.telaPrinc.IViewTerreno;

public class Terreno implements IRViewTerreno {
	private Carta cartas[];
	private Terreno vizinhos[];
	private int posicaoI;
	private int posicaoJ;
	private Bioma bioma;
	private boolean conquistado;
	private int playerIdDono;
	private IViewTerreno viewTerreno;
	
	public Terreno(Bioma bioma) {
		cartas = new Carta[2];
		vizinhos = new Terreno[4];
		this.bioma = bioma;
		conquistado = false;
	}
	
	public void setPosicao(int i, int j) {
		posicaoI = i;
		posicaoJ = j;
	}
	
	public Bioma getBioma() {
		return bioma;
	}
	
	public void invocarCarta(Carta c, int playerId) throws GameExceptions {
		if(cartas[playerId] != null) {
			throw new GameExceptions("Player já possui uma carta invocada nesse terreno");
		} else {
			cartas[playerId] = c;
			c.invocar(this);
			
			if(c instanceof Heroi) {
				aplicarEfeitoBioma((Heroi)c);
			}
		}
	}
	
	private void aplicarEfeitoBioma(Heroi h) {
		Efeito efBioma = new Efeito(BonusDatabase.getBonusBiomaHeroi(bioma, h.getDominio()), BonusDatabase.getBonusBiomaHeroi(bioma, h.getDominio()), null);
		efBioma.aplicarEfeitoBioma(h);
	}

	public void setVizinho(int indice, Terreno t) {
		if(indice >= 0 && indice < 4) {
			vizinhos[indice] = t;
		}
	}

	public Terreno getVizinho(int indice) {
		return vizinhos[indice];
	}
	
	public Carta getCarta(int playerId) {
		return cartas[playerId];
	}

	public int[] getPosicao() {
		return new int[] {posicaoI, posicaoJ};
	}

	public void setCarta(int playerId, Carta carta) {
		cartas[playerId] = carta;
	}
	
	public void removerCarta(int playerId) {
		cartas[playerId] = null;
	}

	public ArrayList<Terreno> getVizinhos() {
		ArrayList<Terreno> list = new ArrayList<Terreno>();
		
		list.addAll(Arrays.asList(vizinhos));
		
		return list;
	}

	public void conquistar(int playerId) {
		conquistado = true;
		playerIdDono = playerId;
	}

	public boolean estaConquistado() {
		return conquistado;
	}

	public int getIdDono() {
		return playerIdDono;
	}

	@Override
	public void conecta(IViewTerreno viewTerreno) {
		this.viewTerreno = viewTerreno;
		viewTerreno.gerarImgBio(bioma.toString());
	}
}
