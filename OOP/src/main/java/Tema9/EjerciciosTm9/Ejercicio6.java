package Tema9.EjerciciosTm9;

import Util.Lib;

public class Ejercicio6 {
    // public static boolean correct;

    public static void Ejercicio6() {
        System.out.println("Vamo a dividir");
        dividirEntreArray(Lib.validarArray(), -1);

    }

    public static void dividirEntreArray(int[] array, int divisor) {
        boolean correct = divisor > 0;
        do {
            try {
                if (!correct) {
                    System.out.println("El divisor no puede ser menor que 0");
                    System.out.println("Introduce un nuevo divisor");
                    int userInt = Integer.parseInt(Lib.myInput.nextLine());
                    divisor = userInt;
                }

                for (int i = 0; i < array.length; i++) {
                    array[i] /= divisor;
                    System.out.println(array[i]);
                }
            } catch (Exception e) {
                System.out.println("Error");
            }
        } while (!correct);

    }

}