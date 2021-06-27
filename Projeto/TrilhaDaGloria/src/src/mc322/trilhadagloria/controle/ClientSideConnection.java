package mc322.trilhadagloria.controle;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientSideConnection {
	private Socket socket;
	private ObjectInputStream dataIn;
	private ObjectOutputStream dataOut;
	
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
	
	public Mensagem lerPacote() {
		try {
			return (Mensagem) dataIn.readObject();
		} catch (ClassNotFoundException | IOException e) {
			System.err.println("*** Erro ao ler pacote do servido: " + e.getMessage());
		}
		return null;
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

	public void enviarPacote(Mensagem msg) {
		try {
			dataOut.writeObject(msg);
			dataOut.flush();
		} catch (IOException e) {
			System.err.println("*** Erro ao enviar pacote ao servidor: " + e.getMessage());
		}
	}
}