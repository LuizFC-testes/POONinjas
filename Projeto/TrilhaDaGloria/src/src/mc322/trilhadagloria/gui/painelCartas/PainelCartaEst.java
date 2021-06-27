package mc322.trilhadagloria.gui.painelCartas;

import javax.swing.JPanel;
import javax.swing.JLayeredPane;
import javax.swing.border.*;
import java.awt.color.*;

import mc322.trilhadagloria.gui.painelCartas.IRStatusHeroi;
import mc322.trilhadagloria.monarch.IStatusHeroi;

public class PainelCartaEst extends JLayeredPane implements IRStatusHeroi {

    private IStatusHeroi hero;

    JPanel iconePlayer,
           nomeCarta,
           imagemCarta,
           atributos,
           bonus,
           habilidade;

    public PainelCartaEst() {
        super();
        setSize(650, 900);
        setOpaque(true);
    }

    public connectHeroi(IStatusHeroi hero) {
        this.hero = hero; 
    }

    public void representarPlayer()
}