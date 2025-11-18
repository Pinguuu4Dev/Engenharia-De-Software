package Itens;

import java.util.ArrayList;

public class Mochila
{
    ArrayList<Item> itens = new ArrayList<>();

    public void adicionarItem(Item item) {
        itens.add(item);
    }

    public void imprimirItens() {
        MochilaIterator iterator = new MochilaIterator(itens);

        System.out.println("| Itens da mochila:");
        while (iterator.hasNext()) {
            Item currentItem = iterator.next();

            System.out.println("| " + currentItem.getTipo() + ": +" + currentItem.getBonus() + " de " + currentItem.getTipoBonus());
        }
    }
}
