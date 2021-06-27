import javax.swing.JFrame;
import java.awt.Container;
import javax.swing.JLabel;
import java.awt.FlowLayout;

public class FrameTestePath extends JFrame {

    protected static String DIRETORIO = FrameTestePath.class.getResource(".").getPath();
    Container painel;

    public FrameTestePath() {
        super();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 300);
        painel = getContentPane();
        painel.setLayout(new FlowLayout(FlowLayout.CENTER));
        painel.add(new JLabel(DIRETORIO));
        setVisible(true);
    }

    public static void main(String[] args) {
        FrameTestePath ftp = new FrameTestePath();
    }
}