package Util;

import java.util.Scanner;
import java.util.Random;

public class Lib {

    public static Scanner myInput = new Scanner(System.in);
    public static boolean correct;

    public static void pausa() {
        System.out.println("Pulsa intro para continuar ....");
        myInput.nextLine();
    }

    public static int random(int min, int max) {
        Random r = new Random();
        return r.nextInt(max - min + 1) + min;
    }

    public static double randomDouble(int min, int max) {
        Random r = new Random();
        return r.nextInt(max - min + 1) + min;
    }

    public static void clearScreen() {
        System.out.println("\u000C");
    }

    // *VALIDAR USER INPUT
    /**
     * 
     * @param userInt
     * @return el dato valido en Int
     */

    public static int validarInt(String message) {
        int userInt = 0;
        do {
            System.out.print(message);
            try {
                userInt = Integer.parseInt(Lib.myInput.nextLine());
                correct = true;
                Lib.pausa();
            } catch (NumberFormatException e) {
                System.out.println("Error: El input no es un integer");
                Lib.pausa();
                correct = false;
            }

        } while (!correct);
        return userInt;
    }

    /**
     * 
     * @param message
     * @param max
     * @param min
     * @return
     */

    public static int validarInt(String message, int min, int max) {
        int userInt = 0;
        do {
            try {
                System.out.print(message);
                userInt = Integer.parseInt(Lib.myInput.nextLine());
                correct = userInt >= min && userInt <= max;
                if (!correct) {
                    System.out.println("El numero debe estar entre" + min + " y " + max);
                }
            } catch (NumberFormatException e) {
                System.out.println("Error");
                Lib.pausa();
            }

        } while (!correct);
        return userInt;
    }

    /**
     * 
     * @param userDb
     * @return DOUBLE
     */
    public static double validarDouble(String message) {
        double userInt = 0;
        do {
            try {
                System.out.print(message);
                userInt = Double.parseDouble(Lib.myInput.nextLine());
                correct = true;
            } catch (NumberFormatException e) {
                System.out.println("Error");
                Lib.pausa();
                correct = false;
            }

        } while (!correct);
        return userInt;
    }

    public String validarString1(String userStr) {
        userStr = null;
        String compare = "";
        do {
            correct = userStr.equals(compare);
            System.out.print("Introduce un String ");
            try {
                userStr = Lib.myInput.nextLine();

            } catch (NumberFormatException e) {
                System.out.println("Error: El input no es un String");
                correct = false;
            }

        } while (!correct);
        return userStr;
    }

    /**
     * 
     * @param message
     * @param minLenght
     * @param maxLenght
     * @return
     */

    public static String validarStr0(String message, int minLenght, int maxLenght) {
        String userStr;
        // No se inicializa porque este
        // si data hubiera sido un atributo hubiese sido inicializado como null
        do {
            System.out.print(message);
            userStr = Lib.myInput.nextLine();
            correct = userStr.length() >= minLenght && userStr.length() <= maxLenght;
            if (!correct) {
                System.out.printf("Longitud minima %d, maxima %d \n", minLenght, maxLenght);
                Lib.pausa();
            }

        } while (!correct);
        return userStr;
    }

    /**
     * 
     * @return
     */

    public static int[] validarArray() {
        System.out.println("***VALIDACION DE UN ARRAY DE ENTEROS***");
        System.out.println("Introduce la longitud  del array");
        int userInt;
        int array[] = new int[myInput.nextInt()];

        try {
            String message = ("Introduce un numero para el array ");
            for (int i = 0; i < array.length; i++) {
                userInt = Lib.validarInt(message);
                array[i] = (userInt + (i + 1));
            }

            // estos errores no tendrian que estar controlados porque son evitables

        } catch (Exception e) {
            System.out.println("El dato tiene que ser de tipo integer");
        }
        return array;
    }

}
