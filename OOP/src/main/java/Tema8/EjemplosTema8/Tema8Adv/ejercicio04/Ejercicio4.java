package Tema8.EjemplosTema8.Tema8Adv.ejercicio04;

public class Ejercicio4 {

    public Ejercicio4() {
        Punto p1 = new Punto(8,4);
        Punto p2 = new Punto();
        Punto p3 = new Punto(3, 5);
        Punto p4 = new Punto(4.5,3.5);

        p1.visualizarPunto();
        p2.visualizarPunto();
        p3.visualizarPunto();
        p4.visualizarPunto();

        System.out.println("La distancia entre p1 = " + p1.toString() + " y p3 = " + p3.toString() + " es " + p1.calcularDistancia(p3));
    }
}
