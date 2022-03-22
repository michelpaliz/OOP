package Tema10.Ejercicios.ejercicio02;

import Util.Lib;


public class Ejercicio02 {

    public Ejercicio02() {
        ArrayListEstadisticas estadisticas = new ArrayListEstadisticas();
        estadisticas.add(40.0);
        for(int i = 0; i < 10; i++) {
            estadisticas.add((double)(Lib.r.nextInt()*10));

        }
        System.out.println(estadisticas);
    }

}
