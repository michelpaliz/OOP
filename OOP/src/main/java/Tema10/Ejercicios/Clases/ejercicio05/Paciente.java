package Tema10.Ejercicios.Clases.ejercicio05;

import java.util.GregorianCalendar;

public class Paciente {
    private static int NUM_PACIENTES = 0;

    private final int id;
    private final String nombre;
    private final GregorianCalendar fechaNacimiento;
    private final Genero genero;
    private final double altura;
    private final double peso;

    public Paciente(int id,String nombre, GregorianCalendar fechaNacimiento, Genero genero, double altura, double peso) {
        this.id =  ++NUM_PACIENTES;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.altura = altura;
        this.peso = peso;
    }

    public static int getNUM_PACIENTES() {
        return NUM_PACIENTES;
    }

    public static void setNUM_PACIENTES(int nUM_PACIENTES) {
        NUM_PACIENTES = nUM_PACIENTES;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public GregorianCalendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    public Genero getGenero() {
        return genero;
    }

    public double getAltura() {
        return altura;
    }

    public double getPeso() {
        return peso;
    }


    @Override
    public String toString() {
        return "Paciente [altura=" + altura + ", fechaNacimiento=" + fechaNacimiento + ", genero=" + genero + ", id="
                + id + ", nombre=" + nombre + ", peso=" + peso + "]";
    }



    
}
