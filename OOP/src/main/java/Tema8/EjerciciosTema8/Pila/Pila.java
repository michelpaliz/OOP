package Tema8.EjerciciosTema8.Pila;

import java.util.Arrays;

public class Pila {

    // la pila tiene que ser private para que se maneja autamicamente como abstracto
    private final static int GROWFACTOR = 2;
    private int[] datos;
    private int tope;

    public Pila(int initialSize) {
        this.datos = new int[initialSize];
        // this.tope = 0
        this.tope = -1; // tope en teoria no puede ser negativo;
    }

    public boolean isEmpty() {
        return tope == -1;
        // return tope < 0;
    }

    public boolean isFull() {
        return tope == datos.length - 1;
    }

    // creamos un tipo pila int
    public boolean push(int elemento) {
        // para saber si la pila esta llena
        if (!isFull()) {
            // datos[tope + 1] = elemento; este no incrementa el tope
            // datos[++tope] = elemento; // incrementa el tope
            datos = resize();
            // return true;
        }
        datos[++tope] = elemento;
        return true;
    }

    // +Todo EJERCICIO..

    public int size() {
        return tope + 1;
    }

    public Integer top() {
        if (!isEmpty()) {
            return datos[tope]; // esto funcionara si el tope no es -1 que significa que estara vacia
        }
        return null;
    }

    // devolver el elemento y borrar la pila
    public Integer pop() {
        if (!isEmpty()) {
            return datos[tope--]; // se hace despues de devolver el dato
        }
        return null;
    }

    // yo lo que quiero es que la pila se gestione si mismo
    // dos formas de hacerlo
    public int[] resize() {
        int[] newArray = new int[datos.length * GROWFACTOR];
        for (int i = 0; i < datos.length; i++) {
            newArray[i] = datos[i];
        }
        return newArray;
    }

    // otra fforma de hacerlo
    private int[] resize2(int[] a) {
        int[] newArray = new int[a.length * GROWFACTOR];
        for (int i = 0; i < a.length; i++) {
            newArray[i] = a[i];
        }

        return newArray;
    }

    private void resize3(int[] a) {
        int[] newArray = new int[a.length * GROWFACTOR];
        for (int i = 0; i < a.length; i++) {
            newArray[i] = a[i];
        }

        datos = newArray;
    }


    @Override
    public String toString() {
        return "Pila{" +
                "datos=" + Arrays.toString(datos) +
                ", tope=" + tope +
                '}';
    }
}
