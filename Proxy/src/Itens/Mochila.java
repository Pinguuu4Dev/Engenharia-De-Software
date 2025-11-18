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
            System.out.println("- " + iterator.next());
        }
    }
}
