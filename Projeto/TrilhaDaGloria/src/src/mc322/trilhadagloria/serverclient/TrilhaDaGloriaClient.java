package mc322.trilhadagloria.serverclient;

import mc322.trilhadagloria.controle.Controle;
import mc322.trilhadagloria.controle.GeradorClient;

public class TrilhaDaGloriaClient implements IRemoteEnemy {	
	private ClientSideConnection csc;
	private int playerId;
	private Controle control;
	
	public TrilhaDaGloriaClient() {
	}
	
	public void connectToServer(String address, int port) {
		csc = new ClientSideConnection(address, port);
		
		// Mensagem com inicializações
		Mensagem msg = csc.lerPacote();
		
		control = GeradorClient.gerarJogo(msg);
		
		playerId = msg.playerId;
		System.out.println("Conectado ao servidor como jogador #" + playerId + ".");
		
	}
	
	public void ouvirOponente() {
		Thread t = new Thread(new Runnable() {

			public void run() {
				Mensagem msg = csc.lerPacote();
				
				control.mensagemRemota(msg);

			}
		});
		
		t.start();
	}
	
	public void enviarMensagem(Mensagem msg) {
		csc.enviarPacote(msg);
	}
	
	@Override
	public void fimDeJogo() {
		Mensagem msg = new Mensagem();
		msg.command = "gameover";
		
		enviarMensagem(msg);
		
		csc.closeConnection();
	}

	
	public static void main(String args[]) {
		if(args.length < 2) {
			System.out.println("Por favor, informe o enderço e a porta de conexão do servidor");
			return;
		}
		
		TrilhaDaGloriaClient client = new TrilhaDaGloriaClient();
		client.connectToServer(args[0], Integer.parseInt(args[1]));
		
		// Evita desconexão do cliente durante desenvolvimento
		while(true);
	}

}
