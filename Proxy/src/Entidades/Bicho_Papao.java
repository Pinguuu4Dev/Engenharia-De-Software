package Entidades;

public class Bicho_Papao extends Entidade implements Monstro {
    public Bicho_Papao(int ataque, int defesa, int vida) {
        super(ataque, defesa, vida);
    }

    @Override
    public void batalha(Heroi heroi) {
        System.out.println("[BichoPapão] Ataca com " + this.ataque);
        heroi.receberDano(this.ataque);
    }

    @Override
    public void aplicarHabilidade() {
        System.out.println("[BichoPapão] Aplica habilidade: medo (sem efeito adicional no esqueleto).");
    }

    @Override
    public String getTipo() { return "Bicho Papão"; }
}
