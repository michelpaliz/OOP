package OtrosEjercicios.Campeonato;

//*Date
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
//*Faker
import com.github.javafaker.Faker;

public class Equipo {

    // *Atributos de la clase equipo
    private final String nombre;
    private final String ciudad;
    private Entrenador[] entrenadores;
    private Jugador[] jugadores;
    private int numJugadores;
    private int numEntrenadores;

    // *Variables
    GregorianCalendar edad = new GregorianCalendar();
    // Valores para la cola
    private int lastId = 10103001;

    public Equipo(String nombre, String ciudad, int maxEntrenadores, int maxJugadores) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.entrenadores = new Entrenador[maxEntrenadores];
        this.jugadores = new Jugador[maxJugadores];
        this.numEntrenadores = 0;
        this.numJugadores = 0;
    }

    public void FakerDates() {
        System.out.println("Creacion de equipos");
        // Clase Entrenador
        Faker faker = new Faker(new Locale("es"));

        for (int i = 0; i < numEntrenadores; i++) {
            long id = ++lastId;
            String nombre = faker.name().firstName();
            String apellido = faker.name().lastName();
            Date edadEntrenador = faker.date().birthday(18, 90);

            edad.setTime(edadEntrenador);

            entrenadores[i] = new Entrenador(id, nombre, apellido, edad);
            System.out.println(entrenadores[i]);
            numEntrenadores++;

        }

    }

}
