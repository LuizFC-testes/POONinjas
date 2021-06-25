import java.awt.*;
import javax.swing.*;

public class JanelaGridAuto extends JFrame {

    protected Container painel;

    public JanelaGridAuto() {
        super();
        setSize(300, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        painel = getContentPane();
        painel.setLayout(new GridLayout(1, 1));
    }

    public void addImg(String filename) {
        ImgAutoAjustGrid imauto = new ImgAutoAjustGrid(this, painel, filename);
        JLabel img = new JLabel(imauto);
        painel.add(img);
    }

}