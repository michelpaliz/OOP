package Tema10.Ejercicios.Particulares;

import java.util.Scanner;

public class Ejercicio8 {

    static int userInt;
    static int opcion;
    static String key, value, userString;
    static boolean correct;
    static Gestion word;
    static Scanner sc;

    public static void main(String[] args) {
        word = new Gestion();
        sc = new Scanner(System.in);
        ejecutar();
    }

    public static void menu() {
        System.out.println("MENU");
        System.out.println("1.Anyadir  palabra en el diccionario");
        System.out.println("2.Modificar palabra ");
        System.out.println("3.Eliminar palabra");
        System.out.println("4.Consultar palabra");
        System.out.println("5.Mostrar el diccionario");
        System.out.println("6.Salir");
    }

    public static void ejecutar() {
        String err = "";
        while (userInt != 6) {

            // #### PEDIMOS AL USUARIO SELECCI´NO DE ACCIÓN
            do {
                System.out.print(err);
                menu();
                userInt = Integer.parseInt(sc.nextLine());
                correct = userInt <= 6 && userInt > 0;
                err = "Introduzca un valor valido.\n";
            } while (!correct);
            // #### PEDIMOS AL USUARIO SELECCIon DE ACCIÓN

            switch (userInt) {
                case 1:

                    System.out.println("Introduce the keyword:");
                    key = sc.nextLine();
                    System.out.println("Now introduce the meaning for the keyword:");
                    value = sc.nextLine();
                    word.addElement(key, value);

                    break;

                case 2:
                    System.out.println("Introduce the keyword");
                    key = sc.nextLine();
                    System.out.println("And now introduce the value that you want to replace");
                    value = userString = sc.nextLine();
                    word.replace(key, value);
                    break;

                case 3:
                    System.out.println("Introduce the key that you want to delete");
                    key = userString = sc.nextLine();
                    word.remove(key);

                    break;
                case 4:
                    System.out.println("Introduce the key that you want to delete");
                    key = userString = sc.nextLine();
                    word.show(key);
                    menu();
                    break;
                case 5:
                    word.showdic();
                    break;
            }

            menu();
        } // while inicial

    }

}
