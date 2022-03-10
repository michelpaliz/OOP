package Tema9.EjerciciosTm9.Ejercicio5;

public class Alumno {
    // creacion de atributos
    private final String nombre;
    private final double edad;
    private final double altura;

    public Alumno(String nombre, double edad, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.altura = altura;
    }

    public String getNombre() {
        return nombre;
    }

    public double getEdad() {
        return edad;
    }

    public double getAltura() {
        return altura;
    }

}
