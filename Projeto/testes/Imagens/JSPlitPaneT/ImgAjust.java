import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

public class ImgAjust extends ImageIcon {
    protected static String DIRETORIO = ImgAjust.class.getResource(".").getPath();
    protected BufferedImage img;
    protected int minLarg, minAlt;

    public ImgAjust(String filename) {
        super();
        img = null;
        try {
            img = ImageIO.read(new File(DIRETORIO + filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image dimg = img.getScaledInstance(img.getWidth(), img.getHeight(),
        Image.SCALE_SMOOTH);
        setImage(dimg);
    }

    public BufferedImage getImg() {
        return img;
    }

    public void setMinimumSize(int largura, int altura) {
        minLarg = largura;
        minAlt = altura;
    }

}