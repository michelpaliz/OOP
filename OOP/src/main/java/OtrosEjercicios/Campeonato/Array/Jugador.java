package OtrosEjercicios.Campeonato.Array;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Jugador {
    // creacion de atributos
    private final long id;
    private final String nombre;
    private final String apellido;
    private final GregorianCalendar edad;
    private Posicion posicion;

    public Jugador(long id, String nombre, String apellido, GregorianCalendar edad, Posicion posicion) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.posicion = posicion;
    }

    public Jugador(Jugador j) {
        this.id = j.id;
        this.nombre =j.nombre;
        this.apellido = j.apellido;
        this.edad = j.edad;
        this.posicion = j.posicion;
    }

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    public int getEdad() {
        int anyoNacimiento = edad.get(Calendar.YEAR);
        int mesNacimiento = edad.get(Calendar.MONTH) + 1; //
        int diaNacimiento = edad.get(Calendar.DAY_OF_MONTH);

        GregorianCalendar fecha = new GregorianCalendar();
        int anyoActual = fecha.get(Calendar.YEAR);
        int mesActual = fecha.get(Calendar.MONTH) + 1;
        int diaActual = fecha.get(Calendar.DAY_OF_MONTH);

        int edad = anyoActual - anyoNacimiento;
        if (mesActual < mesNacimiento) {
            edad--;
        } else if (mesActual == mesNacimiento) {
            if (diaActual < diaNacimiento) {
                edad--;
            }
        }
        return edad;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return "Jugador{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + getEdad() +
                ", posicion=" + posicion +
                '}';
    }
}
