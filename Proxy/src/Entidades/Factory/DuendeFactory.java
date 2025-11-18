package Entidades.Factory;

import Componentes_Principais.Proxy.AjudanteProxy;
import Entidades.Ajudante;
import Entidades.Duende;
import Entidades.Heroi;

public class DuendeFactory extends SpawnFactory {

    @Override
    public void spawn(Heroi heroi) {
        Ajudante duende = new Duende();
        System.out.println("🧝 Um Duende apareceu!");

        AjudanteProxy proxyDuende = new AjudanteProxy(duende, heroi);
    }
}
