package mc322.trilhadagloria.serverclient;

import java.util.Scanner;

import mc322.trilhadagloria.controle.Controle;
import mc322.trilhadagloria.gerador.GeradorClient;
import mc322.trilhadagloria.gui.telaPrinc.FrameExpTab;
import mc322.trilhadagloria.gui.telaPrinc.ITabConnect;
import mc322.trilhadagloria.gui.telaPrinc.TabView;

/**
 * Classe Cliente de Trilha da Glória
 * @author João Victor E. Matoso
 * @author Luiz Felipe Cezar
 */
public class TrilhaDaGloriaClient implements IRemoteEnemy {	
	private ClientSideConnection csc;
	private int playerId;
	private Controle control;
	private boolean conectado;
	
	/**
	 * Inicia uma nova conexão com o servidor passado como parametro e inicializa jogo
	 * @param address - endereço do servidor
	 * @param port - porta de conexão do servidor
	 */
	public void connectToServer(String address, int port) {
		csc = new ClientSideConnection(address, port);
		System.out.println("Conectado ao servidor tcp://" + address + ":" + port);
		conectado = true;
		
		// Mensagem com inicializações
		System.out.println("Aguardando pacote de inicializações...");
		Mensagem msg = csc.lerPacote();
		
		control = GeradorClient.gerarJogo(msg, this);
		
		playerId = msg.playerId;
		System.out.println("Conectado ao servidor como jogador #" + playerId + ".");
		
	}
	
	/**** Métodos da interface IRemoteEnemy ****/
	
	/**
	 * Inicia uma nova thread para escutar e retornar um pacote do servidor
	 */
	@Override
	public void ouvirOponente() {
		Thread t = new Thread(new Runnable() {

			public void run() {
				Mensagem msg = csc.lerPacote();
				control.mensagemRemota(msg);
			}
		});
		
		t.start();
	}
	
	/**
	 * Envia um pacote de mensagem ao servidor
	 * @param - Objeto mensagem a ser enviado
	 */
	@Override
	public void enviarMensagem(Mensagem msg) {
		csc.enviarPacote(msg);
	}
	
	
	/**
	 * Envia mensagem de fim de jogo ao servidor e encerra a conexão
	 */
	@Override
	public void fimDeJogo() {
		Mensagem msg = new Mensagem();
		msg.command = "gameover";
		
		enviarMensagem(msg);
		
		csc.closeConnection();
		
		conectado = false;
	}
	
	public void mostrarDeck(int i) {
		control.mostrarDeck(i);
	}

	/**
	 * Função main
	 * Conecta ao servidor e porta informados como argumento, e inicia um novo jogo de Trilha da Glória
	 * @param args[] - <servidor> <porta> do servidor de Trilha da Glória
	 */
	public static void main(String args[]) {
		String address;
		String port;
		Scanner teclado = new Scanner(System.in);

		
		// Verifica se argumentos foram informados corretamente
		if(args.length == 2) {
			address = args[0];
			port = args[1];
		} else {
			System.out.print("Endereço do servidor: ");
			address = teclado.nextLine();

			System.out.print("Porta do servidor: ");
			port = teclado.nextLine();
		}
		
		// Inicia cliente no endereço especificado
		TrilhaDaGloriaClient client = new TrilhaDaGloriaClient();
		client.connectToServer(address, Integer.parseInt(port));
		
		// Evita desconexão do cliente durante desenvolvimento
		while(client.conectado) {
			System.out.print("--> ");
			String cmd = teclado.nextLine();
			
			switch(cmd) {
			case "deck":
				client.mostrarDeck(0);
				break;
			case "deck inimigo":
				client.mostrarDeck(1);
				break;
			case "mao":
				client.mostrarMao(0);
				break;
			case "mao inimigo":
				client.mostrarMao(1);
				break;
			case "tabuleiro":
				client.mostrarTabuleiro();
				break;
			}
		}
		
		teclado.close();
	}

	private void mostrarTabuleiro() {
		control.mostrarTabuleiro();
	}

	private void mostrarMao(int i) {
		control.mostrarMao(i);
	}
}
