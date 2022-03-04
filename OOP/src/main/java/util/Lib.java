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

    public static int random(int min, int max) {
        Random r = new Random();
        return r.nextInt(max - min + 1) + min;
    }

    public static void clearScreen() {
        System.out.println("\u000C");
    }

    // public static byte[] readFile(String filePath) throws IOException,
    // InputMismatchException {
    // int fileSize = getFileSize();
    // byte[] data = new byte[fileSize];
    // try {
    // // Abrir archivo
    // // leerlo

    // } catch (Exception e) {
    // // TODO: CERRAR ARCHIVO
    // throw new IOException(ioe.getMessage()); // la he capturado pero quiero que
    // continue elevandose,
    // } finally {
    // // Cerrar archivo
    // }

    // return data;

    // }

    // public static <T> T readInt(Class<T> dataType){
    // return dataType;
    // }

    //*VALIDAR USER INPUT
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
