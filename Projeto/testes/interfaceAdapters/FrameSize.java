import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.FlowLayout;
import java.awt.event.ComponentEvent;
import javax.swing.SwingUtilities;
import java.awt.Container;

public class FrameSize extends JFrame {

    Container painel;
    SizeText texto;

    private class SizeText extends JTextArea implements IAComponentListener {

        FrameSize frame;

        public SizeText(FrameSize frame) {
            super("Largura da janela: XXXX\nAltura da Janela: XXXX");
            this.frame = frame;
            frame.addComponentListener(this);
        }

        public void componentResized(ComponentEvent ev) {
            int[] tam = {frame.getWidth(), 
                frame.getHeight()};
            
            String[] nums = new String[2];
            String numStr;
            for (int i = 0; i < 2; i++) {
                numStr = "";
                int pot = 1000;
                for (int j = 0; j < 3; j++) {
                    if (tam[i] < pot) {
                        numStr += "0";
                    }
                    pot /= 10;
                }
                numStr += tam[i];
                nums[i] = numStr;
            }
            replaceRange(nums[0], 19, 23);
            replaceRange(nums[1], 42, 46);
            SwingUtilities.updateComponentTreeUI(frame);
        }
    }

    public FrameSize() {
        super();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 600);
        painel = getContentPane();
        painel.setLayout(new FlowLayout());
        texto = new SizeText(this);
        painel.add(texto);
        setVisible(true);
    }

    public static void main(String[] args) {
        FrameSize fs = new FrameSize();
    }
}