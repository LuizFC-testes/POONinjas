package mc322.trilhadagloria.carta;

public class Magia extends Carta{

	public Magia(int id) {
		super(id);
	}

	@Override
	public String getTipo() {
		return "Magia";
	}

	@Override
	public String getNome() {
		return "Magia de " + dominio.toString().toLowerCase();
	}

}
