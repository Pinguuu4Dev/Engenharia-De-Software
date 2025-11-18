package Entidades.Factory;

import Componentes_Principais.Proxy.MonstroProxy;
import Entidades.Curupira;
import Entidades.Heroi;
import Entidades.Monstro;

public class CurupiraFactory extends SpawnFactory {
    @Override
    public void spawn(Heroi heroi) {
        Monstro curupira = new Curupira(3, 1, 3);
        System.out.println("⚔️ Encontro com Curupira!");

        MonstroProxy curupiraProxy = new MonstroProxy(curupira, heroi);
    }
}
