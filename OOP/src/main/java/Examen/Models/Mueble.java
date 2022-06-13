package Examen.Models;

import Examen.numeric.Enombre;

public abstract class Mueble implements Comparable<Mueble> {

    private static int cont = 0;
    private int codigo;
    private Enombre nombre;
    private double precio;
    private double alto;
    private double ancho;
    private double profundo;
    private int stock;

    public Mueble(Enombre nombre, double precio, double alto, double ancho, double profundo, int stock) {
        this.codigo = ++cont;
        this.nombre = nombre;
        this.precio = precio;
        this.alto = alto;
        this.ancho = ancho;
        this.profundo = profundo;
        this.stock = stock;
    }

    public int getCodigo() {
        return codigo;
    }

    public Enombre getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public double getAlto() {
        return alto;
    }

    public double getAncho() {
        return ancho;
    }

    public double getProfundo() {
        return profundo;
    }

    public int getStock() {
        return stock;
    }

    public boolean checkStock(Mueble m) {
        if (m.getStock() > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Mueble [alto=" + alto + ", ancho=" + ancho + ", codigo=" + codigo + ", nombre=" + nombre + ", precio="
                + precio + ", profundo=" + profundo + ", stock=" + stock + "]";
    }

    @Override
    public int compareTo(Mueble o) {
        int salida;
        if (o.getNombre().compareTo(this.nombre) == 0) {
            salida = 1;
        } else {
            salida = -1;
        }
        return salida;

    }

}
