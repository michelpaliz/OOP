package Tema11.Propios.ejercicio06.models;

import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
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

    public int getId() {
        return id;
    }

    public Socio getSocio() {
        return socio;
    }

    public GregorianCalendar getFechaAlquiler() {
        return fechaAlquiler;
    }

    public GregorianCalendar getFechaDevolucion() {
        return fechaDevolucion;
    }

    // METODOS A GENERAR
    // 1. devolver() = recargo o false;
    // 2.devolver() = que llama al otro devolver (este vamos a llamar)
    // 3.busqueda() del alquiler por fecha

    public String getFechaAlquilerStr() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(fechaAlquiler.getTime());
    }

    /**
     * 
     * @param fechaDevolucion
     * @return el precio del recargo del socio que ha superado los dias limite.
     */
    public double devolver(GregorianCalendar fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
        long dias = ChronoUnit.DAYS.between(this.fechaAlquiler.toInstant(), this.fechaDevolucion.toInstant());
        if (dias > MAX_DIA_ALQUILER) {
            double recargo = (dias - MAX_DIA_ALQUILER) * RECARGO_POR_DIA;
            // El socio tiene un nuevo recargo con un precio mayor a 0
            socio.generarRecargo(this, recargo);
            return recargo;
        }
        return 0;
    }

    /**
     * Devuelve un alquiler en la fecha actual
     * 
     * @return 0 si no se ha generado Recargo, en caso contrario devuelve el importe
     *         que ha generado el importe.
     */
    public double devolver() {
        return this.devolver(new GregorianCalendar());
    }

    // *BUSQUEDA POR FECHA */

    public static class ComparatorFechaAlquiler implements Comparator<Alquiler> {
        @Override
        public int compare(Alquiler a0, Alquiler a1) {
            return a0.getFechaAlquiler().compareTo(a1.getFechaAlquiler());
        }

    }

}
