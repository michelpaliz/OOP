package Tema8.EjemplosTema8.ejercicio05;

import Tema8.EjemplosTema8.ejercicio04.Punto;

public class Ejercicio05 {    
    public Ejercicio05() {
        Punto p1 = new Punto(4, 5);
        Punto p2 = new Punto(3, 7);
        Circulo c1 = new Circulo(p1, 10);
        Circulo c2 = new Circulo(3, 5, 10);
        p1.setX(5);
        p2.setX(4);

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(c1);
        System.out.println(c2);
    }
}
