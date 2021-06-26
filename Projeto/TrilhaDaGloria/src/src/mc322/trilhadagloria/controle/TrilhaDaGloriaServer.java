package mc322.trilhadagloria.controle;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TrilhaDaGloriaServer {
	
	public static final int PORT = 51768;
	public static final String ADDRESS = "trilhadagloria.gameserve.com";
	
	private ServerSocket ss;
	private int numPlayers;
	private ServerSideConnection player1;
	private ServerSideConnection player2;
	
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
				numPlayers++;
				
				System.out.println("Jogador #" + numPlayers + " conectou.");
				
				ServerSideConnection ssc = new ServerSideConnection(s, numPlayers);
				
				if(numPlayers == 1) {
					player1 = ssc;
				} else {
					player2 = ssc;
				}
				
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
		private ObjectInputStream dataIn;
		private ObjectOutputStream dataOut;
		private int playerId;
		
		public ServerSideConnection(Socket s, int id) {
			socket = s;
			playerId = id;
			
			try {
				dataIn = new ObjectInputStream(socket.getInputStream());
				dataOut = new ObjectOutputStream(socket.getOutputStream());
				
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		/**
		 * Função a ser chamada na thread de comunicação
		 */
		public void run() {
			try {
				dataOut.writeInt(playerId);
				dataOut.flush();
				
				while(true) {
					
				}
				
//				player1.closeConnection();
//				player2.closeConnection();
				
			} catch(IOException e) {
				System.out.println("Falha na thread do jogador #" + playerId);
				e.printStackTrace();
			}
		}
		
		public void sendPacket(Packet pck) {
			try {
				dataOut.writeObject(pck);
				dataOut.flush();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
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
