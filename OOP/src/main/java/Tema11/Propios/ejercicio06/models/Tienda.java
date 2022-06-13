package Tema11.Propios.ejercicio06.models;

import java.util.List;

import com.github.javafaker.Faker;

import Lib.Control;
import Tema11.Propios.ejercicio06.numeric.Formato;


public class Tienda {
    private static final int MAX_PELICULAS = 10;
    private static final int MAX_VIDEOJUEGOS = 10;
    private static final int MAX_MULTIMEDIA = 20;
    private int userInt;
    private Faker fk = new Faker();
    private List<Pelicula> peliculas;
    private List<Videojuego> videojuegos;
    private Multimedia m;
    private Pelicula p;
    private Videojuego v;
    private Socio s;

    public Tienda() {

    }

    public void menu() {
        String tittle = "MENU";
        String sentence[] = { "Altas", "Alquilar", "Devolver Multimedia", "Listados" };
        userInt = Control.menuGenerator(tittle, sentence);
        switch (userInt) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
        }
    }

    public void gnRandom() {

        Formato formato = Formato.BLUE_RAY;
        for (int i = 0; i < MAX_MULTIMEDIA; i++) {

            String title = "Multimedia" + fk.funnyName().name();
            String name = "Titulo" + fk.animal().name();
            int anyo = fk.number().numberBetween(2000,2022);
            formato  = Formato.getRandom();
            for (int i = 0; i < MAX_PELICULAS; i++) {
                double duration = fk.number().randomDouble(2, 0, 10);
                String actor = fk.name().firstName();
                String actriz = fk.name().firstName();
                p = new Pelicula(duration, actor, actriz);
                m = new Multimedia(title,name,formato,anyo);
            }

        }

    }

    public void altaNuevaPelicula() {

        // p = new Pelicula(duration, autor, actriz);
    }

    public void altaNuevoVideojuego() {

    }

    public void altaNuevoSocio() {

    }

}
