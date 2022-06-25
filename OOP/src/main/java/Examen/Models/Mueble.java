package Examen.Models;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.List;

public abstract class Mueble {

    private static int cont = 1;
    private String codigo;
    private String nombre;
    private double precio;
    private double alto;
    private double ancho;
    private double profundo;
    private int stock;

    private List<Venta> ventas;

    public Mueble(String nombre2, double precio, double alto, double ancho, double profundo, int stock) {
        ++cont;
        this.codigo = "C00" + cont;
        this.nombre = nombre2;
        this.precio = precio;
        this.alto = alto;
        this.ancho = ancho;
        this.profundo = profundo;
        this.stock = stock;
        ventas = new ArrayList<>();
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

    public List<Venta> getVentas() {
        return ventas;
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

    public abstract double importeEnvio(double km);

    public double precioTotal(double km) {
        return importeEnvio(km) + precio;
    }

    public boolean venderMueble() {
        if (stock > 0) {
            stock = stock - 1;
            ventas.add(new Venta(this, new GregorianCalendar()));
            return true;
        }
        return false;
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

    public static class OrdenarPorCodigo implements Comparator<Mueble> {

        @Override
        public int compare(Mueble m1, Mueble m2) {
            return m1.getCodigo().compareTo(m2.getCodigo());
        }

    }

    @Override
    public boolean equals(Object obj) {
        // Esto hace que delege este comparacion a este misma clase donde se
        // encuentra
        // el metodo
        if (obj instanceof Mueble) {
            Mueble otroMueble = (Mueble) obj;
            if (this.codigo.equalsIgnoreCase(otroMueble.codigo)) {
                return true;
            }
        }
        return false;
    }

}
