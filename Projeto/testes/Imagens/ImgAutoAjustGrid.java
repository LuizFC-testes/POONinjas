import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import java.awt.event.ComponentListener;
import java.awt.event.ComponentEvent;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.SwingUtilities;

public class ImgAutoAjustGrid extends ImgAjust implements ComponentListener {

    protected JanelaGridAuto framePrinc;
    protected Container painel;
    protected GridLayout grid;

    public ImgAutoAjustGrid(JanelaGridAuto framePrinc, Container painel, String filename) {
        super(filename);
        this.framePrinc = framePrinc;
        this.painel = painel;
        painel.addComponentListener(this);
        grid = (GridLayout)painel.getLayout();
    }

    public void componentResized(ComponentEvent ev) {
        try {
            int numLinhas = grid.getRows(),
                vGap = grid.getVgap();
            int novoY = (painel.getHeight() - vGap * (numLinhas - 1))/numLinhas;
            double novoXD = img.getWidth() * (novoY/(double)img.getHeight());
            int novoX = (int)novoXD;
            Image dimg = img.getScaledInstance(novoX, novoY, Image.SCALE_SMOOTH);
            setImage(dimg);
            
            SwingUtilities.updateComponentTreeUI(framePrinc);
        } catch (ArithmeticException ex) {
            System.out.println(painel.getHeight());
            System.out.println(painel.getWidth());
            System.out.println(grid.getVgap());
            System.out.println(grid.getRows());
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();
            System.out.println(painel.getHeight());
            System.out.println(painel.getWidth());
            System.out.println(grid.getVgap());
            System.out.println(grid.getRows());
            System.out.println(img.getHeight());
            System.out.println(img.getWidth());
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