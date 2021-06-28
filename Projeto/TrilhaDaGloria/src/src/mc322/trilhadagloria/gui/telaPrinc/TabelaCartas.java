package mc322.trilhadagloria.gui.telaPrinc;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.*;
import javax.swing.event.ListSelectionEvent;

import mc322.trilhadagloria.carta.IStatusCarta;

public class TabelaCartas extends JTable {
	
	protected ArrayList<Integer> cardIDs;
	protected TableModelCartas tmc;
	protected ListSelectionModel lsm;
	
	public TabelaCartas(TableModelCartas tmc) {
		super(new TableModelCartas());
		this.tmc = tmc;
		lsm = getSelectionModel();
		cardIDs = new ArrayList<Integer>();
		setConfigs();
		setHeaders();
	}
	
	protected void setConfigs() {
		setColumnSelectionAllowed(false);
		setRowSelectionAllowed(true);
		setDragEnabled(false);
		setAutoCreateRowSorter(true);
		setFillsViewportHeight(true);
		lsm.setValueIsAdjusting(false);
		lsm.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
	
	public void removerCarta(IStatusCarta elim) {
		int idx = cardIDs.indexOf(elim.getID());
		cardIDs.remove(idx);
		tmc.removeRow(idx);
	}
}