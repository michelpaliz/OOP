package OtrosEjercicios.Campeonato.Array;

import java.util.Arrays;
//*Date
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

//*Faker
import com.github.javafaker.Faker;

import Lib.*;

public class Equipo {

    // variables constantes
    public static final int MAX_ENTRENADORES = 2;
    public static final int MIN_ENTRENADORES = 1;
    public static final int MAX_JUGADORES = 50;
    public static final int MIN_JUGADORES = 1;
    public static final int MAX_EQUIPOS = 5;
    public static final int MIN_EQUIPOS = 1;

    // *Atributos de la clase equipo
    private final long id;
    private final nomEquipo nombre;
    private final String ciudad;
    private Jugador[] jugador;
    private Entrenador entrenador;

    // variables para la gestion de la base de datos de los equipos, esto no saldra
    // en el toString solo sirve para hacer controles
    private Entrenador[] entrenadores;
    private Jugador[] jugadores;
    private Equipo[] equipos;
    // Los atributos que hacen el resize de los arrays
    private int numEntrenadores = 0;
    private int numJugadores = 0;
    // private int numEquipos = 0;

    /**
     * CONSTRUCTOR PRINCIPAL
     * 
     * @param nombre
     * @param ciudad
     * @param entrenador
     * @param jugador
     */
    public Equipo(long id, nomEquipo nombre, String ciudad, Entrenador entrenador, Jugador[] jugador) {
        this.id = id;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.entrenador = entrenador;
        this.jugador = jugador;
        // INITIZAL_SIZE para cada array
        this.entrenadores = new Entrenador[MAX_ENTRENADORES];
        this.jugadores = new Jugador[MAX_JUGADORES / MAX_EQUIPOS];
        this.equipos = new Equipo[MAX_EQUIPOS];
    }

    // Este constructor es esencial para la creacion de objetos sin parametros
    public Equipo() {
        this.id = 0;
        this.nombre = null;
        this.ciudad = null;
        this.entrenadores = new Entrenador[MAX_ENTRENADORES];
        this.jugadores = new Jugador[MAX_JUGADORES / MAX_EQUIPOS];
        this.equipos = new Equipo[MAX_EQUIPOS];
        // this.jugadores1 = new Jugador[jugadores.length / equipos.length];
    }

    /**
     * Metodo dinamico para la creacion de datos aleatorios
     * 
     * @param numEquipos introducimos los datos que el usario desee generar para la
     *                   creacion de los equipos
     */
    public void generarDatosAleatorios() {

        generarEquipo();
        System.out.println("Los equipos han sido creados exitosamente");

    }

    public void mostrarDatosPrueba() {
        for (int i = 0; i < equipos.length; i++) {
            System.out.println(equipos[i] + "\n");
        }
        Util.pause();
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
        Bombo bomboEntrenador = new Bombo(MAX_EQUIPOS, MIN_EQUIPOS);
        Bombo bomboJugadores = new Bombo(MAX_JUGADORES, MIN_JUGADORES);
        Bombo bomboEquipos = new Bombo(MAX_EQUIPOS, MIN_EQUIPOS);

        for (int i = 0; i < entrenadores.length; i++) {
            long id = bomboEntrenador.extraerBola();// va extraer 15 entrenadores del bombo
            String nombre = faker.name().firstName();
            String apellido = faker.name().lastName();
            Date edadEntrenadores = faker.date().birthday(40, 65);
            edad1.setTime(edadEntrenadores); // los set son peligrosos por esto mismo cambia
            // toda mi base de datos con este mismo valor para todos

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
            // String nombre = faker.team().name();
            nomEquipo nombre = nomEquipo.getRandom();
            String ciudad = faker.country().capital();
            // Samos los objetos de lo arrays de entrenador y jugador y se lo asignamos a
            // otras referencias que apuntaran a los punteros de los objetos
            entrenador = entrenadores[Util.random(0, numEntrenadores - 1)];
            for (int j = 0; j < jugadores.length; j++) {
                jugadores[j] = jugadores[Util.random(0, numJugadores - 1)];
            }
            equipos[i] = new Equipo(id, nombre, ciudad, entrenador, jugadores);
            // numEquipos++;
        }

    }

    /**
     * 
     * @param ref
     * @return
     */

    public int buscarJugador(Jugador jugador) {
        for (int i = 0; i < jugadores.length; i++) {
            if (jugadores[i].getId() == jugador.getId()) {
                return i;
            }
        }
        return -1;
    }

    public Jugador buscarPorID(Jugador jugador) {
        int pos = buscarJugador(jugador);
        return pos < 0 ? null : jugadores[pos];
    }

    public Jugador[] nuevoEspacio(Jugador jugador) {

        // si no esta vacio
        if (buscarPorID(jugador) != null) {
            return null;
        }
        // Si es null osea que no existe esa id pues creamos el jugador
        if (numJugadores == jugadores.length) {
            // creamos un nuevo array el doble del viejo
            Jugador[] jugadoresAmpliado = new Jugador[(int) (numJugadores * 2)];
            for (int i = 0; i < jugadores.length; i++) {
                jugadoresAmpliado[i] = jugadores[i];
            }
            jugadores = jugadoresAmpliado;
        }

        Jugador nuevoJugador = new Jugador(jugador);
        jugadores[numJugadores] = nuevoJugador;
        numJugadores++;
        return jugadores;
    }

    @Override
    public String toString() {
        return "Equipo [ Equipo = " + nombre + " ciudad=" + ciudad + ", entrenador=" + entrenador + ", id=" + id
                + ", jugadores="
                + Arrays.toString(jugador) + "]";
    }

    // Anyadimos un nuevo jugador al equipo

}
