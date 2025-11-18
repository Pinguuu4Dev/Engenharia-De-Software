package Entidades.Factory;

import Componentes_Principais.AjudanteProxy;
import Entidades.Ajudante;
import Entidades.Anao;
import Entidades.Heroi;

public class AnaoFactory extends SpawnFactory {
    @Override
    public void spawn(Heroi heroi) {
        Ajudante anao = new Anao();
        System.out.println("🔨 Um Anão apareceu!");

        AjudanteProxy proxy = new AjudanteProxy(anao, heroi);
    }
}
