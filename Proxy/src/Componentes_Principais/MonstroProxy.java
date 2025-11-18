package Componentes_Principais;

import Entidades.Curupira;
import Entidades.Heroi;
import Entidades.Monstro;

public class MonstroProxy {

    public MonstroProxy(Monstro monstro, Heroi heroi) {
        monstro.batalha(heroi);
    }

}
