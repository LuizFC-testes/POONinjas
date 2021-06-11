// Fonte: https://www.devmedia.com.br/trabalhando-com-eventos-na-gui-do-java/25898

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class CapturaEventoBotao implements ActionListener {

	private JButton botao;

	public void janela(){
		JFrame frame = new JFrame();
		botao = new JButton();

		//REGISTRA O EVENTO
		botao.addActionListener(this);

		frame.getContentPane().add(botao);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,100);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		botao.setText("Botão foi clicado!");

		//ALTERA A FONTE
		botao.setFont(new Font("SansSerif", Font.BOLD, 20));
	}

	public static void main(String[] args) {
		CapturaEventoBotao captura = new CapturaEventoBotao();
		captura.janela();
	}
}