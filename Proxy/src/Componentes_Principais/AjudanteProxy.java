package Componentes_Principais;

import Entidades.Ajudante;
import Entidades.Heroi;

public class AjudanteProxy {

    public AjudanteProxy(Ajudante ajudante, Heroi heroi) {
        System.out.println("Fez um log de ajudante");
        ajudante.ofereceAjuda(heroi);
    }

}
