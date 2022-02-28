package EjerciciosTema8.Pila;

public class Cola {
    // Creacion de atributos
    // los que llevan mas tiempo salen primero
    private final static int GROWFACTOR = 2; // atributo de clase compartido por los objetos
    private final static int DEFAULT_SIZE = 10;
    private int[] data;
    private int firstData;
    private int lastData;

    public Cola(int initialSize) {
        this.data = new int[initialSize];
        this.firstData = -1; // le asignamos valores absurdos para que sepamos que este mal
        this.lastData = -1;
    }

    public boolean isEmpty() {
        return firstData == -1 && lastData == -1;
    }

    public Cola() {
        this(DEFAULT_SIZE);
    }

    public boolean isFull() {
        return lastData == data.length - 1;
    }

    // redimensionar el array
    public int[] resize() {
        int[] newArray = new int[data.length * GROWFACTOR];
        int count = 0;
        for (int i = firstData; i <= lastData; i++) {
            newArray[count] = data[i];
            count++;
        }
        this.firstData = 0;
        this.lastData = count;
        return newArray;
    }

    // vamos a implementar de izquierda a derecha
    public void add(int elem) {
        if (isEmpty()) {// este vacio
            firstData = 0;
        } else if (isFull()) {
            data = resize();// o este lleno
        }
        data[++lastData] = elem; // data apuntara a este elemento
    }

}
