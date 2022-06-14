package Tema11.Propios.ejercicio06.models;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Objects;

import Tema11.Propios.ejercicio06.numeric.Formato;

public abstract class Multimedia {

    // Escribe una clase llamada Multimedia para almacenar información de objetos de
    // tipo multimedia(películas, videojuegos, ...).
    private static int N_ID = 0;
    private final int id;
    protected String titulo;
    protected Autor autor;
    protected Formato Formato;
    protected int anyo;
    protected List<Alquiler> alquileres;

    public Multimedia(String titulo, Autor autor, Formato formato, int anyo) {
        this.id = ++N_ID;
        this.titulo = titulo;
        this.autor = autor;
        this.Formato = formato;
        this.anyo = anyo;
        // Al crear multimedias la lista de alquileres estaran inicialmente vacias.
        this.alquileres = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Formato getFormato() {
        return Formato;
    }

    public void setFormato(Formato formato) {
        this.Formato = formato;
    }

    public int getAnyo() {
        return anyo;
    }

    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }

    public List<Alquiler> getAlquileres() {
        return alquileres;
    }

    public void setAlquileres(List<Alquiler> alquileres) {
        this.alquileres = alquileres;
    }

    // *METODOS A GENERAR */
    // 1.equals() compara autor y el titulo de la multimedia para saber si son los
    // mismos

    public boolean equals(Multimedia m) {
        return this.titulo.equalsIgnoreCase(m.titulo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titulo, autor, anyo, Formato, alquileres);
    }

    // *ALQUILER */

    // Obtiene el precio del alquiler
    // @return precio del alquiler
    public abstract double getPrecioAlquiler();

    // Alquila un multimeda a un Socio con la fecha indicando/
    /**
     * 
     * @param socio
     * @param fechaAlquiler
     * @return el precio del alquiler o -1 si el socio tiene recargos pendientes
     */
    public double alquilar(Socio socio, GregorianCalendar fechaAlquiler) {
        if (!isAlquilado()) {
            if (!socio.tieneRecargosPendientes()) {
                alquileres.add(new Alquiler(socio, fechaAlquiler));// anyadimos el alquiler si el socio no tiene
                                                                   // recargos pendientes
                return getPrecioAlquiler();
            } else {
                System.out.println("El socio tiene recargos pendientes");
            }
        }
        return -1;
    }

    /**
     * 
     * @param fechaDevolucion
     * @return la multimedia que habia sido alquilado o -1 si la devoluicon ha
     *         generado recargo
     */

    public double devolver(GregorianCalendar fechaDevolucion) {
        if (isAlquilado()) {
            return alquileres.get(alquileres.size() - 1).devolver(fechaDevolucion);
        }
        return -1;
    }

    public double devolver() {
        return this.devolver(new GregorianCalendar()); // llama al otro metodo que invoca // devuelve la multimedia que
                                                       // previamente habia sido alquilado tomando la fecha de
                                                       // devolucion la fecha actual o -1 si la devolucion ha generado
                                                       // recargo la cantidad a pagar por el socio.

    }

    // alquila un multimedia a un socio con la fecha actual del systema
    public double alquilar(Socio socio) {
        return this.alquilar(socio, new GregorianCalendar()); // este alquiler llama a la otra funcion donde nos
                                                              // devuelve 1 si es true o -1 si es falso
    }

    // Determina si un multimeda esta alquilado actualmente
    // true si lo esta y false si no lo esta
    public boolean isAlquilado() {
        if (alquileres.size() == 0) {
            return false;
        }
        return alquileres.get(alquileres.size() - 1).getFechaDevolucion() == null;
    }

    // *ORDENACION */
    public static class ComparatorTitulo implements Comparator<Multimedia> {

        // Permiete ordenar los multimedia por titulo
        @Override
        public int compare(Multimedia m1, Multimedia m2) {
            return m1.titulo.compareToIgnoreCase(m2.titulo.toUpperCase());
        }

    }

    public static class ComparatorAnyo implements Comparator<Multimedia> {

        @Override
        public int compare(Multimedia m1, Multimedia m2) {
            return m1.getAnyo() - m2.getAnyo();
        }

    }

    @Override
    public String toString() {
        return "Multimedia [Formato=" + Formato + ", alquileres=" + alquileres + ", anyo=" + anyo + ", autor=" + autor
                + ", id=" + id + ", titulo=" + titulo + "]\n";
    }

}
