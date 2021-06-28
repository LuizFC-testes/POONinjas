package mc322.trilhadagloria.gui.telaPrinc;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridLayout;

public class IndicadorMana extends JPanel {

    JLabel mana;


    public IndicadorMana() {
        super();
        mana = new JLabel("5");
        setLayout(new GridLayout(2, 1));
        add(new JLabel("Mana:"));
        add(mana);
    }

    public void atualizarMana(int qtd) {
        mana.setText("" + qtd);
    }
}