import java.awt.*;
import javax.swing.*;

public class JanelaGBL extends JFrame {
    protected Container painel;
    protected GridBagLayout layout;


    public JanelaGBL() {
        super();
        setSize(300, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        painel = getContentPane();
        layout = new GridBagLayout();
        painel.setLayout(layout);
    }

    public GridBagLayout getGridBL() {
        return layout;
    }

    public void addImg(String filename) {
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.VERTICAL;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 1;
        JLabel img = new JLabel(new ImgAjust(filename));
        painel.add(img, c);
    }

}