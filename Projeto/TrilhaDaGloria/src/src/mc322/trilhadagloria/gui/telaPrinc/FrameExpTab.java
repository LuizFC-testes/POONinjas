package mc322.trilhadagloria.gui.telaPrinc;

import javax.swing.JFrame;
import java.awt.BorderLayout;

public class FrameExpTab extends JFrame {
    
    TabView tabuleiro;

    public FrameExpTab(TabView tabuleiro) {
        super("Tabuleiro inicial");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(600, 600);
        this.tabuleiro = tabuleiro;
        tabuleiro.setSize(500,500);
        add(tabuleiro, BorderLayout.CENTER);
        setVisible(true);
    }
}