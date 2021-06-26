import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BotaoAutonomo extends JButton implements ActionListener {
    private PaineisModificaveis principal;
    private Color corBot;

    public BotaoAutonomo(PaineisModificaveis principal, String nome, Color cor) {
        super(nome);
        this.principal = principal;
        corBot = cor;
    }

    public void actionPerformed(ActionEvent ev) {
        if ((BotaoAutonomo)ev.getSource() == this) {
            setEnabled(false);
            principal.setCor(corBot);
        } else {
            setEnabled(true);
        }
        
    }
}