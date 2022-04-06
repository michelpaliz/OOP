package Util;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Pattern;

public class Control {

    private static String userStr;
    private static int userInt;
    private static boolean correct;

    private static final Pattern REGEXP = Pattern.compile("[0-9]{8}[A-Z]");
    private static final Pattern REGEXP1 = Pattern.compile("[0-9]{8}");
    private static final String DIGITO_CONTROL = "TRWAGMYFPDXBNJZSQVHLCKE";
    private static final String[] INVALIDOS = new String[] { "00000000T", "00000001R", "99999999R" };

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

    /**
     * 
     * @param message  introduce the message you want to ask to the user
     * @param validate validate each one of your validated options
     * @return true if it matches any asnwers and false if it does not.
     */

    public static boolean one(String message, char[] validate) {
        int index = 0;
        System.out.printf(message);
        char c = Lib.myInput.nextLine().toLowerCase().charAt(index);
        for (int i = 0; i < validate.length; i++) {
            if (validate[i] == c) {
                correct = true;
            } else {
                correct = false;
            }
        }
        return correct;

    }

    /**
     * 
     * @param dni introduce the 8 digits for your dni
     * @return the correct char for your dni
     */

    public String DNIgenerator(int dni) {
        String str = "TRWAGMYFPDXBNJZSQVHLCKE";
        char letra = 'a';
        int result = dni % 23;
        String dniStr = null;
        dniStr = String.valueOf(dni);
        if (REGEXP1.matcher(dniStr).matches()) {
            letra = str.charAt(result);

        } else {
            System.out.print("Dni invalido\n");
            System.out.println("Presione enter para continuar...");
            Lib.myInput.nextLine();
        }
        return dniStr + letra;
    }

    /**
     * 
     * @param dni validates your dni
     * @return true if its correct and false otherwise
     */

    public boolean validateDNI(String dni) {
        return Arrays.binarySearch(INVALIDOS, dni) < 0 // (1)
                && REGEXP.matcher(dni).matches() // (2)
                && dni.charAt(8) == DIGITO_CONTROL.charAt(Integer.parseInt(dni.substring(0, 8)) % 23); // (3)
    }

}
