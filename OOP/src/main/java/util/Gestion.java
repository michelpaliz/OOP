package Util;

import java.util.Calendar;

public class Gestion {

    public int getEdad(Object edad) {
     
        int anyoNacimiento = ((Calendar) edad).get(Calendar.YEAR);
        int mesNacimiento = edad.get(Calendar.MONTH) + 1; //
        int diaNacimiento = edad.get(Calendar.DAY_OF_MONTH);

        GregorianCalendar fecha = new GregorianCalendar();
            int anyoActual = fecha.get(Calendar.YEAR);
            int mesActual = fecha.get(Calendar.MONTH) + 1;
            int diaActual = fecha.get(Calendar.DAY_OF_MONTH);

        int edad = anyoActual - anyoNacimiento;
        if (mesActual < mesNacimiento) {
            edad--;
        } else if (mesActual == mesNacimiento) {
            if (diaActual < diaNacimiento) {
                edad--;
            }
        }
        return edad;
    }



}
