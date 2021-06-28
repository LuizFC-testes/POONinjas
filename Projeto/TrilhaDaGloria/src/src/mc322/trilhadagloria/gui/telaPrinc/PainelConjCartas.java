package mc322.trilhadagloria.gui.telaPrinc;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PainelConjCartas extends JPanel implements ActionListener {
	
	JButton cemiterio, mao;
	ConjCartasViewer cemitV, maoV;
	CardCount deck;
	
	public PainelConjCartas() {
		super();
		setLayout(new FlowLayout(FlowLayout.CENTER));
		cemiterio = new JButton("Cemitério");
		cemiterio.addActionListener(this);
		add(cemiterio);
		mao = new JButton("Mão");
		mao.addActionListener(this);
		add(mão);
		deck = new CardCount();
		add(deck);
	}
	
	public void actionPerformed(ActionEvent ev) {
		JButton source = (JButton)ev.getSource();
		
		if (source == cemiterio) {
			CemiterioViewer 
		}
	}
	
	public ICardCount getCardCount() {
		return deck;
	}
}