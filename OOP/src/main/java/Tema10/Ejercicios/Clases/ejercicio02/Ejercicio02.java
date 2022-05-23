package Tema10.Ejercicios.Clases.ejercicio02;

import Lib.Util;


public class Ejercicio02 {

    public Ejercicio02() {
        ArrayListEstadisticas estadisticas = new ArrayListEstadisticas(10);
        estadisticas.add(40.0);
        for(int i = 0; i < 10; i++) {
            estadisticas.add((double)(Util.r.nextInt()*10));

        }
        System.out.println(estadisticas);
    }

}
