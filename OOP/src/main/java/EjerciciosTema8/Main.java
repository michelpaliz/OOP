package EjerciciosTema8;

//importacion de las clases

import EjerciciosTema8.Ejercicio2.Ejercicio02;
import EjerciciosTema8.Ejercicio3.Ejercicio03;
import EjerciciosTema8.Ejercicio4.Ejercicio04;
import EjerciciosTema8.Ejercicio5.Ejercicio05;
import EjerciciosTema8.Ejercicio6.Ejercicio06;
import EjerciciosTema8.Ejercicio7.Ejercicio07;
import EjerciciosTema8.Pila.Pila;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // System.out.println("EJERCICIO NUMERO 2");
        // Ejercicio02 ejercicio02 = new Ejercicio02();
        // System.out.println("EJERCICIO NUMERO 4");
        // Ejercicio04 ejercicio04 = new Ejercicio04();
        // // Ejercicio03 ejercicio03 = new Ejercicio03()
        // System.out.println("EJERCICIO NUMERO5");
        // Ejercicio05 ejercicio05 = new Ejercicio05();
        // System.out.println("EJERCICIO NUMERO 6");
        // // Ejercicio06 tienda = new Ejercicio06();
        // System.out.println("EJERCICIO NUMERO 7");
        // Ejercicio07 registro = new Ejercicio07();
        System.out.println("PILA");
        Random r = new Random(5);

        Pila p = new Pila(10);
        System.out.println(p);
        for (int i = 0; i < 5; i++) {
            p.push(r.nextInt(10));
            System.out.println(p);
        }
        // devolver datos de la pila
        for (int i = 0; i < 5; i++) {
            System.out.println(p.pop());

        }
    }

}
