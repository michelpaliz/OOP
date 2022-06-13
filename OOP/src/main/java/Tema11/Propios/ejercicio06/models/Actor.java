package Tema11.Propios.ejercicio06.models;

public class Actor {

    private static int N_ACTORES = 0;
    private final int id;
    private final String nombre;
    private final String apellidos;

    public Actor(int id, String nombre, String apellidos) {
        this.id = ++N_ACTORES;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public static int getN_ACTORES() {
        return N_ACTORES;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    @Override
    public String toString() {
        return "Actor [apellidos=" + apellidos + ", id=" + id + ", nombre=" + nombre + "]\n";
    }

}
