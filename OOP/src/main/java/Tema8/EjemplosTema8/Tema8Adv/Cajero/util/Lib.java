package Tema8.EjemplosTema8.Tema8Adv.Cajero.util;

import java.util.Scanner;

public class Lib {
    public static Scanner scanner = new Scanner(System.in);

    public static void pausa() {
        System.out.println("Pulsa INTRO para continuar");
        scanner.nextLine();
    }
}
