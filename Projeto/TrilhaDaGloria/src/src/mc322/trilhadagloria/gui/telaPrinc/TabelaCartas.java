package mc322.trilhadagloria.gui.telaPrinc;

import javax.swing.JTable;
import javax.swing.event.*;
import javax.swing.event.ListSelectionEvent;

public class TabelaCartas extends JTable {
	
	protected ArrayList<float> cardIDs;
	protected TableModelCartas tmc;
	
	public TabelaCartas(TableModelCartas tmc) {
		super(new TableModelCartas());
		this.tmc = tmc;
		cardIDs = new Arraylist<float>();
		setConfigs();
	}
	
	protected setConfigs() {
		setColumnSelectionAllowed(false);
		setRowSelectionAllowed(true);
		setDragEnabled(false);
		setAutoCreateRowSorter(true);
		
	}
}