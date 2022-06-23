package Examen.Models;

import java.util.Comparator;

public abstract class Mueble {

    private static int cont = 0;
    private String codigo;
    private String nombre;
    private double precio;
    private double alto;
    private double ancho;
    private double profundo;
    private int stock;

    public Mueble(String nombre2, double precio, double alto, double ancho, double profundo, int stock) {
        this.codigo = "C000" + cont;
        this.nombre = nombre2;
        this.precio = precio;
        this.alto = alto;
        this.ancho = ancho;
        this.profundo = profundo;
        this.stock = stock;
    }

    public String getCodigo() {
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

    public static class CompararPorNombre implements Comparator<Mueble> {

        @Override
        public int compare(Mueble m1, Mueble m2) {
            int salida;
            if (m1.getNombre().compareTo(m2.getNombre()) == 0) {
                salida = 1;
            } else {
                salida = -1;
            }
            return salida;
        }

    }

    // @Override
    // public boolean equals(Object obj) {
    //     // Esto hace que delege este comparacion a este misma clase donde se encuentra
    //     // el metodo
    //     if (obj instanceof Mueble) {
    //         Mueble otroMueble = (Mueble) obj;
    //         if (this.codigo.equalsIgnoreCase(otroMueble.codigo)) {
    //             return true;
    //         }
    //     }
    //     return false;
    // }

    

}
