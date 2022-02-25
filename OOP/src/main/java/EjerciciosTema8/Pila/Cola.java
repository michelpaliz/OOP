package EjerciciosTema8.Pila;

public class Cola {
    // Creacion de atributos
    private final static int GROWFACTOR = 2;
    private int[] datos;
    private int firstData;
    private int lastData;

    public Cola(int initialSize) {
        this.datos = new int[initialSize];
        this.firstData = -1;
        this.lastData = -1;
    }

    public boolean isEmpty() {
        return firstData == -1;
        // return tope < 0;
    }

    public boolean isFull() {
        return lastData == datos.length - 1;
    }

    // public int[] add(int numElmentos){
    // return
    // }

}
