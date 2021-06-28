package mc322.trilhadagloria.gui.telaPrinc;

import javax.swing.JPanel;
import java.awt.GridLayout;

public class TabView extends JPanel implements ITabConnect {
	
    ViewTerreno[][] terrenos;

    public TabView() {
        super();
        terrenos = new ViewTerreno[5][5];
        setLayout(new GridLayout(5, 5));
        for (int i = 0; i < 5; i++) {
        	for (int j = 0; j < 5; j++) {
        		terrenos[i][j] = new ViewTerreno();
        		add(terrenos[i][j]);
        	}
        }
    }

    public IViewTerreno getViewTerreno(int x, int y) {
    	return terrenos[x][y];
    }
}
