package Tema10.Ejercicios.Propios.Ejercicio3;

import java.util.ArrayList;

public class Pila<T> implements IPila<T> {

    // Creacion de atributo
    private final ArrayList<T> data;
    private final static int INITIAL_CAPACITY = 10;

    // Constructor
    public Pila() {
        // data = new ArrayList <>(INTIAL_CAPACITY);
        this(INITIAL_CAPACITY);
    }

    public Pila(int initialCapacity) {
        data = new ArrayList<>(initialCapacity);
    }

    @Override
    public T push(T e) {
        if (data.add(e)) {
            return e;
        }
        return null;
    }

    @Override
    public T pop() {
        if (!data.isEmpty()) {
            return data.remove(data.size() - 1);
        }
        return null;

    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public T top() {
        if (!isEmpty()) {
            return data.get(data.size() - 1);
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

}
