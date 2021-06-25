import java.awt.*;
import javax.swing.*;

public class JanelaGBLAuto extends JanelaGBL {

    public void addImg(String filename) {
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.VERTICAL;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 1;
        JLabel img = new JLabel(new ImgAutoAjust(this, painel, filename));
        painel.add(img, c);
    }

}