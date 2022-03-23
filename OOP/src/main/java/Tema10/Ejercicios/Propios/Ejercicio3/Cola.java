package Tema10.Ejercicios.Propios.Ejercicio3;

import java.util.ArrayList;

public class Cola<T> implements ICola<T> {

    
    private final int GROW_FACTOR = 2;
    private final int REORDER_FACTOR =20;
    private final ArrayList<T> data;
    private final static int INITIAL_CAPACITY = 10;
    private int first;
    private int last;

    public Cola() {
        this(INITIAL_CAPACITY);
        this.last =this.first = -1;
    }

    public Cola(int initialCapacity) {
        data = new ArrayList<>(initialCapacity);
    }

    @Override
    public T push(T e) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public T size() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public T pop() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public T isFull() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public T isEmpty() {
        // TODO Auto-generated method stub
        return null;
    }

}
