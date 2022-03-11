package Tema9.EjerciciosTm9;

import java.util.Scanner;

import Util.Lib;

public class Ejercicio4 {
    public static Scanner myInput = new Scanner(System.in);

    public void validarArrayCorregido() {
        System.out.println("Validacion de un array de enteros");
        System.out.println("Introduce la longitud  del array");
        int array[] = new int[myInput.nextInt()];
        String message = ("Introduce un numero para el array");

        try {
            int cont = 0;
            while (true) {
                array[cont] = Lib.validarInt(message + (cont + 1));
                cont++;
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Has sobre pasado el limite del array");
        } catch (NullPointerException npe) {
            System.out.println("No has inicializado ela array");
        }

    }

    public static  void validarArray() {
        System.out.println("Validacion de un array de enteros");
        System.out.println("Introduce la longitud  del array");

        int array[] = new int[myInput.nextInt()];

        try {
            String message = ("Introduce un numero para el array");
            for (int i = 0; i < array.length; i++) {
                array[i] = Lib.validarInt(message + (i + 1));
            }

            // estos errores no tendrian que estar controlados porque son evitables
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Has sobre pasado el limite del array");
        } catch (NullPointerException npe) {
            System.out.println("No has inicializado el array");
        }

    }

    public static void Ejercicio4() {
        validarArray();
    }

}
