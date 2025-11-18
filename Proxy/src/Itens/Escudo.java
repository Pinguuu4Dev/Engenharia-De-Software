package Itens;

import Entidades.Heroi;

public class Escudo extends Item {
    public Escudo(BonusItem bonus) { super(bonus); }

    @Override
    public void aplicaBonusHeroi(Heroi heroi) {
        heroi.addDefesa(this.getBonus());
    }

    @Override
    public void retiraBonusHeroi(Heroi heroi) {
        heroi.addDefesa(-this.getBonus());
    }

    @Override
    public void imprimeDescricao() {
        System.out.println("Escudo: +" + getBonus() + " de defesa.");
    }

    @Override
    public String getTipo() {
        return "Escudo";
    }

    @Override
    public String getTipoBonus(){
        return "Defesa";
    }
}
