package ExamenRecuperacion.Models;

import java.time.temporal.ChronoUnit;
import java.util.GregorianCalendar;

import Lib.Util;

public class Alquiler {
    private static int NUM_ALQUILER = 0;
    private final int id;
    private GregorianCalendar fechaAlquiler;
    private Conductor conductor;
    private Vehiculo vehiculo;
    private GregorianCalendar fechaDevolucion;
    private double kmRecorridos;
    private double importePagar;

    // En mi implementacion un vehiculo puede tener varios regristros de alquileres,
    // con varias fechas de alquiler y de devolucion.
    public Alquiler(GregorianCalendar fechaAlquiler, Conductor conductor, Vehiculo vehiculo,
            GregorianCalendar fechaDevolucion,
            double kmRecorridos, double importePagar) {
        this.id = ++NUM_ALQUILER;
        this.fechaAlquiler = fechaAlquiler;
        this.conductor = conductor;
        this.vehiculo = vehiculo;
        this.fechaDevolucion = fechaDevolucion;
        this.kmRecorridos = kmRecorridos;
        this.importePagar = precioTotal();
    }

    public int getId() {
        return id;
    }

    public GregorianCalendar getFechaAlquiler() {
        return fechaAlquiler;
    }

    public GregorianCalendar getFechaDevolucion() {
        return fechaDevolucion;
    }

    public boolean isAlquilado() {
        if (getFechaDevolucion() == null) {
            return false;
        }
        return true;
    }

    // necesitamos saber el conductor para alquilar el vehiculo

    public double getImportePagar() {
        return importePagar;
    }

    // creamos set para la devolucion del alquiler
    public void setFechaDevolucion() {
        GregorianCalendar fechaDevolucion = new GregorianCalendar();// cogemos la fecha de devolucion actual;
        this.fechaDevolucion = fechaDevolucion;
    }

    public void setKmRecorridos(double kmRecorridos) {
        this.kmRecorridos = kmRecorridos;
    }

    public double precioTotal() {
        return (diasAlquilado() * vehiculo.getPrecioAlquilerDiario()) + (vehiculo.getPrecioKmRealizado() * kmRecorridos)
                + vehiculo.suplemento()
                - vehiculo.descuento(conductor);
    }

    public long diasAlquilado() {
        if (!isAlquilado()) {
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

    @Override
    public String toString() {
        return "Alquiler{" +
                "id=" + id +
                ", fechaAlquiler=" + Util.dateFrmYear(fechaAlquiler) +
                ", conductor=" + conductor +
                ", vehiculo=" + vehiculo +
                ", fechaDevolucion=" + Util.dateFrmYear(fechaDevolucion) +
                ", kmRecorridos=" + kmRecorridos +
                ", importePagar=" + importePagar +
                '}';
    }

}
