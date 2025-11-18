package Entidades.Factory;

import Componentes_Principais.Proxy.ItemProxy;
import Entidades.Heroi;
import Itens.BonusItem;
import Itens.Escudo;
import Itens.Item;

public class EscudoFactory extends SpawnFactory {
    @Override
    public void spawn(Heroi heroi) {
        Item escudo = new Escudo(BonusItem.BONUS_ESCUDO);
        System.out.println("🛡️ Você encontrou um Escudo!");

        ItemProxy proxyEscudo = new ItemProxy(escudo, heroi);
    }
}
