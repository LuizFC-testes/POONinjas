import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static final int PORT = 3191;

    public static void main(String[] args) {
        try {
            new Server();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Server() throws Exception {
        ServerSocket serverSocket = new ServerSocket(PORT); 
        System.out.println("Server is up and running on port: " + PORT);

        Socket socket = serverSocket.accept();

        ObjectOutputStream outStream = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream inStream = new ObjectInputStream(socket.getInputStream());

        Packet recvPacket = (Packet)inStream.readObject();
        System.out.println(recvPacket.message);

        if(recvPacket.message.equals("Hello!")) {
            Packet packet = new Packet("Hi! - From the server :");
            outStream.writeObject(packet);
        }

        serverSocket.close();
    }
}
