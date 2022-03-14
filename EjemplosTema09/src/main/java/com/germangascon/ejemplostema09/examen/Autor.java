package com.germangascon.ejemplostema09.examen;

public class Autor {
    private static int ID = 0;
    private final int id;
    private final String nombre;
    private final String apellidos;

    public Autor(String nombre, String apellidos) {
        id = ++ID;
        this.nombre = nombre;
        this.apellidos = apellidos;
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
        return "Autor{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                '}';
    }
}
