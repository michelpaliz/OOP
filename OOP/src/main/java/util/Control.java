package Util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Control {

    private static String userStr;
    private static int userInt;
    private static boolean correct;

    public static void menuGenerator(String title, String[] sentence) {
        System.out.printf("*****%S********\n\n", title);
        for (int i = 0; i < sentence.length; i++) {
            sentence[i] = String.format("%d %S\n", (i + 1), sentence[i]);
            System.out.println(sentence[i]);
        }
    }

    public static int getEdad(GregorianCalendar edad) {
        int anyoNacimiento = edad.get(Calendar.YEAR);
        int mesNacimiento = edad.get(Calendar.MONTH) + 1; //
        int diaNacimiento = edad.get(Calendar.DAY_OF_MONTH);

        GregorianCalendar fecha = new GregorianCalendar();
        int anyoActual = fecha.get(Calendar.YEAR);
        int mesActual = fecha.get(Calendar.MONTH) + 1;
        int diaActual = fecha.get(Calendar.DAY_OF_MONTH);

        int edad1 = anyoActual - anyoNacimiento;

        if (mesActual < mesNacimiento) {
            edad1--;
        } else if (mesActual == mesNacimiento) {
            if (diaActual < diaNacimiento) {
                edad1--;
            }
        }
        return edad1;
    }

    /**
     * 
     * @param min introduce the minimum date you want
     * @param max introduce the maximum date you want
     * @return
     */

    public static GregorianCalendar randBirth(int min, int max) {
        GregorianCalendar gc = new GregorianCalendar();

        // we create a date between these two years
        // int year = Lib.randBetween(1900, 2010);
        if (min < 1900) {
            System.out.println("The date needs to be greater than " + min);
        }
        int year = Lib.randBetween(min, max);
        // we set the our own year to one gc YEAR
        gc.set(gc.YEAR, year);
        // get a random day of the year
        int dayOfYear = Lib.randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));
        // then we obtain our last item
        gc.set(gc.DAY_OF_YEAR, dayOfYear);
        // print out an example(*we need to format this in order to print this
        // correctly)
        // System.out.println(gc.get(gc.YEAR) + "-" + (gc.get(gc.MONTH) + 1) + "-" +
        // gc.get(gc.DAY_OF_MONTH));

        return gc;

    }

    /**
     * 
     * @return gregoriancalendar that the user has introduced
     */

    public static GregorianCalendar birthFormat() {
        System.out.println("Fecha de fabricacion (dd-mm-yyyy)");
        userStr = Lib.myInput.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat("DD-MM-YYYY");
        GregorianCalendar birth = null;
        do {
            try {
                Date date = sdf.parse(userStr);
                birth = new GregorianCalendar();
                birth.setTime(date);
                correct = true;
            } catch (Exception e) {
                correct = false;
                System.out.println("The format that you've introduced is not correct");
            }

        } while (!correct);

        return birth;

    }

}
