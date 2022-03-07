package OtrosEjercicios.Campeonato;

//*Date
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;
//*Faker
import com.github.javafaker.Faker;

public class Equipo {

    // *Atributos de la clase equipo
    private final String nombre;
    private final String ciudad;
    private int numJugadores;
    private int numEntrenadores;
    private Entrenador[] entrenadores;
    private Jugador[] jugadores;
    // Valores para la cola
    private int lastId = 10103001;

    // *Variables

    GregorianCalendar edad = new GregorianCalendar();

    public Equipo(String nombre, String ciudad, Entrenador[] entrenadores, Jugador[] jugadores, Entrenador[] entrenador,
            int lastId) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.entrenadores = entrenadores;
        this.jugadores = jugadores;
    }

    public void FakerDates() {
        System.out.println("Creacion de equipos");
        // Clase Entrenador
        Faker faker = new Faker(new Locale("es"));

        for (int i = 0; i < numEntrenadore; i++) {
            long id = ++lastId;
            String nombre = faker.name().firstName();
            String apellido = faker.name().lastName();
            Date edadEntrenador = faker.date().birthday(18, 90);

            edad.setTime(edadEntrenador);

            entrenador[i] = new Entrenador(id, nombre, apellido, edad);
            System.out.println(entrenador[i]);
            numEntrenadore++;

        }

    }

    public Equipo() {

    }

}
