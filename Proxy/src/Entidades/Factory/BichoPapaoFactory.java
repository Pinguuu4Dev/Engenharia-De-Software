package Entidades.Factory;

import Entidades.Bicho_Papao;
import Entidades.Heroi;

public class BichoPapaoFactory extends SpawnFactory {
    @Override
    public void spawn(Heroi heroi) {
        Bicho_Papao bichoPapao = new Bicho_Papao(2, 2, 5);

        System.out.println("⚔️ Encontro com Bicho-Papão!");
        bichoPapao.batalha(heroi);
    }
}
