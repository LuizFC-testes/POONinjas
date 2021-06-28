package mc322.trilhadagloria.serverclient;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Gerencia a conexão com um cliente
 * @author João Victor E. Matoso
 * @author Luiz Felipe Cezar
 */
public class ServerSideConnection implements Runnable {
	private Socket socket;
	private ObjectInputStream dataIn;
	private ObjectOutputStream dataOut;
	private int playerId;
	private ServerSideConnection enemy;

	/**
	 * Construtor da classe, cria streams de comunicação com o cliente
	 * @param socket - socket de comunicação estabelecida pelo servidor
	 * @param id - codigo de indentificação único do cliente
	 */
	public ServerSideConnection(Socket socket, int id) {
		this.socket = socket;
		playerId = id;
		
		try {
			dataOut = new ObjectOutputStream(socket.getOutputStream());
			dataIn = new ObjectInputStream(socket.getInputStream());
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Função a ser chamada na thread de comunicação,
	 * escuta mensagens de um cliente, e encaminha mensagem ao outro cliente
	 */
	public void run() {
		try {
			while(true) {
				// Aguarda comunicação do cliente
				Mensagem pkt = (Mensagem) dataIn.readObject();
				
				System.out.println("Player #" + playerId + ": " + pkt.command);
				
				// Verifica se jogo acabou
				if(pkt.command.equals("gameover")) {
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
	
	/**
	 * Envia uma mensagem ao cliente
	 * @param pkt - mensagem a ser enviada
	 */
	public void enviarPacote(Mensagem pkt) {
		try {
			dataOut.writeObject(pkt);
			dataOut.flush();
		} catch(IOException e) {
			System.err.println("*** Erro ao enviar pacote para player #" + playerId + ": " + e.getMessage());
		}
	}
	
	/**
	 * Encerra a conexão com o cliente
	 */
	public void closeConnection() {
		try {
			dataIn.close();
			dataOut.close();
			socket.close();
			System.out.println("------ Conexão com player #" + playerId + " terminada --------");
		} catch(IOException e) {
			System.err.println("*** Erro ao fechar conexão com player #" + playerId + ": " + e.getMessage());
		}
	}

	/**
	 * Conecta os dois oponentes para envio de mensagems
	 * @param enemy - handler de comunicação do oponente
	 */
	public void connectEnemy(ServerSideConnection enemy) {
		this.enemy = enemy;
	}
	
	/**
	 * Retorna o id do player
	 */
	public int getPlayerId() {
		return this.playerId;
	}
}