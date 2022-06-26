package Examen.Models;

import java.time.LocalTime;
import java.util.*;

import com.github.javafaker.Faker;

import Examen.Config.Config;

public abstract class Mueble {

    private static int cont = 1;
    private String codigo;
    private String nombre;
    private double precio;
    private double alto;
    private double ancho;
    private double profundo;
    private int stock;
    // Cada instancia creada del mueble siempre tendra una sombra de ventas por
    // detras servira para el registro del mismo.
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

    // Este metodo lo hacemos abstract para que se obligatorio para las demas hijas.
    // Conste que abstract no puede llevar body.
    public abstract double importeEnvio(double km);

    // El precio total depende de los km que hay de distancia.
    public double precioTotal(double km) {
        return importeEnvio(km) + precio;
    }

    // vendemos el mueble siempre y cuando haya stock
    // Creamos un metodo de venta por defecto.
    // Este metodo lo utilizo mas para generar datos aleatorios de fechas para las
    // ventas.
    public boolean venderMueble() {
        Date d1 = new Date(); // obtenemos la fecha actual
        Date d2 = new GregorianCalendar(2000, Calendar.FEBRUARY, 11).getTime();
        if (stock > 0) {
            stock = stock - -1;
            ventas.add(new Venta(this, Config.fk.date().between(d2, d1)));
            return true;
        }
        return false;
    }

    // vendemos el mueble siempre y cuando haya stock
    public boolean venderMueble(int cantidad) {
        Date d1 = new Date();// fecha actual de la venta
        if (stock > 0 && stock > cantidad) {
            stock = stock - cantidad;
            ventas.add(new Venta(this, d1));
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

    public static class ordenarPorStock implements Comparator<Mueble> {

        @Override
        public int compare(Mueble m1, Mueble m2) {
            return m1.getStock() - m2.getStock();
        }

    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
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
            } else {
                return false;
            }
        }
        return false;
    }

}
