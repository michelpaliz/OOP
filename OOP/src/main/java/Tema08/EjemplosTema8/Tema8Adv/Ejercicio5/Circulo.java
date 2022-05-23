package Tema08.EjemplosTema8.Tema8Adv.Ejercicio5;

import Tema08.EjemplosTema8.Tema8Adv.ejercicio4.Punto;

// import com.germangascon.tema08.ejercicio04.Punto;

public class Circulo {
    private Punto centro;
    private double radio;

    public Circulo(Punto centro, double radio) {
        this.centro = centro;
        this.radio = radio;
    }

    public Circulo(double x, double y, double radio) {
        centro = new Punto(x,y);
        this.radio = radio;
    }

    public Circulo() {
        centro = new Punto(0,0);
        radio = 1;
    }

    public Punto getCentro() {
        return centro;
    }

    public void setCentro(Punto centro) {
        // Copia o asignación
        // IMPORTANTE: tener claro las diferencias
        this.centro = new Punto(centro);
        // this.centro = centro;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public double calcularDistancia(Punto p) {
        return centro.calcularDistancia(p);
    }

    public double calcularDistancia(Circulo c) {
        return centro.calcularDistancia(c.centro);
    }

    public double calcularArea() {
        return Math.PI * Math.pow(radio,2);
    }

    public double calcularPerimetro() {
        return 2 * Math.PI * radio;
    }

    public void visualizarCirculo() {
        System.out.print("Círculo de radio " + radio + " cm situado en ");
        if(centro.getX() == 0 && centro.getY() == 0) {
            System.out.println("el origen de coordenadas");
        } else {
            System.out.println("el punto " + centro.toString());
        }
    }

    @Override
    public String toString() {
        return "centro: (" + centro.getX() + ", " + centro.getY() + "), radio: " + radio;
    }
}
