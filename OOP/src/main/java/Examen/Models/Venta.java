package Examen.Models;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.Date;

import Lib.Util;

public class Venta {
    private static int NUM_VENTA = 0;

    private final int id;
    private final Mueble mueble;
    private final Date diaCompra;

    public Venta(Mueble mueble, Date gregorianCalendar) {
        this.id = ++NUM_VENTA;
        this.mueble = mueble;
        this.diaCompra = gregorianCalendar;
    }

    public int getId() {
        return id;
    }

    public Date getDiaCompra() {
        return diaCompra;
    }

    @Override
    public String toString() {
        return "Venta{" +
                "id=" + id +
                ", mueble=" + mueble +
                ", diaCompra=" + Util.dateFrmYear(diaCompra) +
                '}';
    }

    public static class ordenarVentasPorAnyo implements Comparator<Venta> {
        @Override
        public int compare(Venta v1, Venta v2) {
            int resultado = 0;
            if (v1.getDiaCompra().equals(v2.getDiaCompra())) {
                resultado = 0;
            } else if (v1.getDiaCompra().after(v2.getDiaCompra())) {
                resultado = 1;
            } else {
                resultado = -1;
            }
            return resultado;
        }

    }

}
