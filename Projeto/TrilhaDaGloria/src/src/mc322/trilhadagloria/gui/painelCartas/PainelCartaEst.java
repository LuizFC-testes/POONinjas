package mc322.trilhadagloria.gui.painelCartas;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import mc322.trilhadagloria.carta.IStatusHeroi;


public class PainelCartaEst extends JPanel implements IRStatusHeroi {

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
        setLayout(null);
    }

    public void connectHeroi(IStatusHeroi hero) {
        this.hero = hero; 
    }

    public void gerarCarta() {
    	setBackground(hero.getDominio().getCor());
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
        add(iconePlayer);
    }

    private void mostrarClasse() {
        String classe = hero.getNome().toUpperCase();
        JLabel label = new JLabel(classe);
        
        label.setFont(new Font("Serif", Font.BOLD, 48));

        nomeCarta = new JPanel();
        nomeCarta.setOpaque(true);
        nomeCarta.setBorder(BorderFactory.createLineBorder(Color.BLACK, 10));

        nomeCarta.setLayout(new FlowLayout(FlowLayout.CENTER));
        nomeCarta.add(label);

        nomeCarta.setSize(500, 100);
        nomeCarta.setLocation(125, 25);
        add(nomeCarta);
    }

    private void mostrarImagem() {
        String asset = "IconeCarta" + hero.getNome() + ".png";

        imagemCarta = new JPanel();
        imagemCarta.setOpaque(true);
        imagemCarta.setLayout(null);
        imagemCarta.setBorder(BorderFactory.createLineBorder(Color.BLACK,10));
        imagemCarta.setSize(400, 400);

        ImgAjust img = new ImgAjust(asset);
        JLabel label = new JLabel(img);
        label.setSize(380,380);
        label.setLocation(10, 10);
        imagemCarta.add(label);

        imagemCarta.setLocation(25, 175);
        add(imagemCarta);
    }

    private void mostrarAtributos() {

        atributos = new JPanel();
        atributos.setOpaque(true);
        atributos.setBorder(BorderFactory.createLineBorder(Color.BLACK, 10));
        atributos.setSize(200, 150);
        atributos.setLayout(new GridLayout(3, 1));

        JPanel alcance = new JPanel();
        alcance.setLayout(new FlowLayout(FlowLayout.LEFT));
        ImgAjust iconeOlho = new ImgAjust("IconeOlho.png");
        alcance.add(new JLabel(iconeOlho));
        alcance.add(new JLabel("" + hero.getAlcance()));
        atributos.add(alcance);

        JPanel forca = new JPanel();
        forca.setLayout(new FlowLayout(FlowLayout.LEFT));
        ImgAjust iconeEspada = new ImgAjust("IconeEspada.png");
        forca.add(new JLabel(iconeEspada));
        int[] forcas = hero.getForcaBase();
        forca.add(new JLabel(forcas[0] + " (" + forcas[1] + ")"));
        atributos.add(forca);

        JPanel resist = new JPanel();
        resist.setLayout(new FlowLayout(FlowLayout.LEFT));
        ImgAjust escudo = new ImgAjust("IconeEscudo.png");
        resist.add(new JLabel(escudo));
        int[] res = hero.getResistBase();
        resist.add(new JLabel(res[0] + " (" + res[1] + ")"));
        atributos.add(resist);

        atributos.setLocation(425, 175);
        add(atributos);
    }

    private void mostrarBonus() {
        bonus = new JPanel();
        bonus.setOpaque(true);
        bonus.setBorder(BorderFactory.createLineBorder(Color.BLACK, 10));
        bonus.setSize(200, 250);
        bonus.setLayout(new GridLayout(4, 2));

        ImgAjust[] imgDoms = gerarIconesDominios();
        float[] porc = hero.getBonusHero();
        for (int i = 0; i < 8; i++) {
            String bon = "" + (int)(porc[i] * 100) + "%";
            
            JPanel bonusD = new JPanel();
            bonusD.setLayout(new FlowLayout(FlowLayout.LEFT));
            bonusD.add(new JLabel(imgDoms[i]));
            bonusD.add(new JLabel(bon));
            bonus.add(bonusD);
        }

        bonus.setLocation(425, 325);
        add(bonus);
    }

    private void mostrarHabilidades() {
    	JTextArea passivas = new JTextArea("Habilidades passivas: " + hero.getHabPass());
    	JTextArea ativas = new JTextArea("Habilidades ativas: " + hero.getHabAt());
        
        Font fonte = new Font(Font.SERIF, Font.PLAIN, 20);
        
        passivas.setEditable(false);
        passivas.setLineWrap(true);
        passivas.setWrapStyleWord(true);
        ativas.setEditable(false);
        ativas.setLineWrap(true);
        ativas.setWrapStyleWord(true);
        
        passivas.setFont(fonte);
        ativas.setFont(fonte);
        
        habilidade = new JPanel();
        habilidade.setOpaque(true);
        habilidade.setBorder(BorderFactory.createLineBorder(Color.BLACK, 10));
        habilidade.setSize(600, 210);
        habilidade.setLayout(new GridLayout(2, 1));

        habilidade.add(passivas);
        habilidade.add(ativas);

        habilidade.setLocation(25, 625);
        add(habilidade);
    }

    private ImgAjust[] gerarIconesDominios() {
        String []doms = new String[] {"Terra", "Flora", "Gelo", "Agua",
                                    "Fogo", "Ar", "Luz", "Sombra"};
        ImgAjust[] iconesDom = new ImgAjust[8];
        for (int i = 0; i < 8; i++) {
            iconesDom[i] = new ImgAjust("IconeDominio" + doms[i] + ".png");
            iconesDom[i].redimensionar(20, 20);
        }
        return iconesDom;
    }
}