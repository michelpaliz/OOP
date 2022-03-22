package Tema10.Ejercicios.ejercicio01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Ejercicio01 {
    private final static int MAX_SIZE = 10;

    // Constructor
    public Ejercicio01() {
        int[] numbers = new int[MAX_SIZE];
        // llenamos el arryay
        fillArrayRandom(numbers, 1, 50);
        // Convertimos el array to arrylist
        ArrayList<Integer> arrayList = arrayToArrayList(numbers);
        // Imprimimos por pantalla los resultados
        System.out.println(Arrays.toString(numbers));
        System.out.println(arrayList);
    }

    // Llenamos el array
    public void fillArrayRandom(int[] array, int min, int max) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(max - min + 1) + min;
        }
    }

    /**
     * 
     * @param array
     * @return arrayList
     */

    public ArrayList<Integer> arrayToArrayList(int[] array) {
        ArrayList<Integer> arrayList = new ArrayList<>(array.length);
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0)
                arrayList.add(array[i]);
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0)
                arrayList.add(array[i]);
        }
        return arrayList;
    }

}
