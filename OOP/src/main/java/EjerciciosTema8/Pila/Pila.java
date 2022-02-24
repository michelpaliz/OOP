package EjerciciosTema8.Pila;

public class Pila {

    // la pila tiene que ser private para que se maneja autamicamente como abstracto
    private final int[] datos;
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
        // como se yo que la pila esta llena
        if (!isFull()) {
            datos[tope + 1] = elemento;
            return true;
        }
        return false;
    }

    // +Todo EJERCICIO

}
