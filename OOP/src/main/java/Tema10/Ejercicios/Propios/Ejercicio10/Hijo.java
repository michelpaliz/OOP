package Tema10.Ejercicios.Propios.Ejercicio10;

import Util.Control;

public class Hijo {
    private static final int INITIAL_SIZE = 10;
    private String nombre;
    private int edad;

    public Hijo(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Hijo getKey(Hijo hijo) {
        this.nombre = hijo.getNombre();
        return hijo;
    }

    /**
     * para crear un hijo
     * 
     * @param hijo
     * @return un hijo con los otros valores secundarios
     */
    public Hijo getValues(Hijo hijo) {
        this.edad = hijo.getEdad();
        return hijo;
    }

    @Override
    public String toString() {
        return "Hijo [edad=" + edad + ", nombre=" + nombre + "]";
    }

}
