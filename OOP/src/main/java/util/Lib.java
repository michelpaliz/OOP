package util;

import java.util.Scanner;
import java.util.Random;

public class Lib {

    public static Scanner myInput = new Scanner(System.in);

    public static void pausa() {
        System.out.println("Pulsa intro para continuar");
        myInput.nextLine();
    }

    public static int random(int min, int max) {
        Random r = new Random();
        return r.nextInt(max - min + 1) + min;
    }

}
