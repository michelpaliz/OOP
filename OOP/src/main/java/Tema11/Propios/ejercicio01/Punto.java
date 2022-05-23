package Tema11.Propios.ejercicio01;

public class Punto {

    private double y;
    private double x;

    public Punto() {
        this.x = 35.50;
        this.y = 50.30;
    }

    public Punto(double x, double y) {
        this.y = y;
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double distance(Punto a) {
        return Math.sqrt(Math.pow((this.x - a.getX()), 2) + Math.pow((this.y - a.getY()), 2));
    }

    public String toString(Punto a) {
        return "(" + a.getX() + "," + a.getY() + ")";
    }

}
