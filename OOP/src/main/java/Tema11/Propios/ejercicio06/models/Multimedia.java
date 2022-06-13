package Tema11.Propios.ejercicio06.models;

import java.util.List;

import Tema11.Propios.ejercicio06.numeric.Formato;

public abstract class Multimedia {

    // Escribe una clase llamada Multimedia para almacenar información de objetos de
    // tipo multimedia(películas, videojuegos, ...).

    private String titulo;
    private String autor;
    private Formato formato;
    private int anyo;
    List<Pelicula> peliculas;
    List<Videojuego> videojuegos;

    public Multimedia() {
        this.titulo = "My book";
        this.autor = "MIchael";
        this.formato = Formato.BLUE_RAY;
        this.anyo = 0;
    }

    public Multimedia(String title, String name, Formato format, int anyo, List<Pelicula> peliculas,
            List<Videojuego> videojuegos) {
        this.titulo = title;
        this.autor = name;
        this.formato = format;
        this.anyo = anyo;
        this.peliculas = peliculas;
        this.videojuegos = videojuegos;
    }

    public String getTitle() {
        return titulo;
    }

    public String getAuthor() {
        return autor;
    }

    public Formato getFormat() {
        return formato;
    }

    public int getAnyo() {
        return anyo;
    }

    @Override
    public boolean equals(Object obj) {
        // returns a true if the title and the actor are the same as the paramether and
        // false otherwise.
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Multimedia other = (Multimedia) obj;
        if (autor == null) {
            if (other.autor != null)
                return false;
        } else if (!autor.equals(other.autor))
            return false;
        if (titulo == null) {
            if (other.titulo != null)
                return false;
        } else if (!titulo.equals(other.titulo))
            return false;
        // be careful bcs if our main obj is null and the paramether is null as well it
        // will lauchn a true value
        return true;
    }

    @Override
    public String toString() {
        return "Multimedia [anyo=" + anyo + ", autor=" + autor + ", formato=" + formato + ", titulo=" + titulo + "] \n";
    }

}
