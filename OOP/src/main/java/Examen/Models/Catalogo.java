package Examen.Models;

import java.util.Comparator;
import java.util.List;

import Examen.numeric.Enombre;

public class Catalogo implements Comparator<Catalogo> {
    private static int cont;
    private int id;
    private Enombre nombre;
    private int anyo;
    private final Mueble m;
    // private final List<Mueble> muebles;

    public Catalogo(Enombre nombre, int anyo, Mueble mueble) {
        this.id = ++cont;
        this.nombre = nombre;
        this.anyo = anyo;
        this.m = mueble;
    }

    public int getId() {
        return id;
    }

    public Enombre getNombre() {
        return nombre;
    }

    public int getAnyo() {
        return anyo;
    }

    public Mueble getMuebles() {
        return m;
    }

    @Override
    public String toString() {
        return "Catalago [anyo=" + anyo + ", id=" + id + ", muebles=" + m + ", nombre=" + nombre + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + anyo;
        result = prime * result + id;
        result = prime * result + ((m == null) ? 0 : m.hashCode());
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        return result;

    }

    @Override
    public boolean equals(Object obj) {
        Catalogo other = (Catalogo) obj;
        if (id != other.id)
            return false;
        return true;
    }


    @Override
    public int compare(Catalogo arg0, Catalogo arg1) {
        // TODO Auto-generated method stub
        return 0;
    }

}
