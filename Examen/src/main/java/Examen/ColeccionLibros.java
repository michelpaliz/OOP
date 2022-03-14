package Examen;

import java.util.Arrays;
import java.util.GregorianCalendar;

import Util.Lib;

public class ColeccionLibros {
    private static final int INITIAL_BOOK_COUNT = 10;
    private static final int INITIAL_AUTHOR_COUNT = 10;
    private static final int GROW_FACTOR = 2;

    // Creacion de atributos
    private Libro[] libros;
    private Autor[] autores;
    private int librosCount;
    private int autoresCount;

    public ColeccionLibros() {
        this(INITIAL_BOOK_COUNT, INITIAL_AUTHOR_COUNT);
    }

    private ColeccionLibros(int numLibros, int numAutores) {
        libros = new Libro[numLibros];
        autores = new Autor[numAutores];
        if (Config.DEBUG) {
            crearDatosPrueba(numLibros, numAutores);
            System.out.println(Arrays.toString(libros));

        }
    }

    public void crearDatosPrueba(int numLibros, int numAutores) {
        StringBuilder sb = new StringBuilder();
        assert numAutores >= INITIAL_AUTHOR_COUNT;
        // crear autores
        for (int i = 0; i < numAutores; i++) {
            sb.append("Nombre ").append(i);
            String nombre = "Autor" + i;
            sb.setLength(0);
            sb.append("Apellido").append(i);
            sb.setLength(0);
            String apellidos = sb.toString();
            autores[i] = new Autor(nombre, apellidos);
            autoresCount++;
        }

        for (int i = 0; i < numLibros; i++) {
            String isbn = String.format("%013d", i);
            sb.append("Titulo").append(i);
            String titulo = sb.toString();
            sb.setLength(0);
            int anyo = Lib.aleatorio(1950, 2000);
            int mes = Lib.aleatorio(0, 11);
            int dia = Lib.aleatorio(1, 28);
            GregorianCalendar fechaPublicacion = new GregorianCalendar(anyo, mes, dia);
            // Libro.Genero[] generos= Libro.Genero.values();
            // Libro.Genero generos = generos[Lib.random(0,generos.length-1)];
            Genero genero = Genero.getRandom();

            int paginas = Lib.random(250, 800);
            Autor autor = autores[Lib.random(0, numAutores - 1)];
            libros[i] = new Libro(isbn, titulo, fechaPublicacion, genero, paginas, autor);
            librosCount++;
        }
    }

    public Libro masActual() {
        if (libros.length > 0) {
            Libro libroMasActual = libros[0];
            // Para comprobar que no salge los null en los arrays.
            for (int i = 1; i < librosCount; i++) {
                if (libros[i].getFecha().getTimeMillis() > libroMasActual.getFecha().getTimeMillis()) {
                    libroMasActual = libros[i];
                }
            }
            return libroMasActual;
        }
        return null;
    }

    public Libro masPagina() {
        if (libros.length > 0) {
            Libro libroMasPaginas = libros[0];
            // Para comprobar que no salge los null en los arrays.
            for (int i = 1; i < librosCount; i++) {
                if (libros[i].getPaginas() > libroMasPaginas.getNumPaginas()) {
                    libroMasPaginas = libros[i];
                }
            }
            return libroMasPaginas;
        }
        return null;
    }

    public int cantidadLibrosEscritos() {
        int cantidad = 0;

        if (libros.length > 0) {
            for (int i = 0; i < librosCount; i++) {
                if (libros[i].getAutor().getId() == autor.getId())
                    ;
            }

        }

    }

}
