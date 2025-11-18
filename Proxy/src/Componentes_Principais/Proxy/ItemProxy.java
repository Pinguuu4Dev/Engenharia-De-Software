package Componentes_Principais.Proxy;

import Entidades.Heroi;
import Itens.Item;

public class ItemProxy extends Proxy {
    public ItemProxy(Item item, Heroi heroi) {
        if (item.getTipo().equals("Escudo")) {
            writeToLog("Herói encontrou um " + item.getTipo());
        } else {
            writeToLog("Herói encontrou uma " + item.getTipo());
        }
        item.aplicaBonusHeroi(heroi);
        heroi.setMaoDireita(item);
    }

}
