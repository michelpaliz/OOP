package Tema9.EjerciciosTm9;

import Util.Lib;

public class Ejercicio6 {
    // public static boolean correct;

    public static void Ejercicio6() {
        System.out.println("Vamo a dividir");
        dividirEntreArray(Lib.validarArray(), -1);

    }

    public static void dividirEntreArray(int[] array, int divisor) {
        for (int i = 0; i < array.length; i++) {
            try {
                if(array[i]!=0){
                    array[i] /= (double) divisor;
                    System.out.println(array[i]);
                }

            } catch (ArithmeticException ae) {
                System.out.println(ae.getMessage());
                System.out.println(ae.toString());
                ae.printStackTrace();
                if (array[i] == 0) {
                    System.out.println("Division por cero");
                } else {
                    System.out.println("Exepcion aritmetica");
                }
            }
        }
    }

}