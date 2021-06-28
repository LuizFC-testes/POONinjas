package mc322.trilhadagloria.gui.telaPrinc;

import mc322.trilhadagloria.carta.IStatusCarta;

public interface IViewTerreno {

    public void gerarImgBio(String bio);

    public void adicionarCartaAcima(IStatusCarta carta);

    public void adicionarCartaAbaixo(IStatusCarta carta);
    
    public void removerCartaSuperior();
    	
    public void removerCartaInferior();

}