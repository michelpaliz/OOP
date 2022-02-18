package EjerciciosTema8.Ejercicio4;

public class Ejercicio04 {
    public Ejercicio04() {

        Punto punto1 = new Punto(4, 2);
        Punto punto2 = new Punto(1, 5);
        Punto punto3 = new Punto(-2, 3);
        Punto punto4 = new Punto(3, -3);
        System.out.println(punto1);
        System.out.println(punto2);
        System.out.println(punto1.calcularDistancia(punto2));
        System.out.println(punto3.calcularDistancia(punto4));
        // System.out.println(visualizarPunto());

    }

}
