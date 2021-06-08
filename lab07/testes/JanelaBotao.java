package testes;

import java.awt.*;
import javax.swing.*;

public class JanelaBotao extends JanelaSimples {
    public JanelaBotao() {
        super();
        Container contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout());
        JButton olaMundo = new JButton("Olá Mundo!");
        contentPane.add(olaMundo);
        setVisible(true);
    }
}