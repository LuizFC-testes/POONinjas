package testes;

import java.awt.*;
import javax.swing.*;

public class JanButImg extends JanelaSimples {

    private String DIRETORIO = JanButImg.class.getResource(".").getPath();

    Container cont;
    
    public JanButImg() {
        super();
        cont = getContentPane();
        cont.setLayout(new FlowLayout());
    }

    public void adicionarBotao(String nomeImg) {
        ImageIcon img = new ImageIcon(DIRETORIO + nomeImg);
        JButton but = new JButton(img);
        cont.add(but);
    }
}