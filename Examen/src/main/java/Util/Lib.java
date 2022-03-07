package Util;

import java.util.Scanner;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Random;

public class Lib {

    public static Scanner myInput = new Scanner(System.in);
    public static boolean correct;

    public static void pausa() {
        System.out.println("Pulsa intro para continuar ....");
        myInput.nextLine();
    }

    public static Scanner lector = new Scanner(System.in);

    public static void limpiarPantalla() {
        System.out.print("\u001B[H\u001B[2J");
        System.out.flush();
    }

    public static int aleatorio() {
        Random r = new Random();
        return r.nextInt();
    }

    public static int aleatorio(int min, int max) {
        Random r = new Random();
        return r.nextInt(max - min + 1) + min;
    }

    public static double aleatorio(double min, double max) {
        Random r = new Random();
        return min + r.nextDouble() * (max - min);
    }

    public static float aleatorio(float min, float max) {
        Random r = new Random();
        return min + r.nextFloat() * (max - min);
    }

    public static int random(int min, int max) {
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
            try {
                System.out.print(message);
                userInt = Integer.parseInt(Lib.myInput.nextLine());
                correct = true;
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
     * @param userDb
     * @return DOUBLE
     */

    public double validarDouble(double userDb) {
        userDb = 0;
        do {
            System.out.print("Introduce un numero decimal ");
            try {
                userDb = Double.parseDouble(Lib.myInput.nextLine());
                correct = true;

            } catch (NumberFormatException e) {
                System.out.println("Error: El input no es un integer");
                correct = false;
            }

        } while (!correct);

        return userDb;

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

}
