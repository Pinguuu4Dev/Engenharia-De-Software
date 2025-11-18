package Entidades.Factory;

import Entidades.Heroi;
import Itens.BonusItem;
import Itens.Cura;
import Itens.Item;

public class CuraFactory extends SpawnFactory {
    @Override
    public void spawn(Heroi heroi) {
        Item cura = new Cura(BonusItem.BONUS_CURA);
        System.out.println("❤️ Você encontrou uma Poção de Cura!");
        cura.aplicaBonusHeroi(heroi);
    }
}
