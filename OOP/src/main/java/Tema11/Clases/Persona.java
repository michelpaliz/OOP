package Tema11.Clases;

import java.util.GregorianCalendar;

public class Persona {
    private String nombre;
    private String apellidos;
    private int edad;
    private GregorianCalendar dob;

    public Persona(String nombre, String apellidos, int edad, GregorianCalendar dob) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.dob = dob;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public GregorianCalendar getDob() {
        return dob;
    }

    public void setDob(GregorianCalendar dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Persona{" +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", edad=" + edad +
                '}';
    }

}
