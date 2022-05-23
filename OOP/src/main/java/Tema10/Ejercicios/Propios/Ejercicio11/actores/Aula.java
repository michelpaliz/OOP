package Tema10.Ejercicios.Propios.Ejercicio11.actores;

import Tema10.Ejercicios.Propios.Ejercicio11.Config.Config;

public class Aula {
    private int CONT = Config.STARTER_ID;
    private int ID;
    private double m2;

    public Aula(double m2) {
        this.ID = CONT++;
        this.m2 = m2;
    }

}
