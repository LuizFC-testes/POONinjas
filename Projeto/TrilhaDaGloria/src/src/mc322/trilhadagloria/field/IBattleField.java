package mc322.trilhadagloria.field;

import java.util.ArrayList;

import mc322.trilhadagloria.carta.Armadilha;
import mc322.trilhadagloria.carta.Carta;
import mc322.trilhadagloria.carta.Heroi;

public interface IBattleField {
	public ArrayList<Armadilha> getArmadilhasInvocadas();
	
	public ArrayList<Heroi> getHeroisInvocados();

	public void remover(Carta carta);
}
