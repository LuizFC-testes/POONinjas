import java.awt.event.ComponentListener;
import java.awt.event.ComponentEvent;

public interface IAComponentListener extends ComponentListener {

    default public void componentResized(ComponentEvent ev) {
        return ;
    }

    default public void componentMoved(ComponentEvent ev) {
        return ;
    }

    default public void componentHidden(ComponentEvent ev) {
        return ;
    }

    default public void componentShown(ComponentEvent ev) {
        return ;
    }
}