package mc322.trilhadagloria.gui.telaPrinc;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import java.awt.color.*;

public class CardCount extends JPanel implements ICardCount {
	
	private JLabel count;
	
	public CardCount() {
		super();
		setLayout(new GridLayout(2, 1));
		setOpaque(true);
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 10));
		add(new JLabel("Deck"));
		count = new JLabel("30 Cartas");
		add(count);
	}
	
	public void reduzirContador() {
		String[] str = count.getText().split(" ");
		str[0] = "" + (Integer.parseInt(str[0]) - 1);
		count.setText(str[0] + str[1]);
	}
}
