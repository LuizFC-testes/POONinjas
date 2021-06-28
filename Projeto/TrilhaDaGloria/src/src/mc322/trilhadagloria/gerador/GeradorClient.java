package mc322.trilhadagloria.gerador;

import mc322.trilhadagloria.battle.GerenciadorDeBatalhas;
import mc322.trilhadagloria.controle.Controle;
import mc322.trilhadagloria.field.Tabuleiro;
import mc322.trilhadagloria.monarch.Monarca;
import mc322.trilhadagloria.serverclient.IRemoteEnemy;
import mc322.trilhadagloria.serverclient.Mensagem;

public class GeradorClient { 
	
	public static Controle gerarJogo(Mensagem init, IRemoteEnemy remote) {
		
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
		
		// Conecta control
		control.conecta(battle);
		control.conectaPlayer(player);
		control.conectaInimigo(inimigo);
		control.conecta(tabuleiro);
		control.conecta(remote);
//		control.conecta(view);
		
		// Conecta battle
		battle.conecta(tabuleiro);
		
		// Conecta tabuleiro
//		tabuleiro.conecta(view);
//		tabuleiro.conecta(tabView);
		
		// Conecta monarca
		player.connect(tabuleiro);
		player.conecta(null, null);
		inimigo.connect(tabuleiro);
		inimigo.conecta(null, null);
		
		
		return control;
	}
	
}
