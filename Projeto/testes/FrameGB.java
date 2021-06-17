import java.awt.*;
//import java.awt.GridBagLayout;
//import java.awt.GridBagConstraints;
//import java.awt.Color;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.Box;
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
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 0;
        c.ipadx = 60;
        c.ipady = 60;
        c.weightx = 1;
        c.weighty = 1;
        //c.insets = new Insets(10, 0, 20, 0);
        painel.add(pg, c);
        //adicionarColasX(painel, 1, 2, 0);
    }

    private void criarBotFundoAzul() {
        GridBagConstraints c = new GridBagConstraints();
        fundoAzul = new JButton("Fundo Azul");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 2;
        c.weightx = 0.5;
        c.weighty = 0.5;
        c.anchor = GridBagConstraints.LAST_LINE_START;
        fundoAzul.addActionListener(this);
        painel.add(fundoAzul, c);
    }

    private void criarBotFundoVerm() {
        GridBagConstraints c = new GridBagConstraints();
        fundoVermelho = new JButton("Fundo Vermelho");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 2;
        c.weightx = 0.5;
        c.weighty = 0.5;
        c.anchor = GridBagConstraints.LAST_LINE_END;
        fundoVermelho.addActionListener(this);
        painel.add(fundoVermelho, c);
        //adicionarColasX(painel, 1, 1, 2);
    }

    private void adicionarColasX(Container painel, int numColas, int posInicX, int posY) {
        GridBagConstraints c;
        Component cola;
        for (int i = posInicX; i < posInicX + numColas; i++) {
            c = new GridBagConstraints();
            c.fill = GridBagConstraints.HORIZONTAL;
            c.gridx = i;
            c.gridy = posY;
            c.weightx = 0.5;
            cola = Box.createGlue();
            painel.add(cola, c);
        }
    }

    private void adicionarColasY(Container painel, int numColas, int posX, int posInicY) {
        GridBagConstraints c;
        Component cola;
        for (int i = posInicY; i < posInicY + numColas; i++) {
            c = new GridBagConstraints();
            c.fill = GridBagConstraints.HORIZONTAL;
            c.gridx = posX;
            c.gridy = i;
            c.weightx = 0.5;
            cola = Box.createGlue();
            painel.add(cola, c);
        }
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