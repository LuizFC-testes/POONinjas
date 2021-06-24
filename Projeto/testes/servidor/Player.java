import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Player extends JFrame {
	private static final long serialVersionUID = 4113419485118457382L;
	public static final int PORT = 12969;
	public static final String ADDRESS = "6.tcp.ngrok.io";
	
	private int width;
	private int height;
	private Container contentPane;
	private JTextArea message;
	private JButton b1;
	private JButton b2;
	private JButton b3;
	private JButton b4;
	private int playerId;
	private int otherPlayer;
	private int maxTurns;
	private int values[];
	private int myPoints;
	private int enemyPoints;
	private int turnsMade;
	private boolean buttonsEnabled;
	
	private ClientSideConnection csc;
	
	public Player(int w, int h) {
		width = w;
		height = h;
		contentPane = this.getContentPane();
		message = new JTextArea();
		b1 = new JButton("1");
		b2 = new JButton("2");
		b3 = new JButton("3");
		b4 = new JButton("4");
		values = new int[4];
		turnsMade = 0;
		myPoints = 0;
		enemyPoints = 0;
	}
	
	public void setUpGUI() {
		this.setSize(width, height);
		this.setTitle("Player #" + playerId);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane.setLayout(new GridLayout(1,5));
		contentPane.add(message);
		message.setText("Creating a simple turn-based game in Java");
		message.setWrapStyleWord(true);
		message.setLineWrap(true);
		message.setEditable(false);
		contentPane.add(b1);
		contentPane.add(b2);
		contentPane.add(b3);
		contentPane.add(b4);
		
		if(playerId == 1) {
			message.setText("You are player #1. You go first");
			buttonsEnabled = true;
			otherPlayer = 2;
		} else {
			message.setText("You are player #2. Wait for your turn");
			otherPlayer = 1;
			buttonsEnabled = false;
			Thread t = new Thread(new Runnable() {
				public void run() {
					updateTurn();
				}
			});
			
			t.start();
		}
		
		toggleButtons();
		
		this.setVisible(true);
	}
	
	public void connectToServer() {
		csc = new ClientSideConnection();
	}
	
	public void setupButtons() {
		ActionListener al = new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				JButton b = (JButton) ae.getSource();
				int bNum = Integer.parseInt(b.getText());
				message.setText("You clicked button #"+bNum+" Wait for player #" + otherPlayer);
				turnsMade++;
				System.out.println("Turns made: " + turnsMade);
				
				buttonsEnabled = false;
				toggleButtons();
				
				myPoints += values[bNum-1];
				System.out.println("My points: " + myPoints);
				
				csc.sendButtonNum(bNum);
				
				if(playerId == 2 && turnsMade == maxTurns) {
					checkWinner();
				} else {
					
					Thread t = new Thread(new Runnable() {
						public void run() {
							updateTurn();
						}
					});
					
					t.start();
				}
			}
		};
		
		b1.addActionListener(al);
		b2.addActionListener(al);
		b3.addActionListener(al);
		b4.addActionListener(al);
	}
	
	public void toggleButtons() {
		b1.setEnabled(buttonsEnabled);
		b2.setEnabled(buttonsEnabled);
		b3.setEnabled(buttonsEnabled);
		b4.setEnabled(buttonsEnabled);
	}
	
	public void updateTurn() {
		int n = csc.receiveButtonNum();
		message.setText("Your enemy clicked button #" + n + ". Your turn.");
		enemyPoints += values[n-1];
		System.out.println("Your enemy has " + enemyPoints + " points.");
		
		
		if(playerId == 1 && turnsMade == maxTurns) {
			checkWinner();
		} else {
			buttonsEnabled = true;
		}
		
		toggleButtons();
	}
	
	private void checkWinner() {
		buttonsEnabled = false;
		
		if(myPoints > enemyPoints) {
			message.setText("You WON!\n YOU: " + myPoints + "\n ENEMY: " + enemyPoints);
		} else if(myPoints < enemyPoints) {
			message.setText("You LOST!\n YOU: " + myPoints + "\n ENEMY: " + enemyPoints);
		} else {
			message.setText("It's a TIE!\n YOU: " + myPoints + "\n ENEMY: " + enemyPoints);
		}
		
		csc.closeConnection();
	}
	
	
	private class ClientSideConnection {
		private Socket socket;
		private DataInputStream dataIn;
		private DataOutputStream dataOut;
		InetAddress ip;
		
		public ClientSideConnection() {
			System.out.println("-----Client-----");
			
			try {
				ip = InetAddress.getByName(ADDRESS);
				socket = new Socket(ip, PORT);
				dataIn = new DataInputStream(socket.getInputStream());
				dataOut = new DataOutputStream(socket.getOutputStream());
				
				playerId = dataIn.readInt();
				System.out.println("Connected to server as Player #" + playerId + ".");
				maxTurns = dataIn.readInt()/2;
				System.out.println("maxTurns: " + maxTurns);
				values[0] = dataIn.readInt();
				System.out.println("Value 1: " + values[0]);
				values[1] = dataIn.readInt();
				System.out.println("Value 2: " + values[1]);
				values[2] = dataIn.readInt();
				System.out.println("Value 3: " + values[2]);
				values[3] = dataIn.readInt();
				System.out.println("Value 4: " + values[3]);
				
				
				
			} catch(IOException e) {
				System.out.println("Erro de conexão no servidor");
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
		
		public int receiveButtonNum() {
			int n = -1;
			try {
				n = dataIn.readInt();
				System.out.println("Player #" + otherPlayer + " clicked button #" + n);
			} catch(IOException e) {
				e.printStackTrace();
			}
			
			return n;
		}
		
		public void closeConnection() {
			try {
				socket.close();
				System.out.println("----CONNECTION CLOSED----");
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String args[]) {
		Player p = new Player(500, 100);
		p.connectToServer();
		p.setUpGUI();
		p.setupButtons();
	}
}
