package mc322.trilhadagloria.controle;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerSideConnection implements Runnable {
	private Socket socket;
	private ObjectInputStream dataIn;
	private ObjectOutputStream dataOut;
	private int playerId;
	private ServerSideConnection enemy;
	
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
			while(true) {
				// Aguarda comunicação do cliente
				Mensagem pkt;
				while((pkt = (Mensagem) dataIn.readObject()) == null);
				
				System.out.println(pkt.msg);
				
				// Verifica se jogo acabou
				if(pkt.msg.equals("gameover")) {
					// Quebra loop da thread
					break;
				} else {
					// Encaminha pacote para o oponente
					enemy.enviarPacote(pkt);
				}
			}
		} catch(IOException e) {
			System.err.println("***Error player #" + playerId + " desconectou: " + e.getMessage());
		} catch(ClassNotFoundException e) {
			System.err.println("Falha na leitura do pacote do jogador #" + playerId);
			System.err.println("***Error: " + e.getMessage());
		}
		
		// Fim da thread. Fecha conexão com o cliente
		closeConnection();
	}
	
	public void enviarPacote(Mensagem pkt) {
		try {
			dataOut.writeObject(pkt);
			dataOut.flush();
		} catch(IOException e) {
			System.err.println("*** Erro ao enviar pacote para player #" + playerId + ": " + e.getMessage());
		}
	}
	
	public void closeConnection() {
		try {
			dataIn.close();
			dataOut.close();
			socket.close();
			System.out.println("Conexão com player #" + playerId + " terminada");
		} catch(IOException e) {
			System.err.println("*** Erro ao fechar conexão com player #" + playerId + ": " + e.getMessage());
		}
	}

	public void connectEnemy(ServerSideConnection enemy) {
		this.enemy = enemy;
	}
	
	public int getPlayerId() {
		return this.playerId;
	}
}