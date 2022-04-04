package Tema10.Ejercicios.Propios.Ejercicio11.actores;

import java.util.HashMap;

import Tema10.Ejercicios.Propios.Ejercicio11.Config.Config;

public class Alumno {
    private int CONT = Config.STARTER_ID;
    private Grupo grupo;
    private int ID;
    private String nombre;
    private HashMap<Asignatura, Asignatura> asignaturas;

    public Alumno(String nombre, Grupo grupo) {
        this.ID = CONT++;
        this.nombre = nombre;
        this.grupo = grupo;
        this.asignaturas = new HashMap<>();

    }

    public int getCONT() {
        return CONT;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public int getID() {
        return ID;
    }

    public String getNombre() {
        return nombre;
    }

    public HashMap<Asignatura, Asignatura> getAsignaturas() {
        return asignaturas;
    }

}
