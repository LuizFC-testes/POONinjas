package mc322.trilhadagloria.field;

import java.util.ArrayList;

import mc322.trilhadagloria.monarch.Armadilha;
import mc322.trilhadagloria.monarch.Carta;
import mc322.trilhadagloria.monarch.Heroi;

public interface IBattleField {
	public ArrayList<Armadilha> getArmadilhasInvocadas();
	
	public ArrayList<Heroi> getHeroisInvocados();

	public void remover(Carta carta);
}
