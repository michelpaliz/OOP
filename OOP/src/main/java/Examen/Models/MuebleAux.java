package Examen.Models;

public class MuebleAux extends Mueble {

    private String color;

    public MuebleAux(String nombre, double precio, double alto, double ancho, double profundo, int stock,
            String color) {
        super(nombre, precio, alto, ancho, profundo, stock);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "MuebleAux{" +
                "color='" + color + '\'' + super.toString() +
                '}';
    }

    @Override
    public double importeEnvio(double km) {
        return super.getAlto() * super.getAncho() * super.getProfundo() * km;
    }
}
