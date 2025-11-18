package Entidades;

import Itens.Item;
import Itens.Mochila;

import java.util.ArrayList;
import java.util.List;

public class Heroi extends Entidade {
    private Item maoDireita;
    private Item maoEsquerda;
    private Ajudante ajudante;
    private final List<Item> inventario;

    Mochila mochila;


    public Heroi() {
        super(2, 1, 3);
        this.inventario = new ArrayList<>();
        this.mochila = new Mochila();
    }


    public Heroi(int vida, int ataque, int defesa) {
        super(ataque, defesa, vida);
        this.inventario = new ArrayList<>();
        this.mochila = new Mochila();
    }

    public Item getMaoDireita() { return maoDireita; }
    public Item getMaoEsquerda() { return maoEsquerda; }

    public void setMaoDireita(Item item) {
        if (this.maoDireita != null) {
            //this.maoDireita.retiraBonusHeroi(this);
            mochila.adicionarItem(item);
        }
        else  {
            this.maoDireita = item;
        }
        //if (this.maoDireita != null) this.maoDireita.aplicaBonusHeroi(this);
    }

    public void setMaoEsquerda(Item item) {
        if (this.maoEsquerda != null) {
            //this.maoEsquerda.retiraBonusHeroi(this);
            mochila.adicionarItem(item);
        }
        else  {
            this.maoEsquerda = item;
        }
        //if (this.maoEsquerda != null) this.maoEsquerda.aplicaBonusHeroi(this);
    }

    public Ajudante getAjudante() { return ajudante; }
    public void setAjudante(Ajudante ajudante) { this.ajudante = ajudante; }

    public void addAtaque(int valor) {
        this.ataque += valor;
        System.out.println("=> Ataque do herói agora: " + this.ataque);
    }

    public void addDefesa(int valor) {
        this.defesa += valor;
        System.out.println("=> Defesa do herói agora: " + this.defesa);
    }

    public void receberDano(int dano) {
        int danoFinal = Math.max(0, dano - this.defesa);
        this.vida -= danoFinal;
        System.out.println("⚠️ Herói recebeu " + danoFinal + " de dano. Vida atual: " + this.vida);
    }

    public void curar(int qtd) {
        this.vida += qtd;
        System.out.println("❤️ Herói recuperou " + qtd + " de vida. Vida atual: " + this.vida);
    }

    public void adicionarItem(Item item) {
        this.inventario.add(item);
        System.out.println("📦 Item adicionado: " + item.getTipo());
    }

    public List<Item> getInventario() { return inventario; }

    public void imprimirStatus() {
        System.out.println("| Status do Herói:");
        System.out.println("Vida: " + getVida());
        System.out.println("Ataque: " + getAtaque());
        System.out.println("Defesa: " + getDefesa() + "\n");

        if (mochila != null)
            mochila.imprimirItens();
    }
}
