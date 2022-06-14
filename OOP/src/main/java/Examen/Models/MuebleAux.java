package Examen.Models;

import Examen.numeric.Enombre;

public class MuebleAux extends Mueble {

    private String color;

    public MuebleAux(Enombre nombre, double precio, double alto, double ancho, double profundo, int stock,
            String color) {
        super(nombre, precio, alto, ancho, profundo, stock);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Auxiliar" + super.toString() + " color=" + color + "]";
    }

}
