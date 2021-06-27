package mc322.trilhadagloria.controle;

import mc322.trilhadagloria.field.IBattle;
import mc322.trilhadagloria.field.Tabuleiro;
import mc322.trilhadagloria.monarch.ICommand;
import mc322.trilhadagloria.monarch.Monarca;

public class GeradorClient { 
	
	public static Controle gerarJogo(Mensagem init) {
		
		int inimigoId;
		
		if(init.playerId == 0) {
			inimigoId = 1;
		} else {
			inimigoId = 0;
		}
		
		
		Controle control = new Controle();
		IBattle battlefield = new Tabuleiro(init.tabuleiro);
		ICommand player = new Monarca(init.playerId, init.deck);
		ICommand inimigo = new Monarca(inimigoId, init.deckInimigo);
		
		
		control.conecta(battlefield);
		control.conectaPlayer(player);
		control.conectaInimigo(inimigo);
		
		
		return control;
	}
	
}
