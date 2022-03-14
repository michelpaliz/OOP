package Tema9.EjerciciosTm9;

import Util.Lib;

public class Ejercicio8 {

    public static void Ejercicio8() {
        int a = 0;
        int b = 20;
        arithmeticException(b, a);
        // vamos anyadir una persona, la edad esta comprendida en estos parametros
        // como tratamos si no cumple la condicion
        // El metodo que esta solicitando este exepction tendra un throws al lado
        int userInt = Integer.parseInt(Lib.myInput.nextLine());
        int edad = userInt;
        if (edad < 0 && edad > 130) {
            throw new RangeNumberException("El reagno debe de estar entre");
        }

    }

    public static void arithmeticException(int dividendo, int divisor) {

        System.out.println("Vamos a tratar este tipo de exepcion");
        int resultado = 0;

        try {
            resultado = dividendo / divisor;

        } catch (ArithmeticException e) {
            e.printStackTrace();
            System.out.println("Error");
        }
        System.out.println("El resultado es " + resultado);

    }

    public static void nullPointerExecption() {

    }

    /**
     * el extends sign es hija de rangenumberexpection
     * keyword super lo que hace es llamar al constructor expecion que lo llama
     */
    public class RangeNumberException extends Exeption {
        public RangeNumberException(String message) {
            super(message);

        }
    }

}
