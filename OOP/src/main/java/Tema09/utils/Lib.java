package Tema09.utils;

import java.util.Random;
import java.util.Scanner;

public class Lib {
    public static final Scanner scanner = new Scanner(System.in);
    public static final Random r = new Random();

    public static int readInt2(String message) throws NumberFormatException {
        boolean isValid = false;
        int data = 0;
        do {
            System.out.println(message);
            data = Integer.parseInt(scanner.nextLine());
            isValid = true;
        } while(!isValid);
        return data;
    }

    public static int readInt(String message) {
        boolean isValid = false;
        int data = 0;
        do {
            try {
                System.out.println(message);
                data = Integer.parseInt(scanner.nextLine());
                isValid = true;
            } catch (NumberFormatException nfe) {
                System.out.println("Solo números por favor");
                pause();
            }
        } while(!isValid);
        return data;
    }

    public static String readString(String message, int minLength, int maxLength) {
        boolean isValid = false;
        String data;
        do {
            System.out.println(message);
            data = scanner.nextLine();
            isValid = (data.length() >= minLength && data.length() <= maxLength);
            if(!isValid){
                System.out.printf("Longitud mínima %d, máxima %d\n", minLength, maxLength);
                pause();
            }
        } while(!isValid);
        return data;
    }

    public static int random(int min, int max) {
        return r.nextInt(max - min + 1) + min;
    }

    public static void pause() {
        System.out.println("Pulse INTRO para continuar ...");
        scanner.nextLine();
    }
}
