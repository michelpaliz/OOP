package Tema09.examen;
import java.util.Calendar;
import java.util.GregorianCalendar;

import Tema09.utils.*;

public class ColeccionLibros {
    private static final int INITIAL_BOOK_COUNT = 10;
    private static final int INITIAL_AUTHOR_COUNT = 10;
    private static final int GROW_FACTOR = 2;

    private Libro[] libros;
    private int librosCount;
    private Autor[] autores;
    private int autoresCount;

    public ColeccionLibros() {
        this(INITIAL_BOOK_COUNT, INITIAL_AUTHOR_COUNT);
    }

    private ColeccionLibros(int numLibros, int numAutores) {
        libros = new Libro[numLibros];
        autores = new Autor[numAutores];
        if(MainExamen.DEBUG) {
            crearDatosPrueba(numLibros, numAutores);
            // Mostrar los datos de prueba
            for(int i = 0; i < librosCount; i++)
                System.out.println(libros[i]);
        }
    }

    private void crearDatosPrueba(int numLibros, int numAutores) {
        StringBuilder sb = new StringBuilder();
        /** Crear autores */
        assert numAutores >= INITIAL_AUTHOR_COUNT;
        for(int i = 0; i < numAutores; i++) {
            sb.append("Nombre ").append(i);
            String nombre = sb.toString();
            sb.setLength(0);
            sb.append("Apellido ").append(i);
            String apellidos = sb.toString();
            sb.setLength(0);
            autores[i] = new Autor(nombre, apellidos);
            autoresCount++;
        }

        sb.setLength(0);
        assert numLibros >= INITIAL_BOOK_COUNT;
        /** Crear libros */
        for(int i = 0; i < numLibros; i++) {
            String isbn = String.format("%013d", i);
            sb.append("Titulo").append(i);
            String titulo = sb.toString();
            sb.setLength(0);
            int anyo = Lib.random(1950, 2000);

            int mes = Lib.random(Calendar.JANUARY, Calendar.DECEMBER);
            int dia = Lib.random(1, 28);
            GregorianCalendar fechaPublicacion = new GregorianCalendar(anyo, mes, dia);
            Libro.Genero[] generos = Libro.Genero.values();
            Libro.Genero genero = generos[Lib.random(0, generos.length - 1)];
            int paginas = Lib.random(150, 800);
            Autor autor = autores[Lib.random(0, numAutores -1)];
            libros[i] = new Libro(isbn, titulo, fechaPublicacion, genero, paginas, autor);
            librosCount++;
        }
    }

    public Libro masActual() {
        if(librosCount > 0) {
            Libro libroMasActual = libros[0];
            for (int i = 1; i < librosCount; i++) {
                if (libros[i].getFechaPublicacion().getTimeInMillis() >
                        libroMasActual.getFechaPublicacion().getTimeInMillis()) {
                    libroMasActual = libros[i];
                }
            }
            return libroMasActual;
        }
        return null;
    }

    public Libro masPaginas() {
        if(librosCount > 0) {
            Libro libroMasPaginas = libros[0];
            for (int i = 1; i < librosCount; i++) {
                if (libros[i].getPaginas() >
                        libroMasPaginas.getPaginas()) {
                    libroMasPaginas = libros[i];
                }
            }
            return libroMasPaginas;
        }
        return null;
    }

    public Autor autorMasProlifico() {
        if(autoresCount > 0) {
            Autor autorMasProlifico = autores[0];
            int librosEscritosMaximo = cantidadLibrosEscritosPorAutor(autorMasProlifico);
            for (int i = 1; i < autoresCount; i++) {
                int librosAutorActual = cantidadLibrosEscritosPorAutor(autores[i]);
                if(librosAutorActual > librosEscritosMaximo) {
                    autorMasProlifico = autores[i];
                    librosEscritosMaximo = librosAutorActual;
                }
            }
            return autorMasProlifico;
        }
        return null;
    }

    public int cantidadLibrosEscritosPorAutor(Autor autor) {
        int cantidad = 0;
        for (int i = 0; i < librosCount; i++) {
            if (libros[i].getAutor().getId() == autor.getId()) {
                cantidad++;
            }
        }
        return cantidad;
    }

    public Libro[] buscar(Libro.Genero genero) {
        Libro[] resultado = null;
        int contador = 0;
        // Como hay que devolver un array primero debemos calcular el tamaño del array
        for(int i = 0; i < librosCount; i++) {
            if(libros[i].getGenero() == genero) {
                contador++;
            }
        }
        // Ya sabemos la cantidad de elementos que debe tener el array que tenemos que devolver
        if(contador > 0) {
            resultado = new Libro[contador];
            for(int i = 0; i < librosCount; i++) {
                if(libros[i].getGenero() == genero) {
                    resultado[--contador] = libros[i];
                }
            }
        }
        return resultado;
    }

    public Libro[] buscar(int idAutor) {
        Libro[] resultado = null;
        int contador = 0;
        // Como hay que devolver un array primero debemos calcular el tamaño del array
        for(int i = 0; i < librosCount; i++) {
            if(libros[i].getAutor().getId() == idAutor) {
                contador++;
            }
        }
        // Ya sabemos la cantidad de elementos que debe tener el array que tenemos que devolver
        if(contador > 0) {
            resultado = new Libro[contador];
            for(int i = 0; i < librosCount; i++) {
                if(libros[i].getAutor().getId() == idAutor) {
                    resultado[--contador] = libros[i];
                }
            }
        }
        return resultado;
    }

}
