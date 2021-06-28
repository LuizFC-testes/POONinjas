package mc322.trilhadagloria.serverclient;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import mc322.trilhadagloria.controle.GeradorServer;

public class TrilhaDaGloriaServer {
	
	public static final int PORT = 55555;
	
	private ServerSocket ss;
	private int numPlayers;
	private ServerSideConnection player0;
	private ServerSideConnection player1;
	GeradorServer gerador;
	
	/**
	 * Construtor do servidor
	 */
	public TrilhaDaGloriaServer() {
		System.out.println("----- SERVIDOR DE TRILHA DA GLORIA -----");
		
		numPlayers = 0;

		try {
			ss = new ServerSocket(PORT);
			System.out.println("Servidor iniciado na porta " + PORT);
		} catch(IOException e) {
			System.out.println("Falha ao iniciar servidor na porta " + PORT);
			e.printStackTrace();
		}
		
		// Gerar decks e terreno aleatorios
		gerador = new GeradorServer();
	}
	
	/**
	 * Aceita conexões dos jogadores
	 */
	public void acceptConnections() {
		try {
			System.out.println("Aguardando jogadores...");
			
			while(numPlayers < 2) {
				// Aguarda conexão do cliente
				Socket s = ss.accept();
				System.out.println("Jogador #" + numPlayers + " conectou.");
				ServerSideConnection ssc = new ServerSideConnection(s, numPlayers);
				
				if(numPlayers == 0) {
					player0 = ssc;
				} else {
					player1 = ssc;
				}
				
				numPlayers++;
			}
			System.out.println(numPlayers + " jogadores conectados. Novas conexões não serão mais aceitas.");
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void startCommunication() {
		player0.connectEnemy(player1);
		player1.connectEnemy(player0);
		
		// Gera pacotes individuais para sincronização
		Mensagem inicialPlayer0 = gerador.gerarPacoteInicial(player0.getPlayerId());
		Mensagem inicialPlayer1 = gerador.gerarPacoteInicial(player1.getPlayerId());
		
		// Envia pacotes aos jogadores
		player0.enviarPacote(inicialPlayer0);
		player1.enviarPacote(inicialPlayer1);
		
		// Inicia thread de escuta com os jogadores
		Thread p0 = new Thread(player0);
		Thread p1 = new Thread(player1);
		
		p0.start();
		p1.start();
	}
	

	public static void main(String[] args) {
		TrilhaDaGloriaServer server = new TrilhaDaGloriaServer();
		server.acceptConnections();
		server.startCommunication();
	}
}
