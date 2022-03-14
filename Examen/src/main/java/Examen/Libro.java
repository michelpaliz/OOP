package Examen;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.GregorianCalendar;

public class Libro {
    // Atributos de libro
    private String isb;
    private String titulo;
    private GregorianCalendar fecha;
    private Genero genero;
    private int numPaginas;
    private Autor autor;

    public Libro(String isb, String titulo, GregorianCalendar fecha, Genero genero, int numPaginas, Autor autor2) {
        this.isb = isb;
        this.titulo = titulo;
        this.fecha = fecha;
        this.genero = genero;
        this.numPaginas = numPaginas;
        this.autor = autor2;
    }

    public String getIsb() {
        return isb;
    }

    public String getTitulo() {
        return titulo;
    }

    public GregorianCalendar getFecha() {
        return fecha;
    }

    public Genero getGenero() {
        return genero;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public Autor getAutor() {
        return autor;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return "Libro{" +
                "isb=" + isb +
                ", titulo='" + titulo + '\'' +
                ", fecha=" + sdf.format(fecha.getTime()) +
                ", genero=" + genero +
                ", numPaginas=" + numPaginas +
                ", autor=" + (autor) +
                '}';
    }
}
