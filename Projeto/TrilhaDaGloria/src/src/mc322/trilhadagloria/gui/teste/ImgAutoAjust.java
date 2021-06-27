import java.awt.Component;
import java.awt.Image;

public class ImgAutoAjust extends ImgAjust implements IImgIconResizeListener {

    int minLarg, minAlt;
    double fracLargAlt, fracAlt;
    Component subj;

    public ImgAutoAjust(Component subj, String filename) {
        super(filename);
        this.subj = subj;
        subj.addComponentListener(this);
    }

    public void setMinDim(int minLarg, int minAlt) {
        this.minLarg = minLarg;
        this.minAlt = minAlt;
    }

    public void defTamInic(int largInic, int altInic) {
        redimensionar(largInic, altInic);
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
        Image dimg = img.getScaledInstance(novaLarg, novaAlt, Image.SCALE_SMOOTH);
        setImage(dimg);
    }
}