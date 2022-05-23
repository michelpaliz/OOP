package Tema10.Ejercicios.Propios.Ejercicio3;

import java.util.ArrayList;

import javax.lang.model.element.Element;

public class Cola<T> implements ICola<T> {

    private final static int INITIAL_CAPACITY = 10;
    private final ArrayList<T> data;

    private int first;
    private int last;

    public Cola() {
        this(INITIAL_CAPACITY);
        // this.last = this.first = -1;
        this.first = 0;
    }

    public Cola(int initialCapacity) {
        data = new ArrayList<>(initialCapacity);
    }

    @Override
    public boolean push(T e) {
        return data.add(e);
    }

    @Override
    public T remove() {
        T element = null;
        if (!isEmpty()) {
            element = data.remove(first);
        }
        return element;
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public T peek() {
        T element = null;
        if ((!isEmpty())) {
            element = data.get(first);
        }
        return element;
    }

}
