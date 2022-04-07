package Tema11.Propios;

public class Ejercicio1 {

    public Ejercicio1() {

        Punto a = new Punto();
        Punto b = new Punto(15.24, 34.30);
        System.out.println(a.distance(b));
        System.out.println(b.distance(a));
        System.out.println(a.toString(a));
        System.out.println(a.toString(b));

    }

}
