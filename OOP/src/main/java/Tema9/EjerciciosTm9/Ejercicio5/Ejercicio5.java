package Tema9.EjerciciosTm9.Ejercicio5;

import Util.Lib;

public class Ejercicio5 {

    public void Ejercicio5() {
        String mgInt = "Introduce un numero";
        String mgStr = "Introduce el nombre del alumno";
        String mgDouble = "Introduce la altura del alumno";
        Alumno alumno1 = new Alumno(Lib.validarStr0(mgStr, 1, 10), Lib.validarInt(mgInt, 1, 100),
                Lib.validarDouble(mgDouble));

        Alumno alumno2 = new Alumno(Lib.validarStr0(mgStr, 1, 10), Lib.validarInt(mgInt, 1, 100),
                Lib.validarDouble(mgDouble));
        System.out.println("Sacamos el alumno mayor");
        System.out.println(compararObj(alumno1, alumno2));

    }

    public Alumno compararObj(Alumno alumno1, Alumno alumno2) {
        Alumno alumno = (null);

        if (alumno1.getEdad() > alumno2.getEdad()) {
            alumno = alumno1;
        } else {
            alumno = alumno2;
        }

        return alumno;
    }

}
