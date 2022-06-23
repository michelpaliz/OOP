package Examen.Models;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import Examen.numeric.Etipo;

public class Catalogo {
    private static int cont = 0;
    private final int id;
    private Etipo nombre;
    private int anyo;
    private List<Mueble> muebles;

    public Catalogo() {
        this.id = ++cont;
        muebles = new ArrayList<>();
    }

    public Catalogo(Etipo nombre, int anyo, List<Mueble> muebles) {
        this();
        this.nombre = nombre;
        this.anyo = anyo;
        this.muebles = muebles;
    }

    public int getId() {
        return id;
    }

    public Etipo getNombre() {
        return nombre;
    }

    public int getAnyo() {
        return anyo;
    }

    public List<Mueble> getMuebles() {
        return muebles;
    }

    @Override
    public String toString() {
        return "Catalogo{" +
                "idCatalogo=" + id +
                ", nombre=" + nombre +
                ", anyo=" + anyo +
                ", muebles=" + muebles +
                '}' + "\n";
    }

    // Para la app el mueble sera el mismo si el id es el mismo que el que le pasamo
    // por parametro.
    // @Override
    // public boolean equals(Object obj) {
    // // Convertirmos el otro objeto en catalago
    // Catalogo other = (Catalogo) obj;
    // if (id != other.id)
    // return false;
    // return true;
    // }

    public static class CompararPorAnyo implements Comparator<Catalogo> {

        @Override
        public int compare(Catalogo c1, Catalogo c2) {
            // orden descendente (menor a mayor)
            return c1.getAnyo() - c2.getAnyo();
            // orden ascendente (mayor a menor)
            // return c2.getAnyo() - c1.getAnyo();
        }

    }

    // @Override
    // public int compare(Catalogo c1, Catalogo c2) {
    // // orden Descendente
    // // return c2.getAnyo() - c1.getAnyo();
    // return c1.getAnyo() - c2.getAnyo();
    // }

}
