package Componentes_Principais.Proxy;

import Entidades.Heroi;
import Entidades.Monstro;

public class MonstroProxy extends Proxy {

    public MonstroProxy(Monstro monstro, Heroi heroi) {
        writeToLog("Herói vai batalhar contra um " + monstro.getTipo());
        monstro.batalha(heroi);
    }

}
