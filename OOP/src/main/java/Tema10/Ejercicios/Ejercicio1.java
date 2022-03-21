package Tema10.Ejercicios;

import java.util.ArrayList;
import java.util.Arrays;

import Util.Lib;

public class Ejercicio1 {
    public final static int MAX_VALUE = 10;

    public Ejercicio1() {
        int[] number = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        Lib.fillArrayRandom(, min, max);

        System.out.println(Arrays.toString(number));
        //
        ArrayList<Integer> arrayList = arrayToArrayList(number);
        System.out.println(arrayList);
    }

    public ArrayList<Integer> arrayToArrayList(int[] array) {
        // por defecto el tamayo es 10
        ArrayList<Integer> arrayList = new ArrayList<>(array.length);

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                arrayList.add(array[i]);
            } else {
                // Esta estragia no funcionaria porque el array no esta lleno
                arrayList.add();
            }

        }
        return arrayList;
    }

}
