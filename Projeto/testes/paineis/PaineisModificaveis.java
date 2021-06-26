import javax.swing.*;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import javax.swing.SwingUtilities.*;
//import java.awt.event.*;

public class PaineisModificaveis extends JFrame /*implements ActionListener*/ {

    private Container painel;
    private Color cor;

    public PaineisModificaveis() {
        super("Paineis Modificáveis");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 600);
        painel = getContentPane();
        painel.setLayout(new BorderLayout());
        cor = null;
        criarGrid();
        criarBotoes();
        setVisible(true);
    }

    private void criarGrid() {
        JPanel pain = new JPanel();
        pain.setLayout(new GridLayout(3, 3));
        for (int i = 0; i < 9; i++) {
            PainelPintavel pp = new PainelPintavel(this, "" + i);
            pain.add(pp);
        }
        painel.add(pain, BorderLayout.CENTER);
    }

    private void criarBotoes() {
        JPanel flow = new JPanel();
        flow.setLayout(new FlowLayout());
        BotaoAutonomo[] botoes = new BotaoAutonomo[4];
        botoes[0] = new BotaoAutonomo(this, "Borda Vermelha", Color.RED);
        botoes[1] = new BotaoAutonomo(this, "Borda Preta", Color.BLACK);
        botoes[2] = new BotaoAutonomo(this, "Borda Azul", Color.BLUE);
        botoes[3] = new BotaoAutonomo(this, "Resetar Painel", null);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                botoes[i].addActionListener(botoes[j]);
            }
            flow.add(botoes[i]);
        }
        painel.add(flow, BorderLayout.PAGE_END);
    }

    public void setCor(Color novaCor) {
        cor = novaCor;
        SwingUtilities.updateComponentTreeUI(this);
    }

    public void aplicarBorda(PainelPintavel pp) {
        if (cor != null) {
            pp.setBorder(BorderFactory.createLineBorder(cor, 10));
        } else {
            pp.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        }
        SwingUtilities.updateComponentTreeUI(this);
    }

}