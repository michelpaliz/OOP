package Tema8.EjemplosTema8.ejercicio04;

import java.util.Random;

public class Ejercicio04 {
    private final static int NUM_PUNTOS = 5;
    private final static int MAX_COORDENADA = 10;
    public Ejercicio04() {
        Random random = new Random();
        Punto[] puntos = new Punto[NUM_PUNTOS];
        // Creamos los puntos
        for(int i = 0; i < puntos.length; i++) {
            puntos[i] = new Punto(random.nextDouble() * MAX_COORDENADA, random.nextDouble() * MAX_COORDENADA);
        }
        // Visualizamos distancias
        for(int i = 0; i < puntos.length; i++) {
            int nextIndex = (i + 1) % puntos.length;
            System.out.println(puntos[i]);
            System.out.println(puntos[nextIndex]);
            System.out.printf("Distancia: %.2f\n",puntos[i].calcularDistancia(puntos[nextIndex]));
        }

    }
}
