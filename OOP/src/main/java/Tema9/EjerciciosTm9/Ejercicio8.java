package Tema9.EjerciciosTm9;

import org.yaml.snakeyaml.error.MarkedYAMLException;

import Util.Lib;

public class Ejercicio8 {

    public static void Ejercicio8() {
        int a = 0;
        int b = 20;
        System.out.println("*******VAMOS A TRATAR EXEPCIONES******");
        // * literal a
        arithmeticException(b, a);
        // * literal b
        String phrase = "hola";
        nullPointerExeption(phrase);
        // if (phrase != null)
        // System.out.println("First character: " + x.charAt(0));
        // else
        // System.out.println("NullPointerException thrown!");
        // *literal c
        int[] myArray = { 897, 56, 78, 90, 12, 123, 75 };
        indexOutBoundsExeption(myArray);


    }

    public static void arithmeticException(int dividendo, int divisor) {
        int resultado = 0;

        try {
            resultado = dividendo / divisor;

        } catch (ArithmeticException e) {
            e.printStackTrace();
            System.out.println("Error");
        }
        System.out.println("El resultado es " + resultado);

    }

    public static void nullPointerExeption(String x) {

        try {
            System.out.println("First character: " + x.charAt(6));
        } catch (NullPointerException e) {
            System.out.println("NullPointerExeption throw!");
        }

    }


    public static void indexOutBoundsExeption(int[] array) {
        try {
            System.out.println("Introduce el indice del elemento que quieras ver en el array");
            int element = Integer.parseInt(Lib.myInput.nextLine());
            System.out.println("El elemento dado esta en la posicion " + array[element]);
        } catch (Exception e) {
            System.out.println("The index you have entered is invalid");
            System.out.println("Please enter an index number between 0 and 6");
        }
    }

  
}
