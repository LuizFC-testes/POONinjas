import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Container;
import java.awt.FlowLayout;

public class OlaMundoEnable extends JFrame {
    Container painel;

    public OlaMundoEnable() {
        super();
        setSize(300, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        JLabel msg = new JLabel("Olá Mundo!");
        painel = getContentPane();
        painel.setLayout(new FlowLayout());
        painel.add(msg);
        setVisible(true);
    }

}