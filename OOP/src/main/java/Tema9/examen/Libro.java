package Tema9.examen;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Libro {
    public enum Genero {
        AVENTURAS, FICCION, POLICIACA, DRAMA
    }
    private final String isbn;
    private final String titulo;
    private final GregorianCalendar fechaPublicacion;
    private final Genero genero;
    private final int paginas;
    private final Autor autor;

    public Libro(String isbn, String titulo, GregorianCalendar fechaPublicacion, Genero genero, int paginas, Autor autor) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.fechaPublicacion = fechaPublicacion;
        this.genero = genero;
        this.paginas = paginas;
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public GregorianCalendar getFechaPublicacion() {
        return fechaPublicacion;
    }

    public Genero getGenero() {
        return genero;
    }

    public int getPaginas() {
        return paginas;
    }

    public Autor getAutor() {
        return autor;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        return "Libro{" +
                "isbn='" + isbn + '\'' +
                ", titulo='" + titulo + '\'' +
                ", fechaPublicacion=" + sdf.format(fechaPublicacion.getTime()) +
                ", genero=" + genero +
                ", paginas=" + paginas +
                ", autor=" + autor +
                '}';
    }
}
