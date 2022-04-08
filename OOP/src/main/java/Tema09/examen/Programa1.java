package Tema09.examen;

import java.util.Arrays;

public class Programa1 {
    public Programa1() {
        ColeccionLibros coleccionLibros = new ColeccionLibros();
        System.out.println();
        System.out.println("Libro más actual: ");
        System.out.println(coleccionLibros.masActual());

        System.out.println("Libro con más páginas: ");
        System.out.println(coleccionLibros.masPaginas());

        System.out.println("Autor más prolífico: ");
        System.out.println(coleccionLibros.autorMasProlifico());

        System.out.println("Libros del genero " + Libro.Genero.FICCION + ": ");
        System.out.println(Arrays.toString(coleccionLibros.buscar(Libro.Genero.FICCION)));

        int idAutor = 2;
        System.out.println("Libros del autor con id " + idAutor);
        System.out.println(Arrays.toString(coleccionLibros.buscar(idAutor)));

    }
}
