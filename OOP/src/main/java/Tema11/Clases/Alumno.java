package Tema11.Clases;

import java.util.GregorianCalendar;

public class Alumno extends Persona {

    private String dni;

    public Alumno(String dni, String nombre, String apellidos, int edad, GregorianCalendar dob) {
        super(nombre, apellidos, edad, dob);
        this.dni = dni;
    }

    public String getNia() {
        return dni;
    }

    public String toString() {
        return "Nombre: " + getNombre();
    }

    // @Override
    // public String getNombre(){
    // return "Alumno: " + getNombre(); esto no funciona
    // }

    @Override
    public String getNombre() {
        return "Alumno: " + super.getNombre();
    }

}
