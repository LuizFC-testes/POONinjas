package mc322.trilhadagloria.controle;

import mc322.trilhadagloria.battle.IBattle;
import mc322.trilhadagloria.exceptions.EmptyDeckException;
import mc322.trilhadagloria.exceptions.GameExceptions;
import mc322.trilhadagloria.field.IFieldControl;
import mc322.trilhadagloria.field.Terreno;
import mc322.trilhadagloria.gui.IViewControl;
import mc322.trilhadagloria.monarch.Carta;
import mc322.trilhadagloria.monarch.ICommand;

public class Controle implements IControle {
	private IBattle battle;
	private ICommand player;
	private ICommand inimigo;
	private IRemoteEnemy remote;
	private IFieldControl tabuleiro;
	private IViewControl view;
	private int playerId;
	private int inimigoId;
	private boolean suaVez;
	private ControlStateMachine stm;
	
	public Controle (int playerId) {
		this.playerId = playerId;
		
		if(playerId == 0) {
			inimigoId = 1;
			suaVez = true;
		} else {
			inimigoId = 0;
			suaVez = false;
		}
		
		stm = ControlStateMachine.AguardandoCompra;
	}
	

	public void conecta(IBattle battle) {
		this.battle = battle;
	}

	public void conectaPlayer(ICommand player) {
		this.player = player;
	}
	
	public void conectaInimigo(ICommand inimigo) {
		this.inimigo = inimigo;
	}

	public void comprarCarta() {
		if(stm == ControlStateMachine.AguardandoCompra) {
			try {
				if(suaVez) {
					player.comprarCarta();
					
					Mensagem msg = new Mensagem();
					msg.command = "comprar";
					remote.enviarMensagem(msg);
				} else {
					inimigo.comprarCarta();
				}
				
			} catch (EmptyDeckException e) {
				System.err.println("*** Error: sem cartas no deck");
			}
			
			stm = stm.proximoEstado();
		} else {
			System.err.println("*** Erro de sincronização: fase atual = " + stm);
		}
	}

	
	public void invocarCarta(Carta c, Terreno t) {
		
		if(suaVez && stm == ControlStateMachine.Invocacao) {
			try {
				player.invocarCarta(c, t);
				
				Mensagem msg = new Mensagem();
				msg.command = "invocar";
				msg.cartaId = c.getId();
				msg.posTabuleiro = t.getPosicao();
				remote.enviarMensagem(msg);
			} catch (GameExceptions e) {
				e.printStackTrace();
			}
		}
	}


	public void passarFase() {
		stm = stm.proximoEstado();
		
		if(suaVez) {
			Mensagem msg = new Mensagem();
			msg.command = "passar";
			remote.enviarMensagem(msg);
		}
		
		switch(stm) {
		case RevelarArmadilhas:
			battle.ativarHabilidadesPassivas();
			battle.revelarArmadilhas();
			break;
		case AtivarArmadilhas:
			battle.ativarArmadilhas();
			break;
		case RevelarCombate:
			battle.gerarBatalhas((suaVez) ? playerId : inimigoId);
			break;
		case Combate:
			battle.iniciarBatalhas();
			break;
		case AguardandoCompra:
			fimDeTurno();
			suaVez = !suaVez;
			break;
		default:
			break;
		}
	}


	private void fimDeTurno() {
		tabuleiro.incrementarTurnoCartasInvocadas();
		boolean vcGanhou = tabuleiro.verificarCaminhoFechado(playerId);
		boolean oponenteGanhou = tabuleiro.verificarCaminhoFechado(inimigoId);
		
		if(vcGanhou && !oponenteGanhou) {
			gameOver(playerId);
		} else if (!vcGanhou && oponenteGanhou) {
			gameOver(inimigoId);
		} else if (vcGanhou && oponenteGanhou) {
			gameOver(null);
		}
	}


	private void gameOver(Integer ganhador) {
		String s = "";
		
		if(ganhador == null) {
			s = "EMPATE";
		} else if(ganhador == playerId) {
			s = "VOCE GANHOU!";
		} else {
			s = "VOCE PERDEU";
		}
		
		view.mensagemFimDeJogo(s);
		stm = ControlStateMachine.FimDeJogo;
	}


	public void sacrificarCarta(Carta c) {
		if(suaVez && stm == ControlStateMachine.Invocacao) {
			player.sacrificarCarta(c);
		}
	}


	public void conecta(IFieldControl tabuleiro) {
		this.tabuleiro = tabuleiro;
	}


	public void mensagemRemota(Mensagem msg) {
		if(!suaVez) {
			switch(msg.command) {
			case "comprar":
				comprarCarta();
				break;
			case "invocar":
				invocarCarta(msg.cartaId, msg.posTabuleiro);
				break;
			case "sacrificar":
				sacrificarCarta(msg.cartaId);
				break;
			case "passar":
				passarFase();
				break;
			}
		}
		
		if(!suaVez) {
			remote.ouvirOponente();
		}
		
	}


	private void sacrificarCarta(int cartaId) {
		// TODO Auto-generated method stub
		
	}


	private void invocarCarta(int cartaId, int[] posTabuleiro) {
		// TODO Auto-generated method stub
		
	}
}
