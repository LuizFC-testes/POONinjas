package mc322.trilhadagloria.controle;

import mc322.trilhadagloria.battle.GerenciadorDeBatalhas;
import mc322.trilhadagloria.battle.IBattle;
import mc322.trilhadagloria.field.IField;
import mc322.trilhadagloria.field.IFieldControl;
import mc322.trilhadagloria.field.Tabuleiro;
import mc322.trilhadagloria.gui.IViewControl;
import mc322.trilhadagloria.monarch.ICommand;
import mc322.trilhadagloria.monarch.Monarca;
import mc322.trilhadagloria.serverclient.Mensagem;

public class GeradorClient { 
	
	public static Controle gerarJogo(Mensagem init) {
		
		int inimigoId;
		
		if(init.playerId == 0) {
			inimigoId = 1;
		} else {
			inimigoId = 0;
		}
		
		// Cria componentes principais do jogo
		Controle control = new Controle(init.playerId);
		GerenciadorDeBatalhas battle = new GerenciadorDeBatalhas();
		Tabuleiro tabuleiro = new Tabuleiro(init.tabuleiro);
		Monarca player = new Monarca(init.playerId, init.deck);
		Monarca inimigo = new Monarca(inimigoId, init.deckInimigo);
//		VisualInterface view = new VisualInterface();
		
		// Conecta componentes
		control.conecta(battle);
		control.conectaPlayer(player);
		control.conectaInimigo(inimigo);
		control.conecta(tabuleiro);
//		control.conecta(view);
		
		
		return control;
	}
	
}
