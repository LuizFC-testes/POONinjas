// Fonte: https://www.devmedia.com.br/trabalhando-com-eventos-na-gui-do-java/25898

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ButtonFrame2 extends JFrame{

	private JButton botaoPrata;
	private JButton botaoOuro;

	//BUTTONFRAME ADICIONA JBUTTONS AO JFRAME
	public ButtonFrame2()
	{
		super("Testando Botões");
		setLayout(new FlowLayout()); //CONFIGURA O LAYOUT DE FRAME

		botaoPrata = new JButton("Prata"); //BOTÃO COM TEXTO
		add(botaoPrata); //ADICIONA botaoPrata AO JFRAME

		botaoOuro = new JButton("Ouro");
		add(botaoOuro); //ADICIONA botaoOuro AO JFRAME

		//CRIA NOVO BUTTON HANDLER PARA TRATAMENTO DE EVENTO DE BOTÃO
		ButtonHandler handler = new ButtonHandler();
		botaoOuro.addActionListener(handler);
		botaoPrata.addActionListener(handler);

	}

	//CLASSE INTERNA PARA TRATAMENTO DO BOTÃO
	public class ButtonHandler implements ActionListener
	{
		//TRATA EVENTO DO BOTÃO
		public void actionPerformed(ActionEvent event)
		{
			JOptionPane.showMessageDialog(ButtonFrame2.this, String.format("Você pressionou: %s", event.getActionCommand()));
		}
	}

    public static void main(String[] args) {

		ButtonFrame2 buttonFrame = new ButtonFrame2();
		buttonFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buttonFrame.setSize(275, 210);
		buttonFrame.setVisible(true);
    }
}