import java.io.Serializable;

public class Packet implements Serializable {
    
    String message;

    public Packet(String msg) {
        message = msg;
    }

}
