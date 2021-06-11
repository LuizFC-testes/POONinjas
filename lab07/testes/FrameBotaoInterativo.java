package testes;

import java.awt.Container;
import java.awt.event.*;
import javax.swing.*;

public class FrameBotaoInterativo extends JFrame implements ActionListener {
    Container painel;
    JLabel contador;
    JButton botao;

    FrameBotaoInterativo() {
        super();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
        criarPainel();
        criarContador();
        criarBotao();
        setVisible(true);
    }

    private void criarPainel() {
        painel = this.getContentPane();
        painel.setSize(500, 500);
        painel.setLayout(null);
    }

    private void criarContador() {
        contador = new JLabel("Cliques: 0");
        contador.setSize(200, 200);
        contador.setLocation(150, 50);
        painel.add(contador);
    }

    private void criarBotao() {
        botao = new JButton("Aperte aqui");
        botao.setSize(200, 50);
        botao.setLocation(150, 300);
        botao.addActionListener(this);
        painel.add(botao);
    }

    public void actionPerformed(ActionEvent ev) {
        String mensagem = contador.getText();
        int contagem = Integer.parseInt(mensagem.substring(9));
        contagem++;
        mensagem = mensagem.substring(0, 9) + contagem;
        contador.setText(mensagem);
        SwingUtilities.updateComponentTreeUI(this);
    }
}