package OtrosEjercicios.Campeonato;

//*Date
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
//*Faker
import com.github.javafaker.Faker;

import Util.Bombo;
// import Tema8.EjemplosTema8.Cajero.util.Bombo;
import Util.*;

public class Equipo {

    public static final int MAX_ENTRENADORES = 2;
    public static final int MIN_ENTRENADORES = 0;
    public static final int MAX_JUGADORES = 14;
    public static final int MIN_JUGADORES = 9;
    public static final int MAX_EQUIPOS = 9;
    public static final int MIN_EQUIPOS = 0;

    // *Atributos de la clase equipo
    private final long id;
    private final String nombre;
    private final String ciudad;
    private Jugador jugador;
    private Entrenador entrenador;

    // variables para la gestion de la base de datos de los equipos, esto no saldra
    // en el toString solo sirve para hacer controles
    private Entrenador[] entrenadores;
    private Jugador[] jugadores;
    private Equipo[] equipos;
    // Los atributos que hacen el resize de los arrays
    private int numEntrenadores = 0;
    private int numJugadores = 0;
    private int numEquipos = 0;

    // *Variables

    /**
     * CONSTRUCTOR PRINCIPAL
     * 
     * @param nombre
     * @param ciudad
     * @param entrenador
     * @param jugador
     */
    public Equipo(long id, String nombre, String ciudad, Entrenador entrenador, Jugador jugador) {
        this.id = id;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.entrenador = entrenador;
        this.jugador = jugador;
        this.entrenadores = new Entrenador[MAX_ENTRENADORES];
        this.jugadores = new Jugador[MAX_JUGADORES];
        this.equipos = new Equipo[MAX_EQUIPOS];
    }

    public Equipo() {
        this.id = 0;
        this.nombre = null;
        this.ciudad = null;
        this.entrenadores = new Entrenador[MAX_ENTRENADORES];
        this.jugadores = new Jugador[MAX_JUGADORES];
        this.equipos = new Equipo[MAX_EQUIPOS];
    }

    /**
     * Metodo dinamico para la creacion de datos aleatorios
     * 
     * @param numEquipos introducimos los datos que el usario desee generar para la
     *                   creacion de los equipos
     */
    public void generarDatosAleatorios() {

        generarEquipo();
        App.menu();

    }

    public void mostrarDatosPrueba() {
        for (int i = 0; i < equipos.length; i++) {
            System.out.println(equipos[i] + "\n");
        }
        Lib.pausa();
    }

    // +DE AQUI PARA ABAJO ES PARA LA CREACION DE LA BASE DE DATOS

    /**
     * Metodo generar equipos aleatorios con faker
     * 
     * @param numEquipos
     */

    public void generarEquipo() {
        System.out.println("Creacion de equipos");
        GregorianCalendar edad = new GregorianCalendar();
        GregorianCalendar edad1 = new GregorianCalendar();
        Faker faker = new Faker(new Locale("es"));
        Bombo bomboEntrenador = new Bombo(MAX_ENTRENADORES, MIN_ENTRENADORES);
        Bombo bomboJugadores = new Bombo(MAX_JUGADORES, MIN_ENTRENADORES);
        Bombo bomboEquipos = new Bombo(MAX_EQUIPOS, MIN_EQUIPOS);

        for (int i = 0; i < entrenadores.length; i++) {
            long id = bomboEntrenador.extraerBola();// va extraer 15 entrenadores del bombo
            String nombre = faker.name().firstName();
            String apellido = faker.name().lastName();
            Date edadEntrenadores = faker.date().birthday(40, 65);
            edad1.setTime(edadEntrenadores);
            entrenadores[i] = new Entrenador(id, nombre, apellido, edad1); // esto printara la clase con el toString
            numEntrenadores++;
        }

        for (int i = 0; i < jugadores.length; i++) {
            long id = bomboJugadores.extraerBola();
            String nombre = faker.name().firstName();
            String apellido = faker.name().lastName();
            Date edadJugadores = faker.date().birthday(18, 30);
            edad.setTime(edadJugadores);
            Posicion posicion = Posicion.getRandom();
            jugadores[i] = new Jugador(id, nombre, apellido, edad, posicion);
            numJugadores++;
        }

        for (int i = 0; i < equipos.length; i++) {
            // Datos de para llenar el constructor de equipos
            long id = bomboEquipos.extraerBola();
            String nombre = faker.team().name();
            String ciudad = faker.country().capital();
            // Samos los objetos de lo arrays de entrenador y jugador y se lo asignamos a
            // otras referencias que apuntaran a los punteros de los objetos
            entrenador = entrenadores[Lib.random(0, numEntrenadores - 1)];
            jugador = jugadores[Lib.random(0, numJugadores - 1)];
            equipos[i] = new Equipo(id, nombre, ciudad, entrenador, jugador);
            numEquipos++;
        }

    }

    @Override
    public String toString() {
        return "Equipo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", jugador=" + jugador +
                ", entrenador=" + entrenador +
                '}';
    }
}
