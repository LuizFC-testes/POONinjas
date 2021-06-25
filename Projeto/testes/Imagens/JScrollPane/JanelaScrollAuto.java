import java.awt.*;
//import java.awt.image.BufferedImage;
import javax.swing.*;

public class JanelaScrollAuto extends JFrame {

    protected Container painel;
    protected JScrollPane sPainel;

    public JanelaScrollAuto() {
        super();
        setSize(300, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        painel = getContentPane();
        painel.setLayout(new GridLayout(1, 1));
        sPainel = new JScrollPane();
        painel.add(sPainel);
    }

    public void addImg(String filename) {
        ImgAutoAjustScroll imauto = new ImgAutoAjustScroll(this, sPainel, filename);
        JLabel img = new JLabel(imauto);
        /*BufferedImage bimg = imauto.getImg();
        Dimension min = new Dimension(bimg.getWidth()/2, bimg.getHeight()/2);
        img.setMinimumSize(min);*/
        sPainel.setViewportView(img);
    }

}