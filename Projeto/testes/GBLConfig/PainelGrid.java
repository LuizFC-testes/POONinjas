import java.awt.*;
import java.awt.event.*;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.Box;

public class PainelGrid extends JPanel {

    private GridBagLayout grid;
    private JButton[] botoes;

    public PainelGrid() {
        super();
        grid = new GridBagLayout();
        setLayout(grid);
        botoes = new JButton[3];
        criarMinim();
        criarMaxim();
        criarFechar();
    }

    private void criarMinim() {
        GridBagConstraints c = new GridBagConstraints();
        JButton minimizar = new JButton("Minimizar");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        c.weightx = 0.5;
        this.add(minimizar, c);
        botoes[0] = minimizar;
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 0;
        c.weightx = 0.5;
        Component cola = Box.createGlue();
        this.add(cola, c);
    }

    private void criarMaxim() {
        GridBagConstraints c = new GridBagConstraints();
        JButton maximizar = new JButton("Maximizar");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        c.weightx = 1;
        c.weighty = 1;
        c.gridwidth = 3;
        c.ipady = 30;
        c.insets = new Insets(10, 0, 10, 0);
        c.anchor = GridBagConstraints.CENTER;
        this.add(maximizar, c);
        botoes[1] = maximizar;
    }

    private void criarFechar() {
        GridBagConstraints c = new GridBagConstraints();
        JButton fechar = new JButton("Fechar");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 2;
        c.weightx = 0.5;
        c.gridwidth = 2;
        this.add(fechar, c);
        botoes[2] = fechar;
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 2;
        c.weightx = 0.5;
        Component cola = Box.createGlue();
        this.add(cola, c);
    }

    public void conectarFrame(ActionListener act) {
        for (int i = 0; i < botoes.length; i++) {
            botoes[i].addActionListener(act);
        }
    }

    public JButton getMinimizar() {
        return botoes[0];
    }

    public JButton getMaximizar() {
        return botoes[1];
    }

    public JButton getFechar() {
        return botoes[2];
    }
}