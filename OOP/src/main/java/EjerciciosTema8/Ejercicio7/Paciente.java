package EjerciciosTema8.Ejercicio7;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Paciente {
    // Creacion de atributos
    private final int sip;
    private final String nombre;
    private final Genero genero;
    private final GregorianCalendar edad;
    private final GregorianCalendar fechaEntrada;
    private final String sintomalogia;

    public Paciente(int sip, String nombre, Genero genero, GregorianCalendar edad, GregorianCalendar fechaEntrada,
            String sintomalogia) {
        this.sip = sip;
        this.nombre = nombre;
        this.genero = genero;
        this.edad = edad;
        this.fechaEntrada = fechaEntrada;
        this.sintomalogia = sintomalogia;
    }

    public int getSip() {
        return sip;
    }

    public String getNombre() {
        return nombre;
    }

    public Genero getGenero() {
        return genero;
    }

    public GregorianCalendar getEdad() {
        return edad;
    }

    public GregorianCalendar getFechaEntrada() {
        return fechaEntrada;
    }

    public String getSintomalogia() {
        return sintomalogia;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");
        return "Paciente{" +
                "sip=" + sip +
                ", nombre='" + nombre + '\'' +
                ", genero=" + genero +
                ", edad=" + sdf.format(edad.getTime()) +
                ", fechaEntrada=" + sdf.format(fechaEntrada.getTime()) +
                ", sintomalogia='" + sintomalogia + '\'' +
                '}';
    }
}