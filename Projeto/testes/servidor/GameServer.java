import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class GameServer {
	private static final int PORT = 51768;
	
	private ServerSocket ss;
	private int numPlayers;
	private ServerSideConnection player1;
	private ServerSideConnection player2;
	private int turnsMade;
	private int maxTurns;
	private int[] values;
	private int player1BtnNum;
	private int player2BtnNum;
	
	
	public GameServer() {
		System.out.println("-----Game Server-----");
		numPlayers = 0;
		turnsMade = 0;
		maxTurns = 4;
		values = new int[4];
		
		for(int i = 0; i < values.length; i++) {
			Random rand = new Random();
			values[i] = rand.nextInt(100);
			System.out.println("Value #" + i + " is " + values[i]);
		}
		
		try {
			ss = new ServerSocket(PORT);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void acceptConnections() {
		try {
			System.out.println("Waiting for connections...");
			while(numPlayers < 2) {
				Socket s = ss.accept();
				numPlayers++;
				System.out.println("Player #" + numPlayers + " has connected.");
				ServerSideConnection ssc = new ServerSideConnection(s, numPlayers);
				
				if(numPlayers == 1) {
					player1 = ssc;
				} else {
					player2 = ssc;
				}
				
				Thread t = new Thread(ssc);
				t.start();
			}
			System.out.println("We now have "+ numPlayers + " players. No longer accepting connections.");
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	private class ServerSideConnection implements Runnable {
		private Socket socket;
		private DataInputStream dataIn;
		private DataOutputStream dataOut;
		private int playerId;
		
		public ServerSideConnection(Socket s, int id) {
			socket = s;
			playerId = id;
			
			try {
				dataIn = new DataInputStream(socket.getInputStream());
				dataOut = new DataOutputStream(socket.getOutputStream());
				
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		
		public void run() {
			try {
				dataOut.writeInt(playerId);
				dataOut.writeInt(maxTurns);
				dataOut.writeInt(values[0]);
				dataOut.writeInt(values[1]);
				dataOut.writeInt(values[2]);
				dataOut.writeInt(values[3]);
				dataOut.flush();
				
				while(true) {
					if(playerId == 1) {
						player1BtnNum = dataIn.readInt();
						System.out.println("Player 1 clicked button #" + player1BtnNum);
						player2.sendButtonNum(player1BtnNum);
					} else {
						player2BtnNum = dataIn.readInt();
						System.out.println("Player 2 clicked button #" + player2BtnNum);
						player1.sendButtonNum(player2BtnNum);
					}
					turnsMade++;
					if(turnsMade == maxTurns) {
						System.out.println("Max turns has been reached.");
						break;
					}
				}
				
				player1.closeConnection();
				player2.closeConnection();
				
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		public void sendButtonNum(int n) {
			try {
				dataOut.writeInt(n);
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
	
	public static void main(String args[]) {
		GameServer gs = new GameServer();
		gs.acceptConnections();
	}
	
}
