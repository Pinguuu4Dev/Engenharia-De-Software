package Entidades;

public interface Ajudante {
    void acaoMonstro(Monstro monstro);
    void acaoHeroi(Heroi heroi);
    void cumprimentar();
    String getTipo();

    default void ofereceAjuda(Heroi heroi) {
        System.out.println(getTipo() + " oferece ajuda...");
        cumprimentar();
        acaoHeroi(heroi);
    }
}
