package Itens;

import Entidades.Heroi;

public class Cura extends Item {
    public Cura(BonusItem bonus) { super(bonus); }

    @Override
    public void aplicaBonusHeroi(Heroi heroi) {
        heroi.curar(this.getBonus());
    }

    @Override
    public void retiraBonusHeroi(Heroi heroi) {
    }

    @Override
    public void imprimeDescricao() {
        System.out.println("Poção de Cura: +" + getBonus() + " de vida.");
    }

    @Override
    public String getTipo() {
        return "Cura";
    }
}
