package ExamenRecuperacion.Models;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import ExamenRecuperacion.numeric.NCombustible;

public abstract class Vehiculo {
    private static int cont = 1;
    private String matricula;
    private String marca;
    private String modelo;
    private double precioAlquilerDiario;
    private double precioKmRealizado;
    private NCombustible tipoCombustible;
    // vamos ha crear un historia de los alquileres por vehiculo.
    private List<Alquiler> alquileres;

    public Vehiculo(String marca, String modelo, double precioAlquilerDiario,
            double precioKmRealizado, NCombustible tipoCombustible) {
        ++cont;
        this.matricula = "C00" + cont;
        this.marca = marca;
        this.modelo = modelo;
        this.precioAlquilerDiario = precioAlquilerDiario;
        this.precioKmRealizado = precioKmRealizado;
        this.tipoCombustible = tipoCombustible;
        alquileres = new ArrayList<>();
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public double getPrecioAlquilerDiario() {
        return precioAlquilerDiario;
    }

    public NCombustible getTipoCombustible() {
        return tipoCombustible;
    }

    public String getMatricula() {
        return matricula;
    }

    public double getPrecioKmRealizado() {
        return precioKmRealizado;
    }

    public List<Alquiler> getAlquileres() {
        return alquileres;
    }

    // necesitamos saber el conductor para alquilar el vehiculo
    public boolean alquilarVehiculo(Conductor conductor) {
        Date fechaAlquiler = new Date();
        Date fechaDevolucion = null;
        alquileres.add(new Alquiler(fechaAlquiler, conductor, this, fechaDevolucion, 0, 0));
        return true;
    }

    // ABSTRACT
    public abstract double suplemento();

    // necesitamos saber que conductor es para aplicar los descuentos
    public abstract double descuento(Conductor conductor);

    public double precioTotal(Alquiler alquiler, double kmRealizado, Conductor conductor) {
        return (alquiler.diasAlquilado() * getPrecioAlquilerDiario()) + (getPrecioKmRealizado() * kmRealizado)
                + suplemento()
                - descuento(conductor);
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "matricula='" + matricula + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", precioAlquilerDiario=" + precioAlquilerDiario +
                ", precioKmRealizado=" + precioKmRealizado +
                ", tipoCombustible=" + tipoCombustible +
                '}';
    }

    public static class OrdenarPorPrecio implements Comparator<Vehiculo> {

        @Override
        public int compare(Vehiculo v1, Vehiculo v2) {
            return Double.compare(v1.getPrecioAlquilerDiario(), v2.getPrecioAlquilerDiario());
        }

    }

    public static class CompararPorTipo implements Comparator<Vehiculo> {

        @Override
        public int compare(Vehiculo v1, Vehiculo v2) {
            int salida;
            if (v1.getTipoCombustible().compareTo(v2.getTipoCombustible()) == 0) {
                salida = 1;
            } else {
                salida = -1;
            }
            return salida;
        }

    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Vehiculo other = (Vehiculo) obj;
        if (matricula == null) {
            if (other.matricula != null)
                return false;
        } else if (!matricula.equals(other.matricula))
            return false;
        return true;
    }

}
