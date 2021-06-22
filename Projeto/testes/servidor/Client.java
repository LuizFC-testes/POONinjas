import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args) {
        try {
            new Client();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Client() throws UnknownHostException, IOException, ClassNotFoundException {
        Socket socket = new Socket("localhost", Server.PORT);

        ObjectOutputStream outStream = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream inStream = new ObjectInputStream(socket.getInputStream());

        Packet packet = new Packet("Hello!");

        outStream.writeObject(packet);

        Packet recvPacket = (Packet)inStream.readObject();

        System.out.println(recvPacket.message);

        outStream.close();
        socket.close();
    }

}
