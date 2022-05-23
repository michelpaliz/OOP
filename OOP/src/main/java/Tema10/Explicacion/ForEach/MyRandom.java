package Tema10.Explicacion.ForEach;

import java.util.Iterator;
import java.util.Random;

//El iterable sirve para que el bucle funcione
// public class MyRandom<Integer> implements Iterable<Integer>, Iterator<Integer>
public class MyRandom implements Iterable<Integer>, Iterator<Integer> {

    private Random r;
    private int count;

    // se crea la semilla
    public MyRandom(int count) {
        r = new Random();
        this.count = count;
    }

    public MyRandom(int count, long seed) {
        r = new Random(seed);
        this.count = count;
    }

    // Iterable
    /**
     * 
     */
    @Override
    public Iterator<Integer> iterator() {

        return this; // me devuelvo a mi mismo xq soy yo el iterador
    }

    // Iterator
    @Override
    public boolean hasNext() {
        return count > 0;
    }

    @Override
    public Integer next() {
        count--;
        return r.nextInt();
    }

}
