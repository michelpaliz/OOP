package Tema8.EjemplosTema8.ejemplos;

public class Persona {
    String dni;
    String nombre;
    String apellidos;
    int edad;
    Genero genero;



    public Persona(int edad, String nombre) {
        this.edad = edad;
        this.nombre = nombre;
    }

    public Persona(String dni, String nombre, String apellidos, int edad, Genero genero) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", edad=" + edad +
                ", genero=" + genero +
                '}';
    }
}
