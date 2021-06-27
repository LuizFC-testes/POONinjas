import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JLabel;

public class FrameCartaTeste extends JFrame {

    public FrameCartaTeste() {
        super("FrameCartaTeste");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600,600);
        JScrollPane jsp = new JScrollPane();
        jsp.setSize(600, 600);
        jsp.setViewportView(new PainelCartaTeste(jsp));

        /*ImgAutoAjust iaa = new ImgAutoAjust(jsp, "Cogumelo.PNG");
        iaa.setMinDim(400, 400);
        iaa.defTamInic(1000, 1000);
        jsp.setViewportView(new JLabel(iaa));*/

        getContentPane().setLayout(new GridLayout(1, 1));
        getContentPane().add(jsp);
        setVisible(true);
    }

    public static void main(String[] args) {
        FrameCartaTeste fct = new FrameCartaTeste();
    }
}