package Tema11.Propios.ejercicio06.models;

import java.time.temporal.ChronoUnit;
import java.util.GregorianCalendar;

import Lib.strM;

public class Alquiler {

    private static final int MAX_DIA_ALQUILER = 3;
    private static final double RECARGO_POR_DIA = 2;
    private static int N_ALQUILERES = 0;

    // *ATRIBUTOS */
    private final int id;
    private final Socio socio;
    private final GregorianCalendar fechaAlquiler;
    private GregorianCalendar fechaDevolucion;

    public Alquiler(Socio socio, GregorianCalendar fechaAlquiler) {
        this(socio, fechaAlquiler, null);
    }

    public Alquiler(Socio socio, GregorianCalendar fechaAlquiler, GregorianCalendar fechaDevolucion) {
        this.id = ++N_ALQUILERES;
        this.socio = socio;
        this.fechaAlquiler = fechaAlquiler;
        this.fechaDevolucion = fechaDevolucion;

        if (fechaDevolucion != null) {
            devolver(fechaDevolucion);
        }

    }

    public double devolver(GregorianCalendar fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
        long dias = ChronoUnit.DAYS.between(this.fechaAlquiler.toInstant(), this.fechaDevolucion.toInstant());
        if (dias > MAX_DIA_ALQUILER) {
            double recargo = (dias - MAX_DIA_ALQUILER) * RECARGO_POR_DIA;
            Socio.generarRecargo(this, recargo);
        }
        return 0;
    }



}
