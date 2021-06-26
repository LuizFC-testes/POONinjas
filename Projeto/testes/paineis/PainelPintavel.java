import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.BorderFactory;
import java.awt.event.*;

public class PainelPintavel extends JPanel implements IAMouseListener {

    PaineisModificaveis principal;
    
    public PainelPintavel(PaineisModificaveis principal, String icone) {
        super();
        this.principal = principal;
        JTextArea jta = new JTextArea(icone);
        jta.setEditable(false);
        add(jta);
        addMouseListener(this);
    }

     public void mouseClicked(MouseEvent ev) {
        principal.aplicarBorda(this);
    }
}