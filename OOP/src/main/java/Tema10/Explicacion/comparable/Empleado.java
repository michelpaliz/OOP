package Tema10.Explicacion.comparable;

import java.util.Comparator;

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


    static class ComparatorPorNombre implements Comparator<Empleado>{

        @Override
        public int compare(Empleado o1, Empleado o2) {
            return o1.getNombre().compareTo(o2.getNombre());
        }

    }

    static class ComparatorPorDNI implements Comparator<Empleado>{

        @Override
        public int compare(Empleado o1, Empleado o2) {
            return o1.getDni().compareTo(o2.getDni());
        }

    }




}
