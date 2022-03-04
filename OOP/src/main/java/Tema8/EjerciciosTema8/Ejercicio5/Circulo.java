package Tema8.EjerciciosTema8.Ejercicio5;

import Tema8.EjerciciosTema8.Ejercicio4.Punto;

public class Circulo {
    // Creacion de atributos
    private double radio;
    private Punto centro;

    // Creacion de constructores
    public Circulo(double radio, Punto punto) {
        this.radio = radio;
        // this.centro = new Punto(punto.getX(), punto.getY()); // aqui recoge los
        // valores de los parametros;
        this.centro = new Punto(punto); // aqhi hemos crado un metodo llamada punto que funciona como una copia
    }

    // donde va estar ubicsdo el circulo
    public Circulo(double y, double x, double radio) {
        this.centro = new Punto(x, y);
        this.radio = radio;

    }

    public double caluclarDistancia(Circulo c) {
        return centro.calcularDistancia(c.getCentro());

    }

    // Creacion de metodos Dinamicos
    /***
     * Metodo para calcular el perimetro
     */
    public double calcularPerimetro() {
        double perimetro;
        perimetro = 2 * Math.PI * radio;
        return perimetro;

    }

    /**
     * Metodo para calcular el Area
     * 
     * @return
     */

    public double calcularArea() {
        double area;
        area = (calcularPerimetro() * radio) / 2;
        return area;
    }

    @Override
    public String toString() {
        return "Circulo [centro=" + centro + ", radio=" + radio + "]";
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public Punto getCentro() {
        return centro;
    }

    public void setCentro(Punto centro) {
        this.centro = centro;
    }

}
