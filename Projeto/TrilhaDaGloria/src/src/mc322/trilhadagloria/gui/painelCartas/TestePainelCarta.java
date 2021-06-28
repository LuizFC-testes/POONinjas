package mc322.trilhadagloria.gui.painelCartas;

import javax.swing.JFrame;
import java.awt.Container;
import javax.swing.JScrollPane;

import mc322.trilhadagloria.carta.Barbaro;
import mc322.trilhadagloria.carta.Dominio;
import mc322.trilhadagloria.carta.Heroi;
import mc322.trilhadagloria.monarch.*;

public class TestePainelCarta {

    public static JFrame frame;
    public static Container pane;

    /*public void criarFrame() {
        frame = new JFrame("Frame Teste Painel");
        frame.setSize(600,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pane = frame.getContentPane();
        PainelCartaEst carta = new PainelCartaEst();
        carta.connectHeroi(new Paladino(0, Dominio.AGUA));
        carta.gerarCarta();
        JScrollPane scroll = new JScrollPane(carta);
        scroll.setSize(600, 600);
        pane.add(scroll);
        frame.setVisible(true);
    }*/

    public static void main(String[] args) {
        frame = new JFrame("Frame Teste Painel");
        frame.setSize(650, 900);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pane = frame.getContentPane();
        pane.setLayout(null);
        Monarca monarca = new Monarca(0, new String[] {"0;Barbaro;FOGO","0;Barbaro;FOGO","0;Barbaro;FOGO","0;Barbaro;FOGO","0;Barbaro;FOGO","0;Barbaro;FOGO","0;Barbaro;FOGO","0;Barbaro;FOGO","0;Barbaro;FOGO","0;Barbaro;FOGO","0;Barbaro;FOGO","0;Barbaro;FOGO","0;Barbaro;FOGO","0;Barbaro;FOGO","0;Barbaro;FOGO","0;Barbaro;FOGO","0;Barbaro;FOGO",});
        
        Heroi h = new Barbaro(0, Dominio.AGUA);
        h.setDono(monarca);
        
        PainelCartaEst carta = new PainelCartaEst();
        carta.connectHeroi(h);
        carta.gerarCarta();
        pane.add(carta);
        frame.setVisible(true);
    }

}