package Tema10.Ejercicios.Propios.Ejercicio11;

import java.util.HashMap;

public class Alumno {
    private int CONT =0;
    private Grupo grupo;
    private int ID;
    private String nombre;
    private HashMap<Asignaturas, Asignaturas>asignaturas;

    public Alumno(String nombre, Grupo grupo){
        this.ID = CONT++;
        this.nombre = nombre;
        this.grupo = grupo;
        this.asignaturas = new HashMap<>();
        
    }
    
}
