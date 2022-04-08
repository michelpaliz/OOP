package Tema09.EjerciciosTm9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Util.*;

public class Ejercicio2 {

    public static List<String> list = new ArrayList<String>();
    public static List<Integer> listInt = new ArrayList<Integer>();

    public static void readOnlyDecimalNum(int numVeces) {
        int cont = 0;
        // int[] numero = new int[numVeces];

        do {
            System.out.println("Inserta un numero");
            Config.userStr = Lib.myInput.next();
            list.add(Config.userStr);

            try {
                cont++;
                Config.userInt = Integer.parseInt(Config.userStr);
                System.out.println("Es un integer ");

            } catch (Exception e) {
                System.out.println("No es un integer");
                Lib.pausa();

            }

        } while (cont < numVeces);

        for (String s : list) {
            listInt.add(Integer.valueOf(s));
        }
        System.out.println("Despues del for each loop");
        System.out.println(list);
        int max = Collections.max(listInt);
        System.out.println("ArrayList max value : " + max);

    }

    public static void Ejercicio2() {
        readOnlyDecimalNum(10);

    }

}
