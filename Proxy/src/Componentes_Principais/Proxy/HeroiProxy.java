package Componentes_Principais.Proxy;

import Entidades.Heroi;

public class HeroiProxy extends Proxy {

    public HeroiProxy (int situacao, Heroi heroi){
        if (situacao > 0) {
            writeToLog("Herói encontrou a saída do labirinto!");
            System.out.println("🏆 O herói encontrou a saída!");
        } else {
            writeToLog("Herói não encontrou a saída do labirinto e morreu!");
            System.out.println("💀 O herói morreu!");
        }
    }
}
