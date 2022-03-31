package Tema10.Explicacion.comparable;

public class Empleado implements Comparable<Empleado> {

    private final String dni;
    private final String nombre;
    private final int edad;

    public Empleado(String dni, String nombre, int edad) {
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public int compareTo(Empleado o) {
        if (getEdad() > o.getEdad()) {
            return 1;
        } else if (getEdad() < o.getEdad()) {
            return -1;
        } else {
            return 0;
        }
        // return this.getEdad() - o.getEdad();
    }
    @Override
    public String toString() {
        return "Empleado [dni=" + dni + ", edad=" + edad + ", nombre=" + nombre + "]";
    }


}
