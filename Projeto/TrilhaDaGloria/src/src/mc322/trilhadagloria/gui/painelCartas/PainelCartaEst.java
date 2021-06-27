package mc322.trilhadagloria.gui.painelCartas;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import mc322.trilhadagloria.monarch.IStatusHeroi;


public class PainelCartaEst extends JLayeredPane implements IRStatusHeroi {

    /**
	 * 
	 */
	private static final long serialVersionUID = 4719899253774223149L;

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

    public void connectHeroi(IStatusHeroi hero) {
        this.hero = hero; 
    }

    public void gerarCarta() {
        representarPlayer();
        mostrarClasse();
        mostrarImagem();
        mostrarAtributos();
        mostrarBonus();
        mostrarHabilidades();
    }

    private void representarPlayer() {
        iconePlayer = new JPanel();
        iconePlayer.setOpaque(true);
        iconePlayer.setBorder(BorderFactory.createLineBorder(Color.BLACK, 10));

        iconePlayer.setBackground(hero.getCorReino());

        iconePlayer.setSize(100, 100);
        iconePlayer.setLocation(25, 25);
        add(iconePlayer, PALETTE_LAYER);
    }

    private void mostrarClasse() {
        String classe = hero.getClasse().toUpperCase();
        JLabel label = new JLabel(classe);

        nomeCarta = new JPanel();
        nomeCarta.setOpaque(true);
        nomeCarta.setBorder(BorderFactory.createLineBorder(Color.BLACK, 10));

        nomeCarta.setLayout(new FlowLayout(FlowLayout.CENTER));
        nomeCarta.add(label);

        nomeCarta.setSize(500, 100);
        nomeCarta.setLocation(125, 25);
        add(nomeCarta, PALETTE_LAYER);
    }

    private void mostrarImagem() {
        String asset = "IconeCarta" + hero.getClasse() + ".png";

        imagemCarta = new JPanel();
        imagemCarta.setOpaque(true);
        imagemCarta.setBorder(BorderFactory.createLineBorder(Color.BLACK, 10));
        imagemCarta.setSize(400, 400);

        ImgAjust img = new ImgAjust(asset);
        imagemCarta.add(new JLabel(img));

        imagemCarta.setLocation(175, 25);
        add(imagemCarta, PALETTE_LAYER);
    }

    private void mostrarAtributos() {

        atributos = new JPanel();
        atributos.setOpaque(true);
        atributos.setBorder(BorderFactory.createLineBorder(Color.BLACK, 10));
        atributos.setSize(200, 150);
        atributos.setLayout(new GridLayout(3, 1));

        JPanel alcance = new JPanel();
        alcance.setLayout(new FlowLayout());
        alcance.add(new JLabel(new ImgAjust("IconeOlho.png")));
        alcance.add(new JLabel("" + hero.getAlcance()));
        atributos.add(alcance);

        /*JPanel forca = new JPanel();
        forca.setLayout(new FlowLayout());
        forca.add*/
        //FIXME
        

        atributos.setLocation(425, 175);
        add(atributos, PALETTE_LAYER);
    }

    private void mostrarBonus() {
        bonus = new JPanel();
        bonus.setOpaque(true);
        bonus.setBorder(BorderFactory.createLineBorder(Color.BLACK, 10));
        bonus.setSize(200, 250);
        bonus.setLayout(new GridLayout(4, 2));

        //FIXME

        

        bonus.setLocation(425, 375);
        add(bonus, PALETTE_LAYER);
    }

    private void mostrarHabilidades() {
        JLabel passivas = new JLabel("Habilidades passivas: " + hero.getHabPass());
        JLabel ativas = new JLabel("Habilidades ativas: " + hero.getHabAt());
        
        habilidade = new JPanel();
        habilidade.setOpaque(true);
        habilidade.setBorder(BorderFactory.createLineBorder(Color.BLACK, 10));
        habilidade.setSize(600, 250);
        habilidade.setLayout(new GridLayout(2, 1));

        habilidade.add(passivas);
        habilidade.add(ativas);

        habilidade.setLocation(25, 625);
        add(habilidade, PALETTE_LAYER);
    }


}