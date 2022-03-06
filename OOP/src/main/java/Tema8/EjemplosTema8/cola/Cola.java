package Tema8.EjemplosTema8.cola;

import java.util.Arrays;

public class Cola {
    private final static int DEFAULT_SIZE = 10;
    private final static int GROW_FACTOR = 2;
    private int[] data;
    private int first;
    private int last;

    public Cola() {
        // Llamamos al otro constructor
        this(DEFAULT_SIZE);
    }

    public Cola(int initialSize) {
        data = new int[initialSize];
        first = -1;
        last = -1;
    }

    /**
     * Añade un elemento a la cola.
     * @param elem Elemento a añadir
     */
    public void add(int elem) {
        if(isEmpty()) {
            first = 0;
        } else if(isFull()) {
            data = resize();
        }
        data[++last] = elem;
    }

    /**
     * Amplía el tamaño del array que representa los datos de la cola en un
     * factor de GROW_FACTOR.
     * @return El nuevo array creado
     */
    private int[] resize() {
        int[] newArray = new int[data.length * GROW_FACTOR];
        int count = 0;
        for(int i = first; i <= last; i++) {
            newArray[count++] = data[i];
        }
        first = 0;
        last = count -1;
        return newArray;
    }

    /**
     * Devuelve la cantidad de elementos que hay en la cola
     * No confundir con el tamaño del array que es un detalle interno.
     * @return Número de elementos que hay en la cola.
     */
    public int size() {
        if(isEmpty())
            return 0;
        return last - first + 1;
    }

    /**
     * Extrae el siguiente elemento de la Cola.
     * @return Siguiente elemento de la cola o null si está vacía.
     */
    public Integer remove() {
        Integer element = null;
        if(!isEmpty()) {
            element = data[first];
            // Comprobar si es el último elemento
            if(first == last) {
                first = -1;
                last = -1;
            } else {
                first++;
            }
        }
        return element;
    }

    /**
     * Consulta (sin extraer) el siguiente elemento de la Cola.
     * @return Siguiente elemento de la cola o null si está vacía.
     */
    public Integer peek() {
        Integer element = null;
        if(!isEmpty()) {
            element = data[first];
        }
        return element;
    }

    /**
     * Determina si la cola está llena.
     * Si la cola es dinámica hacemos el método privado ya que carece de sentido
     * consultar este valor desde fuera de la clase.
     * @return true si la cola está llena o false en caso contrario
     */
    private boolean isFull() {
        return last == data.length -1;
    }

    /**
     * Determina si la cola está vacía
     * @return true si la cola está vacía o false en caso contrario
     */
    public boolean isEmpty() {
        return first == -1 && last == -1;
    }

    /**
     * Obtiene la representación de la Cola como una cadena de carácteres
     * @return String que representa el contenido de la cola como texto
     */
    @Override
    public String toString() {
        return "Cola{" +
                "data=" + Arrays.toString(data) +
                ", first=" + first +
                ", last=" + last +
                '}';
    }
}
