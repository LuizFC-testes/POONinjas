package mc322.trilhadagloria.gui.telaPrinc;

import javax.swing.JFrame;
import java.awt.Container;
import java.awt.BorderLayout;

public class PainelPrincTab extends JFrame {
	
	Container painel;
	PainelConjCartas cartas;
	TabView grid;
	IndicadorMana mana;
	
	public PainelPrincTab() {
		super("Painel Principal");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1000, 1000);
		painel = getContentPane();
		painel.setLayout(new BorderLayout());
		cartas = new PainelConjCartas();
		add(cartas, BorderLayout.PAGE_END);
		grid = new TabView();
		add(grid, BorderLayout.CENTER);
		mana = new IndicadorMana();
		add(mana, BorderLayout.LINE_END);
		setVisible(true);
	}
	
}