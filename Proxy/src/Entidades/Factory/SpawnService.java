package Entidades.Factory;

import Entidades.Heroi;

public class SpawnService
{
    private final SpawnFactory factory;

    public SpawnService(SpawnFactory factory) {
        this.factory = factory;
    }

    public void spawn(Heroi heroi) {
        factory.spawn(heroi);
    }
}
