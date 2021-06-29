package mc322.trilhadagloria.carta;

import java.awt.Container;
import java.util.ArrayList;

import javax.swing.JFrame;

import mc322.trilhadagloria.gui.painelCartas.PainelCartaEst;
import mc322.trilhadagloria.gui.telaPrinc.ITableCartas;

public class GrupoCartas implements IRTableCartas {
	ITableCartas view;
	protected ArrayList<Carta> cartas;
	
	public GrupoCartas() {
		cartas = new ArrayList<Carta>();
	}
	
	public int getNCartas() {
		return cartas.size();
	}

	public void adicionarCarta(Carta c) {
		cartas.add(c);
		
		if(view != null) {
			view.adicionarCarta(c);
		}
	}

	public boolean removerCarta(Carta c) {
		if(cartas.contains(c)) {
			cartas.remove(c);
			
			if(view != null) {
				view.removerCarta(c);
			}
			
			return true;
		}
		
		return false;
	}

	public Carta buscarCartaPorId(int cartaId) {
		for(Carta c : cartas) {
			if(c.getId() == cartaId) {
				return c;
			}
		}
		return null;
	}
	
	public void conecta(ITableCartas view) {
		this.view = view;
	}
	
	public void imprimir() {
		for(Carta c : cartas) {
			System.out.println("Classe: " + c.getClass() + "\tDominio: " + c.dominio.toString());
			
			JFrame frame = new JFrame("Heroi");
			frame.setSize(650, 900);
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			Container pane = frame.getContentPane();
			pane.setLayout(null);
			
			PainelCartaEst carta = new PainelCartaEst();
			carta.connectHeroi((Heroi)c);
			carta.gerarCarta();
			pane.add(carta);
			frame.setVisible(true);
		}
	}
}
