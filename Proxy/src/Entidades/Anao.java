package Entidades;

public class Anao implements Ajudante {
    @Override
    public void acaoMonstro(Monstro monstro) {
        System.out.println("[Anão] observa e ignora o monstro por enquanto.");
    }

    @Override
    public void acaoHeroi(Heroi heroi) {
        System.out.println("[Anão] fortalece defesa do herói em 2");
        heroi.addDefesa(2);
    }

    @Override
    public void cumprimentar() { System.out.println("[Anão] Saudações, guerreiro!"); }

    @Override
    public String getTipo() { return "Anão"; }
}
