package EjerciciosTema8.Ejercicio4;

public class Punto {
    // Creacion de Atributos
    private double x;
    private double y;

    // Creacion Constructores
    public Punto() {
        this.x = 10;
        this.y = 5;
    }

    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Creacion de getters
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    // Creacion de setter

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Punto{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public String visualizarPunto() {
        return "(" + x + ", " + y + ")";
    }

    // Metodos o funciones Secundarias
    // calcular la distancia
    public double calcularDistancia(Punto punto2) {
        System.out.println("Esto es punto1 " + x + y);
        double resultadoX = (punto2.getX() - x);
        double resultadoY = (punto2.getY() - y);
        System.out.println("Este es el resultado de x " + resultadoX);
        System.out.println("Este es el resultado de y " + resultadoY);
        double potenciaX = Math.pow(resultadoX, 2);
        double potenciaY = Math.pow(resultadoY, 2);
        double suma = potenciaX + potenciaY;
        System.out.println("La distancia es de  " + suma);
        return Math.sqrt(suma);

    }

    public Punto(Punto p) {
        this(p.x, p.y);
    }

    // public double calcularDistancis(Punto p){
    // return Math.sqert(match.jpow()x-p.x,3), Math.pow(y-p)
    // }

    // public static double calcularDistancia(Punto p1, Punto p2) {
    // return Math.sqrt((Math.pow((p1.getX() - p2.getX())+ Math.pow())))
    // }

    // No hace falta meter parametros porque el metodo es dinamico

}
