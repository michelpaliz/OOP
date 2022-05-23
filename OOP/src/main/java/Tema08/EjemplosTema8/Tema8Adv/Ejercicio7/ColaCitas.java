package Tema08.EjemplosTema8.Tema8Adv.Ejercicio7;

/**
 * Class ColaCitas
 * Implementación estática de una cola mediante un Array
 */
public class ColaCitas {
    /* Capacidad por defecto de la cola */
    private static final int INITIAL_SIZE = 10;
    /* Array donde se almacenan los elementos de la cola */
    private Cita[] citas;
    /* Índice que controla cual es el primer elemento de la cola */
    private int primero;
    /* Índice que controla cuál es el último elemento de la cola */
    private int ultimo;

    public ColaCitas() {
        this(INITIAL_SIZE);
    }

    public ColaCitas(int size) {
        citas = new Cita[size];
        primero = -1;
        ultimo = -1;
    }

    /**
     * Determina si la cola está llena
     * @return True si la cola está llena, False en caso contrario
     */
    public boolean isFull() {
        return ultimo == citas.length-1;
    }

    /**
     * Determina si la cola está vacía
     * @return True si la cola está vacía, False en caso contrario
     */
    public boolean isEmpty() {
        return primero == ultimo;
    }

    /**
     * Añade una cita al final de la Cola
     * @param e Cita a añadir
     */
    public void add(Cita e) {
        if(isEmpty()) {
            primero = 0;
        } else if(isFull()) {
            //Ampliamos el tamaño
            expand(2);
        }
        ultimo++;
        citas[ultimo] = e;
    }

    /**
     * Amplía el tamaño de la cola en un factor de multiplicación
     * y copia todas las citas al principio del nuevo array
     * actualizando los índices primero y último
     * @param factor Factor de multiplicación
     */
    private void expand(int factor) {
        Cita[] aux = new Cita[citas.length * factor];
        int j = 0;
        for(int i = primero; i < size(); i++) {
            aux[j] = citas[i];
            j++;
        }
        primero = 0;
        ultimo = j-1;
        citas = aux;
    }

    /**
     * Extrae la siguiente Cita (la primera)
     * @return Cita que ocupa la primera posición
     */
    public Cita remove() {
        Cita e = null;
        if(!isEmpty()) {
            e = citas[primero];
            for(int i = primero; i < ultimo; i++) {
                citas[i] = citas[i+1];
            }
            ultimo--;
        }
        return e;
    }

    /**
     * Representación del contenido de la Cola mediante un String
     * @return String con la representación de la Cola
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for(int i = 0; i <= ultimo; i++) {
            sb.append(citas[i]).append(" ");
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * Obtiene el tamaño de la cola
     * @return
     */
    public int size() {
        return ultimo - primero + 1;
    }

    /**
     * Consulta (sin eliminarla) la primera Cita de la cola
     * @return Primera Cita de la cola
     */
    public Cita peek() {
        return citas[primero];
    }

    /**
     * Muestra por pantalla los elementos de la Cola
     */
    public void print() {
        System.out.println(toString());
    }

    /**
     * Método útil para ver como van evolucionando los índices
     */
    public void showDebug() {
        System.out.println("primero = " + primero);
        System.out.println("ultimo = " + ultimo);
        print();
    }

    public Cita[] getCitas() {
        return citas;
    }
}
