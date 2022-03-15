package Tema8.EjemplosTema8.ejercicio05;

import Tema8.EjemplosTema8.ejercicio04.Punto;

public class Circulo {
    private Punto centro;
    private double radio;

    public Circulo(Punto centro, double radio) {
        // Dependiendo del comportamiento que se desee:
        // Si queremos que al cambiar el punto recibido cambie el centro del círculo:
        this.centro = centro;
        // Si queremos que el centro del círculo sea independiente del punto recibido:
        // this.centro = new Punto(centro);
        this.radio = radio;
    }

    public Circulo(double x, double y, double radio) {
        this.centro = new Punto(x, y);
        this.radio = radio;
    }

    public Punto getCentro() {
        return centro;
    }

    public void setCentro(Punto centro) {
        this.centro = centro;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public double calcularDistancia(Circulo c) {
        return centro.calcularDistancia(c.getCentro());
    }

    @Override
    public String toString() {
        return "Circulo{" +
                "centro=" + centro +
                ", radio=" + radio +
                '}';
    }
}
