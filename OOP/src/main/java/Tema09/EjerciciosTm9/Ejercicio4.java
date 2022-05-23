package Tema09.EjerciciosTm9;

import java.util.Scanner;

import Lib.Util;

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
                int userInt = 0;
                do {
                    System.out.print(message + (cont + 1));
                    try {
                        userInt = Integer.parseInt(Util.myInput.nextLine());
                        Util.correct = true;
                        Util.pause();
                    } catch (NumberFormatException e) {
                        System.out.println("Error: El input no es un integer");
                        Util.pause();
                        Util.correct = false;
                    }

                } while (!Util.correct);
                array[cont] = userInt;
                cont++;
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Has sobre pasado el limite del array");
        } catch (NullPointerException npe) {
            System.out.println("No has inicializado ela array");
        }

    }

    public static void validarArray() {
        System.out.println("Validacion de un array de enteros");
        System.out.println("Introduce la longitud  del array");

        int array[] = new int[myInput.nextInt()];

        try {
            String message = ("Introduce un numero para el array");
            for (int i = 0; i < array.length; i++) {
                int userInt = 0;
                do {
                    System.out.print(message + (i + 1));
                    try {
                        userInt = Integer.parseInt(Util.myInput.nextLine());
                        Util.correct = true;
                        Util.pause();
                    } catch (NumberFormatException e) {
                        System.out.println("Error: El input no es un integer");
                        Util.pause();
                        Util.correct = false;
                    }

                } while (!Util.correct);
                array[i] = userInt;
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
