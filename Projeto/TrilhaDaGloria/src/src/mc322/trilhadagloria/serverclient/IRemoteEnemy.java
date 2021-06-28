package mc322.trilhadagloria.serverclient;

public interface IRemoteEnemy {
	public void ouvirOponente();

	public void enviarMensagem(Mensagem msg);

	public void fimDeJogo();
}
