package mc322.trilhadagloria.gui.telaPrinc;

import javax.swing.table.DefaultTableModel;

public class TableModelCartas extends DefaultTableModel {
	
	
	
	public TableModelCartas() {
		super();
	}
	
	public boolean isCellEditable(int linha, int coluna) {
		return false;
	}
	
}