package mc322.trilhadagloria.controle;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TrilhaDaGloriaServer {
	
	public static final int PORT = 51768;
	
	private ServerSocket ss;
	private int numPlayers;
	@SuppressWarnings("unused")
	private ServerSideConnection player0;
	@SuppressWarnings("unused")
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
				
				// Inicia thread de comunicação com o cliente
				Thread t = new Thread(ssc);
				t.start();
			}
			System.out.println(numPlayers + " jogadores conectados. Novas conexões não serão mais aceitas.");
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	private class ServerSideConnection implements Runnable {
		private Socket socket;
		@SuppressWarnings("unused")
		private ObjectInputStream dataIn;
		private ObjectOutputStream dataOut;
		private int playerId;
		
		public ServerSideConnection(Socket s, int id) {
			socket = s;
			playerId = id;
			
			try {
				dataOut = new ObjectOutputStream(socket.getOutputStream());
				dataIn = new ObjectInputStream(socket.getInputStream());
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		/**
		 * Função a ser chamada na thread de comunicação
		 */
		public void run() {
			try {
				// Envia pacote de boas vindas com dados de inicialização do jogo
				dataOut.writeObject(gerador.gerarPacoteInicial(playerId));
				dataOut.flush();
				
				while(true) {
					
				}
				
			} catch(IOException e) {
				System.out.println("Falha na thread do jogador #" + playerId);
				e.printStackTrace();
			}
		}
		
		
		@SuppressWarnings("unused")
		public void closeConnection() {
			try {
				socket.close();
				System.out.println("Connection closed");
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		TrilhaDaGloriaServer server = new TrilhaDaGloriaServer();
		server.acceptConnections();
	}

}
