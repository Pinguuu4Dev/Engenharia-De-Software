package Componentes_Principais.Proxy;

import Entidades.Ajudante;
import Entidades.Heroi;

public class AjudanteProxy extends Proxy {

    public AjudanteProxy(Ajudante ajudante, Heroi heroi) {
        writeToLog("Herói se aproximou de um " + ajudante.getTipo());
        ajudante.ofereceAjuda(heroi);
    }

}
