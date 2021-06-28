package mc322.trilhadagloria.gui.telaPrinc;

import mc322.trilhadagloria.field.IVisualField;
import mc322.trilhadagloria.carta.IStatusHeroi;

public interface IViewTerreno {

    public void connect(IVisualField terreno);

    public void adicionarHeroiAcima(IStatusHeroi heroi);

    public void adicionarHeroiAbaixo(IStatusHeroi heroi);

}