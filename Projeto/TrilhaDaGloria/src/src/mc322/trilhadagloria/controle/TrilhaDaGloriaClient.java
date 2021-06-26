package mc322.trilhadagloria.controle;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class TrilhaDaGloriaClient {	
	private ClientSideConnection csc;
	private int playerId;
	
	public TrilhaDaGloriaClient() {
	}
	
	public void connectToServer(String address, int port) {
		csc = new ClientSideConnection(address, port);
	}
	
	private class ClientSideConnection {
		private Socket socket;
		private ObjectInputStream dataIn;
		private ObjectOutputStream dataOut;
		
		public ClientSideConnection(String address, int port) {
			System.out.println("-----CLIENTE-----");
			
			try {
				socket = new Socket(address, port);
				dataIn = new ObjectInputStream(socket.getInputStream());
				dataOut = new ObjectOutputStream(socket.getOutputStream());
				
				PacketInicial pi = (PacketInicial) dataIn.readObject();
//				playerId = pi.playerId;
//				System.out.println("SERVER: " + pi.msg);
//				System.out.println("Conectado ao servidor como jogador #" + (playerId+1) + ".");
//				System.out.println("" + pi.tabuleiro[0]);
				
			} catch(IOException e) {
				System.err.println("Não foi possível conectar ao servidor tcp://" + address + ":" + port);
			} catch(ClassNotFoundException e) {
				System.err.println("Erro ao ler objeto 'PacketInicial'");
				e.printStackTrace();
			}
		}
		
		
		@SuppressWarnings("unused")
		public void closeConnection() {
			try {
				dataIn.close();
				dataOut.close();
				socket.close();
				System.out.println("----CONNECTION CLOSED----");
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String args[]) {
		if(args.length < 2) {
			System.out.println("Por favor, informe o enderço e a porta de conexão do servidor");
			return;
		}
		
		TrilhaDaGloriaClient client = new TrilhaDaGloriaClient();
		client.connectToServer(args[0], Integer.parseInt(args[1]));
	}
}
