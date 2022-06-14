package Tema11.Propios.ejercicio06.models;

import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import com.github.javafaker.Faker;
import Tema11.Propios.ejercicio06.numeric.Formato;
import Tema11.Propios.ejercicio06.numeric.Plataforma;
import Lib.Util;

public class VideoClub {
    /** Constantes de configuración */
    public static final int EDAD_MINIMA = 12;
    /** Atributos */
    private final ArrayList<Multimedia> multimedia;
    private final ArrayList<Autor> autores;
    private final ArrayList<Actor> actores;
    private final ArrayList<Socio> socios;

    /**
     * Crea un Videoclub inicializando las estructuras de datos utilizadas por la
     * clase
     */
    public VideoClub() {
        autores = new ArrayList<>();
        multimedia = new ArrayList<>();
        socios = new ArrayList<>();
        actores = new ArrayList<>();
    }

    /**
     * Crea un Videoclub con nPeliculas, nVideojuegos y nSocios aleatorios.
     * Este método solo será utilizado durante la fase de pruebas.
     * TODO: Marcar como privado cuando finalice la fase de pruebas
     * 
     * @param nPeliculas
     * @param nVideojuegos
     * @param nSocios
     */
    public VideoClub(int nPeliculas, int nVideojuegos, int nSocios) {
        this();
        generarAutoresAleatorios(nPeliculas);
        generarActoresAleatorios(nPeliculas);
        generarPeliculasAleatorias(nPeliculas);
        generarVideojuegosAleatorios(nVideojuegos);
        generarSociosAleatorios(nSocios);
        generarAlquileresAleatorios();
    }

    /**
     * Genera Alquileres aleatorios utilizando la librería JavaFaker
     */
    private void generarAlquileresAleatorios() {
        Faker faker = new Faker(new Locale("es"));
        for (int i = 0; i < multimedia.size(); i++) {
            GregorianCalendar fechaAlquiler = new GregorianCalendar();
            Date dateAlquiler = faker.date().past(365, 1, TimeUnit.DAYS);
            fechaAlquiler.setTime(dateAlquiler);

            multimedia.get(i).alquilar(socios.get(Util.random(0, socios.size() - 1)), fechaAlquiler);

            /**
             * Asumimos que el 70% de los alquileres se han devuelto.
             * 1, 10 y 3 podrían ser constantes de configuración
             */

            if (Util.random(1, 10) > 3) {
                GregorianCalendar fechaDevolucion = new GregorianCalendar();
                fechaDevolucion.setTime(dateAlquiler);
                /**
                 * Asumimos que los alquileres se devuelven entre 1 y 6 días después de su
                 * Alquiler
                 * 1 y 6 podrían ser constantes de configuración
                 */
                fechaDevolucion.add(Calendar.DATE, Util.random(1, 6));

                multimedia.get(i).devolver(fechaDevolucion);
            }
        }
    }

    /**
     * Genera Socios aleatorios utilizando la librería JavaFaker
     */
    private void generarSociosAleatorios(int nSocios) {
        Faker faker = new Faker(new Locale("es"));

        for (int i = 0; i < nSocios; i++) {
            /** 14 y 50 podrían ser constantes de configuración */
            socios.add(new Socio(faker.name().firstName(), Util.random(14, 50),
                    faker.address().city()));
        }
    }

    /**
     * Genera Autores aleatorios utilizando la librería JavaFaker
     */
    private void generarAutoresAleatorios(int nAutores) {
        Faker faker = new Faker(new Locale("es"));
        for (int i = 0; i < nAutores; i++) {
            autores.add(new Autor(faker.name().firstName(), faker.name().lastName()));
        }
    }

    /**
     * Genera Actores aleatorios utilizando la librería JavaFaker
     */
    private void generarActoresAleatorios(int nActores) {
        Faker faker = new Faker(new Locale("es"));
        for (int i = 0; i < nActores; i++) {
            actores.add(new Actor(faker.name().firstName(), faker.name().lastName()));
        }
    }

    /**
     * Genera Peliculas aleatorias utilizando la librería JavaFaker
     */
    private void generarPeliculasAleatorias(int nPeliculas) {
        Faker faker = new Faker(new Locale("es"));
        for (int i = 0; i < nPeliculas; i++) {
            Pelicula pelicula = new Pelicula(faker.funnyName().name(),
                    autores.get(Util.random(0, autores.size() - 1)),
                    Formato.getRandom(),
                    Util.random(1990, 2019), // Podrían ser constantes de configuración
                    Util.random(90, 130), // Podrían ser constantes de configuración
                    actores.get(Util.random(0, actores.size() / 2)),
                    actores.get(Util.random((actores.size() / 2) + 1, actores.size() - 1)));
            multimedia.add(pelicula);
        }
    }

    /**
     * Genera Videojuegos aleatorios utilizando la librería JavaFaker
     */
    private void generarVideojuegosAleatorios(int nVideojuegos) {
        Faker faker = new Faker(new Locale("es"));
        for (int i = 0; i < nVideojuegos; i++) {
            Videojuego videojuego = new Videojuego(faker.funnyName().name(),
                    autores.get(Util.random(0, autores.size() - 1)),
                    Formato.getRandom(),
                    Util.random(1990, 2019), // Podrían ser constantes de configuración
                    Plataforma.values()[Util.random(0, Plataforma.values().length - 1)]);
            multimedia.add(videojuego);
        }
    }

    /**
     * Crea una Pelicula y la añade a la colección de Peliculas del VideoClub
     * 
     * @param titulo
     * @param autor
     * @param formato
     * @param anyo
     * @param duracion
     * @param actorPrincipal
     * @param actrizPrincipal
     */
    public void nuevaPelicula(String titulo, Autor autor, Formato formato, int anyo, int duracion, Actor actorPrincipal,
            Actor actrizPrincipal) {
        multimedia.add(new Pelicula(titulo, autor, formato, anyo, duracion, actorPrincipal, actrizPrincipal));
    }

    /**
     * Crea un Videojuego y lo añade a la colección de Videojuegos del VideoClub
     * 
     * @param titulo
     * @param autor
     * @param formato
     * @param anyo
     * @param plataforma
     */
    public void nuevoVideojuego(String titulo, Autor autor, Formato formato, int anyo, Plataforma plataforma) {
        multimedia.add(new Videojuego(titulo, autor, formato, anyo, plataforma));
    }

    /**
     * Crea un Socio y lo añade al listado de Socios del VideoClub
     * 
     * @param nif
     * @param nombre
     * @param edad
     * @param poblacion
     */
    public void nuevoSocio(String nif, String nombre, int edad, String poblacion) {
        socios.add(new Socio(nif, nombre, edad, poblacion));
    }

    public ArrayList<Multimedia> getMultimedia() {
        return multimedia;
    }

    public ArrayList<Socio> getSocios() {
        return socios;
    }

    /**
     * Busca un Socio por nif
     * 
     * @param nif
     * @return El Socio buscado si se ha encontrado, null en caso contrario
     */
    public Socio buscarSocio(String nif) {
        for (Socio socio : socios) {
            if (socio.getNif().equalsIgnoreCase(nif)) {
                return socio;
            }
        }
        return null;
    }

    /**
     * Busca un Multimedia por codigo
     * 
     * @param codigo Código del Multimedia
     * @return El Multimedia buscado, null en caso contrario
     */
    public Multimedia buscarMultimedia(int codigo) {
        for (Multimedia m : multimedia) {
            if (m.getId() == codigo) {
                return m;
            }
        }
        return null;
    }

    public ArrayList<Actor> getActores() {
        return actores;
    }

    public ArrayList<Autor> getAutores() {
        return autores;
    }

    /**
     * Busca un Autor por su id
     * 
     * @param idAutor Id del Autor
     * @return El Autor buscado, null en caso contrario.
     */
    public Autor buscarAutor(int idAutor) {
        for (Autor autor : autores) {
            if (autor.getId() == idAutor) {
                return autor;
            }
        }
        return null;
    }

    /**
     * Busca un Actor por su id
     * 
     * @param idActor Id del Actor
     * @return El Actor buscado, null en caso contrario.
     */
    public Actor buscarActor(int idActor) {
        for (Actor actor : actores) {
            if (actor.getId() == idActor) {
                return actor;
            }
        }
        return null;
    }

}
