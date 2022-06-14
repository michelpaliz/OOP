package Examen.Models;

import Examen.numeric.Enombre;

public class MuebleClasico extends Mueble {

    private double peso;
    private String tipoMadera;

    public MuebleClasico(Enombre nombre, double precio, double alto, double ancho, double profundo, int stock,
            double peso,
            String tipoMadera) {
        super(nombre, precio, alto, ancho, profundo, stock);
        this.peso = peso;
        this.tipoMadera = tipoMadera;
    }

    public double getPeso() {
        return peso;
    }

    public String getTipoMadera() {
        return tipoMadera;
    }

    @Override
    public String toString() {
        return "Clasico" + super.toString() + " peso=" + peso + ", tipoMadera=" + tipoMadera + "]\n";
    }

}
