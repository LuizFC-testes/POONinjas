package mc322.trilhadagloria.gui.telaPrinc;

import mc322.trilhadagloria.carta.IStatusHeroi;

public interface IViewTerreno {

    public void gerarImgBio(String bio);

    public void adicionarHeroiAcima(IStatusHeroi heroi);

    public void adicionarHeroiAbaixo(IStatusHeroi heroi);
    
    public void removerCartaSuperior();
    	
    public void removerCartaInferior();

}