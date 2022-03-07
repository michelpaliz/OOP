package Examen;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

import com.github.javafaker.Faker;

import Util.Bombo;
import Util.Lib;

public class App {

    // Variables Globales
    public static Faker faker = new Faker(new Locale("es"));
    private Libro libro[];
    private Autor autor;
    int numLibro;
    int numAutor;

    public void crearDatosRandom(int cantidad) {
        Bombo bombo = new Bombo(cantidad, 1);
        Bombo bombo1 = new Bombo(cantidad, 1);
        System.out.println("Creacion de datos de la clase libro");

        for (int i = 0; i < cantidad; i++) {
            long isb = bombo.extraerBola();
            String titulo = faker.name().title();
            long minDay = LocalDate.of(2002, 1, 1).toEpochDay();
            long maxDay = LocalDate.of(2015, 12, 31).toEpochDay();
            // Conversion LocalDate to GregorianCalendar
            long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
            LocalDate randomDate = LocalDate.ofEpochDay(randomDay);
            GregorianCalendar fechaEntrada = GregorianCalendar.from(randomDate.atStartOfDay(ZoneId.systemDefault()));
            Genero genero = Genero.getRandom();
            int numPaginas = Lib.aleatorio(150, 500);
            // Autor
            int autoIdentificador = bombo1.extraerBola();
            String nombre = faker.artist().name();
            String apellidos = faker.name().lastName();

            autor = new Autor(nombre, apellidos, autoIdentificador);
            libro[i] = new Libro(isb, titulo, fechaEntrada, genero, numPaginas, autor);
            numLibro++;
            System.out.println(libro[i]);

        }

    }

    // Inicializamos el array

    public void mostrarStockPrueba(int minValue) {
        System.out.println("GENERACION DE STOCK RANDOM");
        libro = new Libro[minValue];
        numLibro = 0;
        // autor = new Autor[minValue];
        // numAutor = 0;
        if (true) {
            crearDatosRandom(minValue / 2);
        }

    }

    public App() {

        mostrarStockPrueba(10);

    }

}
