import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Dimension;

public class ScrollImg extends JFrame {

    private Container painel;

    public ScrollImg() {
        super();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 600);
        painel = getContentPane();
        painel.setLayout(new GridLayout(1, 1));
        JScrollPane js = new JScrollPane();
        ImgAjust ia = new ImgAjust("Barbaro.jpg");
        js.setViewportView(new JLabel(ia));
        //js.setPreferredSize(new Dimension(600,600));
        //js.setSize(600, 600);
        painel.add(js);
        setVisible(true);
    }

    public static void main(String[] args) {
        ScrollImg si = new ScrollImg();
    }

}