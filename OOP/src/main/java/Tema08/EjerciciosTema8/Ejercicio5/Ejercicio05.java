package Tema08.EjerciciosTema8.Ejercicio5;

import Tema08.EjerciciosTema8.Ejercicio4.Punto;

public class Ejercicio05 {

    public Ejercicio05() {
        // Calcular el perimetro de un circulo
        Punto punto1 = new Punto(4, 5);
        Punto punto2 = new Punto(3, 7);
        Circulo c1 = new Circulo(10, punto1);
        Circulo c2 = new Circulo(3, 5, 10);
        // para testear
        punto1.setX(5);
        punto2.setX(4);

        System.out.println(punto1);
        System.out.println(punto2);
        System.out.println(c1);
        System.out.println(c2);

    }

}
