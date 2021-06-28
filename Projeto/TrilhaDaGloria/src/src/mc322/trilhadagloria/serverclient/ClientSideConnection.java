package mc322.trilhadagloria.serverclient;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Classe ClientSideConnection gerencia a comunicação com o servidor
 * @author João Victor Matoso
 * @author Luiz Felipe Cezar
 */
public class ClientSideConnection {
	private Socket socket;
	private ObjectInputStream dataIn;
	private ObjectOutputStream dataOut;
	
	/**
	 * Construtor da classe inicia uma conexão com o servidor, e cria Streams de comunicação
	 * @param address - endereço do servidor
	 * @param port - porta de conexão do servidor
	 */
	public ClientSideConnection(String address, int port) {
		System.out.println("-----CLIENTE-----");
		
		try {
			socket = new Socket(address, port);
			dataIn = new ObjectInputStream(socket.getInputStream());
			dataOut = new ObjectOutputStream(socket.getOutputStream());
			
		} catch(IOException e) {
			System.err.println("*** Erro ao conectar ao servidor tcp://" + address + ":" + port);
		}
	}
	
	/**
	 * Lê um pacote de dados e retorna. Método bloqueia o código até ler um objeto.
	 * @return mensagem enviada pelo servidor
	 */
	public Mensagem lerPacote() {
		try {
			return (Mensagem) dataIn.readObject();
		} catch (ClassNotFoundException | IOException e) {
			System.err.println("*** Erro ao ler pacote do servido: " + e.getMessage());
		}
		return null;
	}
	
	/**
	 * Encerra conexão com o servidor
	 */
	public void closeConnection() {
		try {
			dataIn.close();
			dataOut.close();
			socket.close();
			System.out.println("----CONEXÃO ENCERRADA----");
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Envia um pacote de mensagem para o servidor
	 */
	public void enviarPacote(Mensagem msg) {
		try {
			dataOut.writeObject(msg);
			dataOut.flush();
		} catch (IOException e) {
			System.err.println("*** Erro ao enviar pacote ao servidor: " + e.getMessage());
		}
	}
}