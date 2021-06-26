import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JViewport;

import java.awt.event.ComponentListener;
import java.awt.event.ComponentEvent;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.SwingUtilities;

public class ImgAutoAjustScroll extends ImgAjust implements ComponentListener {

    protected JFrame framePrinc;
    protected JScrollPane painel;
    protected JViewport vp;

    public ImgAutoAjustScroll(JFrame framePrinc, JScrollPane painel, String filename) {
        super(filename);
        this.framePrinc = framePrinc;
        this.painel = painel;
        vp = painel.getViewport();
        setMinimumSize(img.getWidth()/2, img.getHeight()/2);
        vp.addComponentListener(this);
    }

    public void componentResized(ComponentEvent ev) {
        try {
            int novoY = vp.getHeight();
            double novoXD = img.getWidth() * (vp.getHeight()/(double)img.getHeight());
            int novoX = (int)novoXD;
            if (novoX >= minLarg && novoY >= minAlt) {
            Image dimg = img.getScaledInstance(novoX, novoY, Image.SCALE_SMOOTH);
            setImage(dimg);
            }
            SwingUtilities.updateComponentTreeUI(framePrinc);
        } catch (ArithmeticException ex) {
            
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();
            
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