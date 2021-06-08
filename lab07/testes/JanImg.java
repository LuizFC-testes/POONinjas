package testes;

import java.awt.*;
import javax.swing.*;

public class JanImg extends JanelaSimples {
    JLabel lab;

    public JanImg(String imgPath) {
        super();
        Container cont = getContentPane();
        cont.setLayout(new FlowLayout());
        ImageIcon img = new ImageIcon(imgPath);
        lab = new JLabel(img);
        cont.add(lab);
        setVisible(true);
    }
}