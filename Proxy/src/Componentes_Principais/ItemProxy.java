package Componentes_Principais;

import Entidades.Heroi;
import Itens.Item;

public class ItemProxy {

    public ItemProxy(Item item, Heroi heroi) {
        System.out.println("Log de pegar item");

        item.aplicaBonusHeroi(heroi);
        heroi.setMaoDireita(item);
    }

}
