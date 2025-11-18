package Itens;

import java.util.ArrayList;
import java.util.Iterator;

public class MochilaIterator implements Iterator<Item> {
    private ArrayList<Item> _itens;
    private int _index = 0;

    public MochilaIterator(ArrayList<Item> itens) {
        _itens = itens;
    }

    @Override
    public boolean hasNext() {
        return _index < _itens.size();
    }

    @Override
    public Item next() {
        return _itens.get(_index++);
    }
}
