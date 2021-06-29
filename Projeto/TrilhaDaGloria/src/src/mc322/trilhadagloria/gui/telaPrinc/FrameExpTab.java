package mc322.trilhadagloria.gui.telaPrinc;

import javax.swing.JFrame;
import java.awt.BorderLayout;

public class FrameExpTab extends JFrame {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 2451277190729828993L;
	TabView tabuleiro;

    public FrameExpTab(TabView tabuleiro, int playerId) {
        super("Tabuleiro inicial PLAYER #" + playerId);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(600, 600);
        this.tabuleiro = tabuleiro;
        tabuleiro.setSize(500,500);
        add(tabuleiro, BorderLayout.CENTER);
        setVisible(true);
    }
}