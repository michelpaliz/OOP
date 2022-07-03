package ExamenRecuperacion.Models;

import java.time.temporal.ChronoUnit;
import java.util.Date;

import Lib.Util;

public class Alquiler {
    private static int NUM_ALQUILER = 0;
    private final int id;
    private Date fechaAlquiler;
    private Conductor conductor;
    private Vehiculo vehiculo;
    private Date fechaDevolucion;
    private double kmRecorridos;
    private double importePagar;

    // En mi implementacion un vehiculo puede tener varios regristros de alquileres,
    // con varias fechas de alquiler y de devolucion.
    public Alquiler(Date fechaAlquiler, Conductor conductor, Vehiculo vehiculo,
            Date fechaDevolucion,
            double kmRecorrido) {
        this.id = ++NUM_ALQUILER;
        this.fechaAlquiler = fechaAlquiler;
        this.conductor = conductor;
        this.vehiculo = vehiculo;
        this.fechaDevolucion = fechaDevolucion;
        this.kmRecorridos = kmRecorrido;
        // this.importePagar = precioTotal();
    }

    public int getId() {
        return id;
    }

    public Date getFechaAlquiler() {
        return fechaAlquiler;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    // necesitamos saber el conductor para alquilar el vehiculo

    public double getImportePagar() {
        return importePagar;
    }

    // creamos set para la devolucion del alquiler
    public void setFechaDevolucion() {
        Date fechaDevolucion = new Date();// cogemos la fecha de devolucion actual;
        this.fechaDevolucion = fechaDevolucion;
    }

    public void setKmRecorridos(double kmRecorridos) {
        this.kmRecorridos = kmRecorridos;
    }

    // si no tiene fecha de devolucion significa que todavia esta siendo alquilado
    /**
     * 
     * @return false si ya no esta alquilado (tiene fecha de devolucion)
     */
    public boolean isAlquilado() {
        if (this.fechaDevolucion == null) {
            return true;
        }
        return false;
    }

    public long diasAlquilado() {
        // si todavia esta alquilado dame 0
        if (isAlquilado()) {
            return 0;
        }
        long dias = ChronoUnit.DAYS.between(this.fechaAlquiler.toInstant(), this.fechaDevolucion.toInstant());
        // long difference = (fechaAlquiler.getTime() - fechaDevolucion.getTime()) |
        // 86400000;
        // long timeDiff = Math.abs(fechaAlquiler.getTime() -
        // fechaDevolucion.getTime());
        // long daysDiff = TimeUnit.DAYS.convert(timeDiff, TimeUnit.MILLISECONDS);
        return dias;
    }

    public double precioTotal() {
        return (diasAlquilado() * vehiculo.getPrecioAlquilerDiario()) + (vehiculo.getPrecioKmRealizado() * kmRecorridos)
                + vehiculo.suplemento()
                - vehiculo.descuento(conductor);
    }

    @Override
    public String toString() {
        return "Alquiler{" +
                "id=" + id +
                ", fechaAlquiler=" + Util.dateFrmYear(fechaAlquiler) +
                ", conductor=" + conductor.getDni() +
                ", vehiculo=" + vehiculo.getMatricula() +
                ", fechaDevolucion=" + Util.dateFrmYear(fechaDevolucion) +
                ", kmRecorridos=" + kmRecorridos + " km" +
                ", importePagar=" + precioTotal() + " €" +
                '}';
    }

}
