package Entidades;

public class Curupira extends Entidade implements Monstro {
    public Curupira(int ataque, int defesa, int vida) {
        super(ataque, defesa, vida);
    }

    @Override
    public void batalha(Heroi heroi) {
        System.out.println("[Curupira] Ataca com " + this.ataque);
        heroi.receberDano(this.ataque);
    }

    @Override
    public void aplicarHabilidade() {
        System.out.println("[Curupira] Aplica habilidade: armadilha (sem efeito adicional no esqueleto).");
    }

    @Override
    public String getTipo() { return "Curupira"; }
}
