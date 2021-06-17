import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.SwingUtilities;

public class BotaoEnable extends JFrame implements ActionListener {

    Container painel;
    JButton ativar;
    JButton desativar;
    JButton olamundo;

    public BotaoEnable() {
        super();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(350, 350);
        painel = getContentPane();
        painel.setLayout(new FlowLayout());
        ativar = new JButton("Ativar 'Olá Mundo'");
        ativar.addActionListener(this);
        //ativar.setLocation(50, 50);
        ativar.setSize(100, 100);
        painel.add(ativar);
        desativar = new JButton("Desativar 'Olá Mundo'");
        desativar.addActionListener(this);
        //desativar.setLocation(200, 50);
        desativar.setSize(100, 100);
        painel.add(desativar);
        olamundo = new JButton("Olá Mundo");
        olamundo.addActionListener(this);
        //olamundo.setLocation(125, 200);
        olamundo.setSize(100, 100);
        painel.add(olamundo);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ev) {
        JButton origem = (JButton)ev.getSource();
        if (origem == ativar) {
            olamundo.setEnabled(true);
        } else if (origem == desativar) {
            olamundo.setEnabled(false);
        } else if (origem == olamundo) {
            OlaMundoEnable ola = new OlaMundoEnable();
        }
        SwingUtilities.updateComponentTreeUI(this);
    }
}