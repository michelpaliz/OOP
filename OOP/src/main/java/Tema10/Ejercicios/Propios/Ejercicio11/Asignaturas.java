package Tema10.Ejercicios.Propios.Ejercicio11;

import java.util.HashMap;

public class Asignaturas {

    private int ID;
    private String nombre;
    private HashMap<Profesor, Asignaturas> profesores;

    public Asignaturas(int id, String nombre) {
        this.ID = id;
        this.nombre = nombre;
        this.profesores = new HashMap<>();
    }

}
