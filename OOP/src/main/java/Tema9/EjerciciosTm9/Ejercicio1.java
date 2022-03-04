package Tema9.EjerciciosTm9;
import Util.*;

public class Ejercicio1 {

    public static int onlyPositiveNumbers(String message) {
        int userInt = 0;
        do {
            System.out.println("Introduce un numero");
            try {
                System.out.print(message);
                userInt = Integer.parseInt(Lib.myInput.nextLine());
                Config.correct = userInt > 0;
                if (!Config.correct) {
                    System.out.println("Error solo se puede numeros positivos");
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: El input no es un integer");
                Lib.pausa();
                Lib.correct = false;
            }

        } while (!Lib.correct);
        return userInt;
    }

    public static void Ejercicio1() {

        System.out.println(onlyPositiveNumbers("Introduce solo numeros positivos"));

    }

}
