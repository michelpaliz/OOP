package EjerciciosTema8.Ejercicio7;

import java.util.GregorianCalendar;

public class Pacientes {
    //Creacion de atributos
    private long sip;
    private String nombre;
    private Genero genero;
    private GregorianCalendar edad;
    private GregorianCalendar fechaEntrada;
    private String sintomalogia;

    public long getSip() {
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




}
