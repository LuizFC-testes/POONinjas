import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import java.awt.GridLayout;

public class PainelCartaTeste extends JLPaneAutoAjust {

    public PainelCartaTeste(Component subj) {
        super(subj);
        defTamInic(700, 1000);
        setMinDim(getWidth()/2, getHeight() / 2);

        PainelAutoAjust fundo = criarPAA(650, 900, 25, 50);
        fundo.setBackground(Color.YELLOW);
        setLayer(fundo, DEFAULT_LAYER);

        PainelAutoAjust paa = criarPAA(100, 100, 50, 75);
        paa.setBackground(Color.GREEN);

        //paa = criarPAA(500, 100, 125, 25);


        /*paa = criarPAA(400, 400, 25, 175);
        ImgAutoAjust iaa = new ImgAutoAjust(paa, "Cogumelo.PNG");
        iaa.defTamInic(400, 400);
        paa.setLayout(new GridLayout(1, 1));
        paa.add(new JLabel(iaa));

        paa = criarPAA(200, 150, 425, 175);
        paa.setBackground(Color.BLUE);

        paa = criarPAA(200, 250, 425, 325);

        paa = criarPAA(600, 250, 25, 625);*/
    }

    private PainelAutoAjust criarPAA(int lInic, int aInic, int xInic, int yInic) {
        PainelAutoAjust paa = new PainelAutoAjust(this);
        paa.defTamInic(lInic, aInic);
        paa.setLocation(xInic, yInic);
        add(paa, PALETTE_LAYER);
        return paa;
    }
}