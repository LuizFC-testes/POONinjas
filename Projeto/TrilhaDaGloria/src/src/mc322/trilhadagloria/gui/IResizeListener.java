import java.awt.event.ComponentEvent;
import java.awt.Component;

import javax.swing.SwingUtilities;
import javax.swing.SwingUtilities.*;

public interface IResizeListener extends IAComponentListener {

    public abstract void redimensionar(int novaLarg, int novaAlt);

    public abstract int getWidth();

    public abstract int getHeight();

    public abstract int getMinLarg();

    public abstract int getMinAlt();

    public abstract double getFracLarg();

    public abstract double getFracAlt();
    
    default public void componentResized(ComponentEvent ev) {
        Component source = (Component)ev.getSource();
        int novaLarg, novaAlt;
        novaLarg = (int)(getWidth() * getFracLarg());
        novaAlt = (int)(source.getHeight() * getFracAlt());
        if (novaLarg >= getMinLarg() && novaAlt >= getMinAlt()) {
            redimensionar(novaLarg, novaAlt);
        }
        SwingUtilities.updateComponentTreeUI(source);
    }

}