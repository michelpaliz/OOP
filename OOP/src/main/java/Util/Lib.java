package Util;

import java.util.Scanner;
import java.util.UUID;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Lib {

    public static Scanner myInput = new Scanner(System.in);
    public static Random r = new Random();
    private static boolean correct;

    public static void pausa() {
        System.out.println("Pulsa intro para continuar ....");
        myInput.nextLine();
    }

    public static int randBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
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

    public static void cleanScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /**
     * 
     * @param message
     * @param max
     * @param min
     * @return
     */

    public static int validateInt(String message, int min, int max) {
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
    public static double validateDouble(String message) {
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

    public String validateString1(String userStr) {
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

    public static String validateString2(String message, int minLenght, int maxLenght) {
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

    public static int[] validateArray() {
        System.out.println("***VALIDACION DE UN ARRAY DE ENTEROS***");
        System.out.println("Introduce la longitud  del array");
        int userInt;
        int array[] = new int[myInput.nextInt()];

        try {
            String message = ("Introduce un numero para el array ");
            for (int i = 0; i < array.length; i++) {
                int userInt1 = 0;
                do {
                    System.out.print(message);
                    try {
                        userInt1 = Integer.parseInt(Lib.myInput.nextLine());
                        Lib.correct = true;
                        Lib.pausa();
                    } catch (NumberFormatException e) {
                        System.out.println("Error: El input no es un integer");
                        Lib.pausa();
                        Lib.correct = false;
                    }

                } while (!Lib.correct);
                userInt = userInt1;
                array[i] = (userInt + (i + 1));
            }

            // estos errores no tendrian que estar controlados porque son evitables

        } catch (Exception e) {
            System.out.println("El dato tiene que ser de tipo integer");
        }
        return array;
    }

    // min y max numeros aleatorios a generar
    public static void fillArrayRandom(int[] array, int min, int max) {

        for (int i = 0; i < array.length; i++) {
            array[i] = r.nextInt(max - min + 1) + min;

        }

    }

    /**
     * 
     * @param date
     * @return date formated with hour minute and seconds
     */
    public String dateFrmTime(LocalDate date) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        return dtf.format(date);
    }

    /**
     * 
     * @param date
     * @return date formatted only with year
     */
    public static String dateFrmYear(LocalDate date) {
        DateTimeFormatter dt = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        return dt.format(date);
    }

    /**
     * 
     * @return a class that represents an immutable universally unique identifier
     *         (UUID). A UUID represents a 128-bit value.
     */

    public static String generateString() {
        String uuid = UUID.randomUUID().toString();
        return uuid;
    }

}
