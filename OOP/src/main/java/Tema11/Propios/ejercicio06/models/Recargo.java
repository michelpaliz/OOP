package Tema11.Propios.ejercicio06.models;

import java.util.GregorianCalendar;

public class Recargo {

    private final Alquiler alquiler;
    private double cantidadPagar;
    private GregorianCalendar fechaPago;

    public Recargo(Alquiler alquiler, double cantidadPagar) {
        this.alquiler = alquiler;
        this.cantidadPagar = cantidadPagar;
        this.fechaPago = null;
    }

    public void pagar() {
        this.fechaPago = new GregorianCalendar();
    }

    public Alquiler getAlquiler() {
        return alquiler;
    }

    public double getCantidadPagar() {
        return cantidadPagar;
    }

    public GregorianCalendar getFechaPago() {
        return fechaPago;
    }

    @Override
    public String toString() {
        return "Recargo{" +
                "alquiler=" + alquiler +
                ", cantidadAPagar=" + cantidadPagar +
                ", fechaPago=" + fechaPago +
                '}';
    }

}
