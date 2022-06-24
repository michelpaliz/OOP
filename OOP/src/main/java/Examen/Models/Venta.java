package Examen.Models;

import java.util.GregorianCalendar;

public class Venta {
    private static int NUM_VENTA = 0;

    private final int id;
    private final Mueble mueble;
    private final GregorianCalendar diaCompra;

    public Venta(Mueble mueble, GregorianCalendar diaCompra) {
        this.id = ++NUM_VENTA;
        this.mueble = mueble;
        this.diaCompra = diaCompra;
    }

    public int getId() {
        return id;
    }

    public GregorianCalendar getDiaCompra() {
        return diaCompra;
    }

    @Override
    public String toString() {
        return "Venta{" +
                "id=" + id +
                ", mueble=" + mueble +
                ", diaCompra=" + diaCompra +
                '}';
    }
}
