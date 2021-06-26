package mc322.trilhadagloria.controle;

import mc322.trilhadagloria.monarch.ICommand;

public interface IRCommand {
	public void conectaPlayer(ICommand monarca);

	public void conectaInimigo(ICommand inimigo);
}
