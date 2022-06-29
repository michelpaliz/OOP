package ExamenRecuperacion.Models;

import java.util.Date;
import java.util.concurrent.TimeUnit;

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
    public Alquiler(Date fechaAlquiler, Conductor conductor, Vehiculo vehiculo, Date fechaDevolucion,
            double kmRecorridos, double importePagar) {
        this.id = ++NUM_ALQUILER;
        this.fechaAlquiler = fechaAlquiler;
        this.conductor = conductor;
        this.vehiculo = vehiculo;
        this.fechaDevolucion = fechaDevolucion;
        this.kmRecorridos = kmRecorridos;
        this.importePagar = vehiculo.precioTotal(this, kmRecorridos, this.conductor);
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

    public boolean isAlquilado() {
        if (getFechaDevolucion() == null) {
            return false;
        }
        return true;
    }

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

    public int diasAlquilado() {
        long timeDiff = Math.abs(fechaAlquiler.getTime() - fechaDevolucion.getTime());
        long daysDiff = TimeUnit.DAYS.convert(timeDiff, TimeUnit.MILLISECONDS);
        return (int) daysDiff;
    }

    @Override
    public String toString() {
        return "Alquiler{" +
                "id=" + id +
                ", fechaAlquiler=" + fechaAlquiler +
                ", conductor=" + conductor +
                ", vehiculo=" + vehiculo +
                ", fechaDevolucion=" + Util.dateFrmYear(fechaDevolucion) +
                ", kmRecorridos=" + kmRecorridos +
                ", importePagar=" + importePagar +
                '}';
    }

}
