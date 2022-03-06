package Tema8.EjemplosTema8.ejercicio04;

public class Punto {
    private double x;
    private double y;

    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Punto() {
        this(0,0);
    }

    public Punto(Punto p) {
        this(p.x, p.y);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double calcularDistancia(Punto p) {
        return Math.sqrt(Math.pow(x-p.x,2) + Math.pow(y-p.y,2));
    }

    @Override
    public String toString() {
        return "Punto{" +
                "x=" + String.format("%.2f",x) +
                ", y=" + String.format("%.2f",y) +
                '}';
    }
}
