import java.awt.*;
//import java.awt.GridBagLayout;
//import java.awt.GridBagConstraints;
//import java.awt.Color;
import java.awt.event.*;
import javax.swing.JFrame;

import javax.swing.JButton;

public class FrameGB extends JFrame implements ActionListener {

    private static final long serialVersionUID = -2292999201904896674L;
    Container painel;
    PainelGrid pg;
    JButton fundoAzul;
    JButton fundoVermelho;

    public FrameGB() {
        super();
        setSize(800, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        painel = getContentPane();
        painel.setLayout(new GridBagLayout());
        criarPainelGrid();
        criarBotFundoAzul();
        criarBotFundoVerm();
    }

    private void criarPainelGrid() {
        GridBagConstraints c = new GridBagConstraints();
        pg = new PainelGrid();
        pg.conectarFrame(this);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 0;
        c.gridwidth = 3;
        c.gridheight = 3;
        c.weightx = 1;
        c.weighty = 1;
        c.insets = new Insets(10, 0, 20, 0);
        painel.add(pg, c);
    }

    private void criarBotFundoAzul() {
        GridBagConstraints c = new GridBagConstraints();
        fundoAzul = new JButton("Fundo Azul");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 4;
        c.weightx = 0.5;
        c.weighty = 0.5;
        fundoAzul.addActionListener(this);
        painel.add(fundoAzul, c);
    }

    private void criarBotFundoVerm() {
        GridBagConstraints c = new GridBagConstraints();
        fundoVermelho = new JButton("Fundo Vermelho");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 4;
        c.gridy = 4;
        c.weightx = 0.5;
        c.weighty = 0.5;
        fundoVermelho.addActionListener(this);
        painel.add(fundoVermelho, c);
    }

    public void actionPerformed(ActionEvent ev) {
        JButton origem = (JButton)ev.getSource();
        if (origem == pg.getMinimizar()) {
            setExtendedState(Frame.ICONIFIED);
        } else if (origem == pg.getMaximizar()) {
            setExtendedState(Frame.MAXIMIZED_BOTH);
        } else if (origem == pg.getFechar()) {
            System.exit(0);
        } else if (origem == fundoAzul) {
            painel.setBackground(Color.BLUE);
        } else if (origem == fundoVermelho) {
            painel.setBackground(Color.RED);
        }
    }
}