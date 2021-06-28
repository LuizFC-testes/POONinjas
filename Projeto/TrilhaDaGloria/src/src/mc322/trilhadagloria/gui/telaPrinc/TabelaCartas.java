package mc322.trilhadagloria.gui.telaPrinc;

import javax.swing.JTable;
import javax.swing.event.*;
import javax.swing.event.ListSelectionEvent;

import mc322.trilhadagloria.carta.IStatusCarta;

public class TabelaCartas extends JTable {
	
	protected ArrayList<float> cardIDs;
	protected TableModelCartas tmc;
	
	public TabelaCartas(TableModelCartas tmc) {
		super(new TableModelCartas());
		this.tmc = tmc;
		cardIDs = new Arraylist<float>();
		setConfigs();
		setHeaders();
	}
	
	protected void setConfigs() {
		setColumnSelectionAllowed(false);
		setRowSelectionAllowed(true);
		setDragEnabled(false);
		setAutoCreateRowSorter(true);
		setFillsViewportHeight(true);
	}
	
	protected void setHeaders() {
		String[] headers = new String[] {
				"Tipo", "Nome", "Domínio"
		};
		tmc.setColumnIdentifiers(headers);
	}
	
	public void adicionarCarta(IStatusCarta nova) {
		cardIDs.add(nova.getID());
		tmc.addRow(getCardInfos(nova));
	}
	
	protected String[] getCardInfos(IStatusCarta nova) {
		String []cardInfos = new String[3];
		cardInfos[0] = nova.getTipo();
		cardInfos[1] = nova.getNome();
		cardInfos[2] = nova.getDominio();
	}
}