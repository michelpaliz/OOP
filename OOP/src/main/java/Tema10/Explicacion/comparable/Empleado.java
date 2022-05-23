package Tema10.Explicacion.comparable;

import java.util.Comparator;

import Tema10.Explicacion.ForEach.MyRandom;

public class Empleado implements Comparable<Empleado>, Cloneable {

    private final String dni;
    private final String nombre;
    private final int edad;
    private Direccion direccion;

    public Empleado(String dni, String nombre, int edad, String calle, String ciudad, int codigoPostal) {
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
        this.direccion = new Direccion(calle, ciudad, codigoPostal);
    }

    // constructor de copia
    public Empleado(Empleado e) {
        this(e.dni, e.nombre, e.edad, e.direccion.getCalle(), e.direccion.getCiudad(), e.direccion.getCodigoPostal());
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

    static class ComparatorPorNombre implements Comparator<Empleado> {

        @Override
        public int compare(Empleado o1, Empleado o2) {
            return o1.getNombre().compareTo(o2.getNombre());
        }

    }

    static class ComparatorPorDNI implements Comparator<Empleado> {

        @Override
        public int compare(Empleado o1, Empleado o2) {
            return o1.getDni().compareTo(o2.getDni());
        }

    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Empleado e = (Empleado) super.clone();
        e.direccion = (Direccion) e.direccion.clone();
        return e;

    }

}
