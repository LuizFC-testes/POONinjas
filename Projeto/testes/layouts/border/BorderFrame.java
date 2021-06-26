import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.SwingUtilities.*;

public class BorderFrame extends JFrame {

    Container painel;
    DisplaySize texto;
    JButton botao;

    private class DisplaySize extends JTextArea implements ComponentListener {

        JFrame frame;

        public DisplaySize(JFrame frame) {
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

    public BorderFrame() {
        super();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 600);
        painel = getContentPane();
        painel.setLayout(new BorderLayout());
        botao = new JButton("Botão");
        botao.setPreferredSize(new Dimension(200, 200));
        painel.add(botao, BorderLayout.LINE_END);
        texto = new DisplaySize(this);
        painel.add(texto, BorderLayout.PAGE_END);
        JPanel jp = new JPanel();
        jp.setMinimumSize(new Dimension(100, 100));
        jp.setPreferredSize(new Dimension(300,300));
        jp.setBackground(Color.YELLOW);
        painel.add(jp, BorderLayout.CENTER);
        setVisible(true);
    }

    public static void main(String[] args) {
        BorderFrame bf = new BorderFrame();
    }
}