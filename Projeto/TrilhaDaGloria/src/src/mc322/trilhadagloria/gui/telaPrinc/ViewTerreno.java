package mc322.trilhadagloria.gui.telaPrinc;

import mc322.trilhadagloria.gui.painelCartas.ImgAjust;
import mc322.trilhadagloria.field.IVisualField;
import mc322.trilhadagloria.carta.IStatusHeroi;
import mc322.trilhadagloria.field.Bioma;

import javax.swing.JLayeredPane;
import javax.swing.JLabel;


public class ViewTerreno extends JLayeredPane implements IViewTerreno {

    public ViewTerreno(int x, int y) {
        super();
        setSize(100, 100);
        setOpaque(true);
    }


    public void gerarImgBio(String bio) {
        String bioma = bio + ".png";
        ImgAjust imgBio = new ImgAjust(bioma);
        imgBio.redimensionar(100, 100);
        add(new JLabel(imgBio), DEFAULT_LAYER);
    }

    public void adicionarHeroiAcima(IStatusHeroi heroi) {
        JLabel labelHero = criarIconeHeroi(heroi.getClasse());
        labelHero.setLocation(55, 5);
        add(labelHero, PALETTE_LAYER);
    }

    public void adicionarHeroiAbaixo(IStatusHeroi heroi) {
        JLabel labelHero = criarIconeHeroi(heroi.getClasse());
        labelHero.setLocation(55, 55);
        add(labelHero, PALETTE_LAYER);
    }

    private JLabel criarIconeHeroi(String classeHeroi) {
        String nomeImg = "IconeTerreno" + classeHeroi + ".png";
        ImgAjust imgHero = new ImgAjust(nomeImg);
        imgHero.redimensionar(40, 40);
        return new JLabel(imgHero);
    }
    
}