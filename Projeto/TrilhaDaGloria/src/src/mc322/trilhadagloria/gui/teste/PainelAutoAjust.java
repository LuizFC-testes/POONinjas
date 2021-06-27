import javax.swing.JPanel;
import java.awt.Component;

public class PainelAutoAjust extends JPanel implements IResizeListener {

    int minLarg, minAlt;
    double fracLargAlt, fracAlt;
    Component subj;

    public PainelAutoAjust(Component subj) {
        super();
        this.subj = subj;
        subj.addComponentListener(this);
        setMinDim(0, 0);
    }

    public void setMinDim(int minLarg, int minAlt) {
        this.minLarg = minLarg;
        this.minAlt = minAlt;
    }

    public void defTamInic(int largInic, int altInic) {
        setSize(largInic, altInic);
        fracLargAlt = largInic / (double)altInic;
        fracAlt = altInic / (double)subj.getHeight();
    }

    public int getMinLarg() {
        return minLarg;
    }

    public int getMinAlt() {
        return minAlt;
    }

    public double getFracLargAlt() {
        return fracLargAlt;
    }

    public double getFracAlt() {
        return fracAlt;
    }

    public void redimensionar(int novaLarg, int novaAlt) {
        double proport = novaAlt / (double)getHeight();
        int novaPosX = (int)(getX() * proport),
            novaPosY = (int)(getY() * proport);
        setSize(novaLarg, novaAlt);
        setLocation(novaPosX, novaPosY);
    }

}