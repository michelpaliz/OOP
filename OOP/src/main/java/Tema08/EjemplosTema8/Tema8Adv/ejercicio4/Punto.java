package Tema08.EjemplosTema8.Tema8Adv.ejercicio4;

public class Punto {
    private double x;
    private double y;

    public Punto() {
        x = 0;
        y = 0;
    }

    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Punto(Punto p) {
        this.x = p.x;
        this.y = p.y;
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
        return Math.sqrt(Math.pow(this.x - p.x,2) + Math.pow(this.y - p.y,2));
    }

    public void visualizarPunto() {
        System.out.println("(" + x + "," + y + ")");
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
