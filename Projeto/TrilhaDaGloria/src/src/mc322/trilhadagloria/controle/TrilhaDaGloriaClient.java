package mc322.trilhadagloria.controle;

public class TrilhaDaGloriaClient {	
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
	
	public void aguardarOponente() {
		Thread t = new Thread(new Runnable() {

			public void run() {
				// Aguarda nesta linha até receber uma nova mensagem do servidor
				Mensagem msg = csc.lerPacote();
				
				switch(msg.command) {
				case "invocar":
				case "sacrificar":
				case "passarfase":
				}
			}
			
		});
		
		t.start();
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
