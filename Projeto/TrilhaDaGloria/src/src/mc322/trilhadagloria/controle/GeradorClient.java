package mc322.trilhadagloria.controle;

import mc322.trilhadagloria.battle.GerenciadorDeBatalhas;
import mc322.trilhadagloria.battle.IBattle;
import mc322.trilhadagloria.field.IField;
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
		IBattle battle = new GerenciadorDeBatalhas();
		IField tabuleiro = new Tabuleiro(init.tabuleiro);
		ICommand player = new Monarca(init.playerId, init.deck);
		ICommand inimigo = new Monarca(inimigoId, init.deckInimigo);
		
		
		control.conecta(battle);
		control.conectaPlayer(player);
		control.conectaInimigo(inimigo);
		
		
		return control;
	}
	
}
