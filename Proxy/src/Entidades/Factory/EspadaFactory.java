package Entidades.Factory;

import Componentes_Principais.Proxy.ItemProxy;
import Entidades.Heroi;
import Itens.BonusItem;
import Itens.Espada;
import Itens.Item;

public class EspadaFactory extends SpawnFactory {
    @Override
    public void spawn(Heroi heroi) {
        Item espada = new Espada(BonusItem.BONUS_ESPADA);
        System.out.println("🗡️ Você encontrou uma Espada!");

        ItemProxy proxyEspada = new ItemProxy(espada, heroi);
    }
}
