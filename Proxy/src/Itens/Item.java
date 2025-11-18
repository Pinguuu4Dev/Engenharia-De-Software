package Itens;

import Entidades.Heroi;

public abstract class Item {
    protected BonusItem bonus;

    public Item(BonusItem bonus) {
        this.bonus = bonus;
    }

    public int getBonus() {
        return bonus.getValor();
    }

    public abstract void aplicaBonusHeroi(Heroi heroi);
    public abstract void retiraBonusHeroi(Heroi heroi);
    public abstract void imprimeDescricao();
    public abstract String getTipo();

    // Método auxiliar para "pegar" o item no chão e guardar no inventário
    public void juntar(Heroi heroi) {
        heroi.adicionarItem(this);
    }
}
