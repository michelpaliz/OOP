package EjerciciosTema8.Ejercicio7;

import java.util.GregorianCalendar;

public class Paciente {
    //Creacion de atributos
    private  int  sip;
    private String nombre;
    private Genero genero;
    private GregorianCalendar edad;
    private GregorianCalendar fechaEntrada;
    private String sintomalogia;

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




}
