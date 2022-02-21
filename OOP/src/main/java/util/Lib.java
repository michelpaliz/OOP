package util;

import java.util.Scanner;

public class Lib {

    public static Scanner myInput = new Scanner(System.in);

    public static void pausa() {
        System.out.println("Pulsa intro para continuar");
        myInput.nextLine();
    }
}
