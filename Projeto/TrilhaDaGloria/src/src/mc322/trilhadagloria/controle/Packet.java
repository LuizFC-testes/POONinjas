package mc322.trilhadagloria.controle;

import java.io.Serializable;

public class Packet implements Serializable {
	private static final long serialVersionUID = -3407614460412459989L;

	public String msg;
	
	public Packet(String msg) {
		this.msg = msg;
	}
}
