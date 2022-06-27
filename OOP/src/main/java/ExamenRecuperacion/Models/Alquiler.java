package ExamenRecuperacion.Models;

import java.util.Date;

public class Alquiler {
    private Date fechaAlquiler;
    private Conductor conductor;
    private Vehiculo vehiculo;
    private Date fechaDevolucion;
    private double kmRecorridos;
    private double importePagar;


    public Alquiler(Date fechaAlquiler, Conductor conductor, Vehiculo vehiculo, Date fechaDevolucion,
            double kmRecorridos, double importePagar) {
        this.fechaAlquiler = fechaAlquiler;
        this.conductor = conductor;
        this.vehiculo = vehiculo;
        this.fechaDevolucion = fechaDevolucion;
        this.kmRecorridos = kmRecorridos;
        this.importePagar = importePagar;
    }
 

    
}
