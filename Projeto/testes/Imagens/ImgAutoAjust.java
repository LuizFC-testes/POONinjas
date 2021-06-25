import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.Container;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import java.awt.event.ComponentListener;
import java.awt.event.ComponentEvent;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.SwingUtilities;

public class ImgAutoAjust extends ImgAjust implements ComponentListener {
    protected JanelaGBLAuto framePrinc;
    protected Container painel;

    public ImgAutoAjust(JanelaGBLAuto framePrinc, Container painel, String filename) {
        super(filename);
        this.framePrinc = framePrinc;
        this.painel = painel;
        painel.addComponentListener(this);
    }

    public void componentResized(ComponentEvent ev) {
        try {
            int[][] dimensoes = framePrinc.getGridBL().getLayoutDimensions();
            int tamPainelY = dimensoes[1][0];
            double novoTamImgXD = img.getWidth() * (tamPainelY/(double)img.getHeight());
            int novoTamImgX = (int)novoTamImgXD;
            Image dimg = img.getScaledInstance(novoTamImgX, tamPainelY,
            Image.SCALE_SMOOTH);
            setImage(dimg);
            /*GridBagConstraints c = getConstraints();
            painel.remove(this);
            painel.add(this, c);*/
            SwingUtilities.updateComponentTreeUI(framePrinc);
        } catch (ArithmeticException ex) {
            ex.printStackTrace();
        }
    }

    public void componentHidden(ComponentEvent ev) {
        return ;
    }

    public void componentShown(ComponentEvent ev) {
        return ;
    }

    public void componentMoved(ComponentEvent ev) {
        return ;
    }
}