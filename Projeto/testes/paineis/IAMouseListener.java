import java.awt.event.*;

public interface IAMouseListener extends MouseListener {
    default public void mouseClicked(MouseEvent ev) {
        return ;
    }

    default public void mouseEntered(MouseEvent ev) {
        return ;
    }

    default public void mouseExited(MouseEvent ev) {
        return ;
    }

    default public void mousePressed(MouseEvent ev) {
        return ;
    }

    default public void mouseReleased(MouseEvent ev) {
        return ;
    }
}