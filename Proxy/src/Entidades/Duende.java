package Entidades;

public class Duende implements Ajudante {
    @Override
    public void acaoMonstro(Monstro monstro) {
        System.out.println("[Duende] observa o monstro: " + monstro.getTipo());
    }

    @Override
    public void acaoHeroi(Heroi heroi) {
        System.out.println("[Duende] aumenta ataque do herói em 2");
        heroi.addAtaque(2);
    }

    @Override
    public void cumprimentar() { System.out.println("[Duende] Olá, jovem aventureiro!"); }

    @Override
    public String getTipo() { return "Duende"; }
}
