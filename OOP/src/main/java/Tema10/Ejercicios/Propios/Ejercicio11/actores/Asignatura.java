package Tema10.Ejercicios.Propios.Ejercicio11.actores;

import java.util.HashMap;

import Tema10.Ejercicios.Propios.Ejercicio11.Config.Config;

public class Asignatura {
    private int CONT = Config.STARTER_ID;
    private int ID;
    private String nombre;
    private HashMap<Profesor, Asignatura> profesores;

    public Asignatura(String nombre) {
        this.ID = ID++;
        this.nombre = nombre;
        this.profesores = new HashMap<>();
        
    }

}
