package mc322.trilhadagloria.gui.painelCartas;

import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

public class ImgAjust extends ImageIcon {
    protected static String DIRETORIO = ImgAjust.class.getResource(".").getPath();
    protected static String PACOTE = DIRETORIO.split("/")[DIRETORIO.split("/").length - 1];
    protected String ASSETS = DIRETORIO.substring(0, DIRETORIO.length() - PACOTE.length() - 1) + "assets/";
    protected BufferedImage img;

    public ImgAjust(String filename) {
        super();
        img = null;
        try {
            img = ImageIO.read(new File(ASSETS + filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image dimg = img.getScaledInstance(img.getWidth(), img.getHeight(),
        Image.SCALE_SMOOTH);
        setImage(dimg);
    }

    public void redimensionar(int novaLarg, int novaAlt) {
        Image dimg = img.getScaledInstance(novaLarg, novaAlt,
        Image.SCALE_SMOOTH);
        setImage(dimg);
    }

    public String toString() {
        return ASSETS;
    }

}