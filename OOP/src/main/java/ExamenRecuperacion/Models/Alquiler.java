package ExamenRecuperacion.Models;

import java.util.Date;

public class Alquiler {
    private static int NUM_ALQUILER = 0;
    private final int id;
    private Date fechaAlquiler;
    private Conductor conductor;
    private Vehiculo vehiculo;
    private Date fechaDevolucion;
    private double kmRecorridos;
    private double importePagar;

    public Alquiler(Date fechaAlquiler, Conductor conductor, Vehiculo vehiculo, Date fechaDevolucion,
            double kmRecorridos, double importePagar) {
        this.id = ++NUM_ALQUILER;
        this.fechaAlquiler = fechaAlquiler;
        this.conductor = conductor;
        this.vehiculo = vehiculo;
        this.fechaDevolucion = fechaDevolucion;
        this.kmRecorridos = kmRecorridos;
        this.importePagar = importePagar;
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

    @Override
    public String toString() {
        return "Alquiler{" +
                "id=" + id +
                ", fechaAlquiler=" + fechaAlquiler +
                ", conductor=" + conductor +
                ", vehiculo=" + vehiculo +
                ", fechaDevolucion=" + fechaDevolucion +
                ", kmRecorridos=" + kmRecorridos +
                ", importePagar=" + importePagar +
                '}';
    }

}
