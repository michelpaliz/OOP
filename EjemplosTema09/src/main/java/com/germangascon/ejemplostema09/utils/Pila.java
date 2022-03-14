package com.germangascon.ejemplostema09.utils;

import java.util.Arrays;

public class Pila<T> {
    private final static int GROW_FACTOR = 2;
    private T[] datos;
    private int tope;

    public Pila(int initialSize) {
        this.datos = (T[]) new Object[initialSize];
        this.tope = -1;
    }

    /**
     * Determina si la pila está llena
     * @return true si la pila está vacía o false en caso contrario
     */
    public boolean isEmpty() {
        return tope == -1;
    }

    /**
     * Determina si la pila está llena.
     * Si la pila es dinámica (como la actual) hacemos el método privado ya que carece de sentido
     * consultar este valor desde fuera de la clase.
     * @return true si la pila está llena o false en caso contrario
     */
    public boolean isFull() {
        return tope == datos.length - 1;
    }

    /**
     * Añade un elemento a la pila.
     * @param element Elemento a añadir
     */
    public boolean push(T element) {
        if(isFull()) {
            //datos = resize2(datos);
            resize(datos);
        }
        datos[++tope] = element;
        return true;
    }

    /**
     * Amplía el tamaño del array que representa los datos de la pila en un
     * factor de GROW_FACTOR
     * @param a El array a ampliar
     */
    private void resize(T[] a) {
        T[] newArray = (T[]) new Object[a.length * GROW_FACTOR];
        for(int i = 0; i < a.length; i++) {
            newArray[i] = a[i];
        }
        datos = newArray;
    }

    /**
     * Devuelve la cantidad de elementos que hay en la pila
     * No confundir con el tamaño del array que es un detalle interno.
     * @return Número de elementos que hay en la pila.
     */
    public int size() {
        return tope + 1;
    }

    /**
     * Consulta (sin extraer) el siguiente elemento de la pila.
     * @return Siguiente elemento de la pila o null si está vacía.
     */
    public T top() {
        if(!isEmpty()) {
            return datos[tope];
        }
        return null;
    }

    /**
     * Extrae el siguiente elemento de la pila.
     * @return Siguiente elemento de la pila o null si está vacía.
     */
    public T pop() {
        T element = null;
        if(!isEmpty()) {
            element = datos[tope--];
        }
        return element;
    }

    /**
     * Obtiene la representación de la Pila como una cadena de carácteres
     * @return String que representa el contenido de la pila como texto
     */
    @Override
    public String toString() {
        return "Pila{" +
                "datos=" + Arrays.toString(datos) +
                ", tope=" + tope +
                '}';
    }
}
