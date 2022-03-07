package Examen;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.GregorianCalendar;
import java.util.concurrent.ThreadLocalRandom;

import com.github.javafaker.Faker;

import Util.Bombo;
import Util.Lib;

public class App {

    // Variables Globales
    public static Faker faker = new Faker();
    private Libro libro[];
    private Autor autor[];
    int numLibro;
    int numAutor;

    public void randomAutor(int cantidad) {
        Bombo bombo = new Bombo(cantidad, 1);
        for (int i = 0; i < cantidad; i++) {
            int autoIdentificador = bombo.extraerBola();
            String nombre = faker.artist().name();
            String apellidos = faker.name().lastName();
            autor[i] = new Autor(nombre, apellidos, autoIdentificador);
            nuevoEspacio(nombre, apellidos, autoIdentificador);
            numAutor++;

        }

    }

    public Autor[] nuevoEspacio(String nombre, String apellidos, int autoIdentificador) {

        // if (buscarAutorPorRef(autoIdentificador)) != null) {
        // return null;
        // }
        if (numAutor == autor.length) {
            // creamos un nuevo array el doble del viejo
            Autor[] autorAmpliado = new Autor[(int) (numAutor * Config.FACTOR_CRECIMIENTO)];
            for (int i = 0; i < autor.length; i++) {
                autorAmpliado[i] = autor[i];
            }
            autor = autorAmpliado;
        }

        Autor autorNuevo = new Autor(nombre, apellidos, autoIdentificador);
        autor[numAutor] = autorNuevo;
        numAutor++;
        return autor;

    }

    public void crearDatosRandom(int cantidad) {
        Bombo bombo = new Bombo(cantidad, 1);
        libro = null;

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

            libro[i] = new Libro(isb, titulo, fechaEntrada, genero, numPaginas, autor);
            System.out.println(libro);
            // nuevoEspacio(isb, titulo, fechaEntrada, genero, numPaginas, autor);

        }

    }

    public Libro[] nuevoEspacio(long isb, String titulo, GregorianCalendar fechaEntrada, Genero genero,
            int numeroPaginas, Autor[] autor) {

        // if (buscarAutorPorRef(autoIdentificador)) != null) {
        // return null;
        // }
        if (numAutor == libro.length) {
            // creamos un nuevo array el doble del viejo
            Libro[] libroAmpliado = new Libro[(int) (numLibro * Config.FACTOR_CRECIMIENTO)];
            for (int i = 0; i < libro.length; i++) {
                libroAmpliado[i] = libro[i];
            }
            libro = libroAmpliado;
        }

        Libro libroNuevo = new Libro(isb, titulo, fechaEntrada, genero, numeroPaginas, autor);
        libro[numLibro] = libroNuevo;
        numLibro++;
        return libro;

    }

    // *ELIMINAR BICICLETEA (OPCION NUMERO 2)

    /**
     * 
     * @param ref
     * @return un numero positivo o si es negativo que significa que el indice de la
     *         referencia no existe en el array
     */
    public int buscarAutor(int ref) {
        for (int i = 0; i < numAutor; i++) {
            if (autor[i].getAutoIdentificador() == ref) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 
     * @param ref
     * @return la posicion o indice de la refencia introducida anteriormente
     */

    // public int buscarAutorPorRef(int ref) {
    // int pos = buscarAutor(ref);
    // return pos < 0 ? null : autor[pos];
    // }

    public boolean eliminarBicicleta(int ref) {
        int pos = buscarAutor(ref);
        if (pos < 0) {
            return false;
        }
        autor[pos] = autor[numAutor - 1];
        autor[numAutor - 1] = null;
        numAutor--;
        Lib.pausa();
        return true;

    }

    public App() {

        crearDatosRandom(10);

    }

}
