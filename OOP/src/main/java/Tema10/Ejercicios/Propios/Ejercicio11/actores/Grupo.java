package Tema10.Ejercicios.Propios.Ejercicio11.actores;

import java.util.HashMap;

import Tema10.Ejercicios.Propios.Ejercicio11.Config.Config;

public class Grupo {
    private int CONT = Config.STARTER_ID;
    private int ID;
    private String nombre;
    private Aula aulaRef;

    public Grupo(String nombre, Aula aulaRef) {
        this.ID = CONT++;
        this.nombre = nombre;
        this.aulaRef = aulaRef;
    }

    

}
