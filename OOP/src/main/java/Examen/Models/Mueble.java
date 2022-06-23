package Examen.Models;

public abstract class Mueble implements Comparable<Mueble> {

    private static int cont = 0;
    private int codigo;
    private String nombre;
    private double precio;
    private double alto;
    private double ancho;
    private double profundo;
    private int stock;

    public Mueble(String nombre2, double precio, double alto, double ancho, double profundo, int stock) {
        this.codigo = ++cont;
        this.nombre = nombre2;
        this.precio = precio;
        this.alto = alto;
        this.ancho = ancho;
        this.profundo = profundo;
        this.stock = stock;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
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
        return "Mueble{" +
                "codigo_mueble=" + codigo +
                ", nombre=" + nombre +
                ", precio=" + precio +
                ", alto=" + alto +
                ", ancho=" + ancho +
                ", profundo=" + profundo +
                ", stock=" + stock +
                '}';
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
