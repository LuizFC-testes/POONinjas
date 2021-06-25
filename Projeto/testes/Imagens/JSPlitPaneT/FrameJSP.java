import javax.swing.*;
import java.awt.*;

public class FrameJSP extends JFrame {

    protected Container painel;
    protected JSplitPane jsp;

    public FrameJSP() {
        super("FrameJSP");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(600, 600));
        setSize(600, 600);
        painel = getContentPane();
        painel.setLayout(new GridLayout(1, 1));
        jsp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        jsp.setOneTouchExpandable(true);
        jsp.setResizeWeight(0.7);
        painel.add(jsp);
    }

    public void addEsq(String filename, int largMin, int altMin) {
        JScrollPane jscp = new JScrollPane();
        ImgAutoAjustScroll img = new ImgAutoAjustScroll(this, jscp, filename);
        JLabel label = new JLabel(img);
        jscp.setViewportView(label);
        jscp.setMinimumSize(new Dimension(largMin, altMin));
        jsp.setLeftComponent(jscp);
    }

    public void addDir(String filename, int largMin, int altMin) {
        JScrollPane jscp = new JScrollPane();
        ImgAutoAjustScroll img = new ImgAutoAjustScroll(this, jscp, filename);
        JLabel label = new JLabel(img);
        jscp.setViewportView(label);
        jscp.setMinimumSize(new Dimension(largMin, altMin));
        jsp.setRightComponent(jscp);
    }
}