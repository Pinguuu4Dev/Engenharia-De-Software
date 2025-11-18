package Itens;

import Entidades.Heroi;

public class Espada extends Item {
    public Espada(BonusItem bonus) { super(bonus); }

    @Override
    public void aplicaBonusHeroi(Heroi heroi) {
        heroi.addAtaque(this.getBonus());
    }

    @Override
    public void retiraBonusHeroi(Heroi heroi) {
        heroi.addAtaque(-this.getBonus());
    }

    @Override
    public void imprimeDescricao() {
        System.out.println("Espada: +" + getBonus() + " de ataque.");
    }

    @Override
    public String getTipo() {
        return "Espada";
    }

    @Override
    public String getTipoBonus(){
        return "Ataque";
    }
}
