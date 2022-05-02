package Testing.menu;

import java.util.Arrays;
import java.util.regex.Pattern;

import Lib.Control;
import Lib.Util;

public class Menu {

    private static final Pattern REGEXP = Pattern.compile("[0-9]{8}[A-Z]");
    private static final Pattern REGEXP1 = Pattern.compile("[0-9]{8}");
    private static final String DIGITO_CONTROL = "TRWAGMYFPDXBNJZSQVHLCKE";
    private static final String[] INVALIDOS = new String[] { "00000000T", "00000001R", "99999999R" };

    // public Menu() {
    // String title = "title";
    // String[] sentences = { "Hello", "bye", "goodbye", "helloagain" };

    // System.out.println("This is the lenght of the array");
    // System.out.println(sentences.length);

    // menuGenerator(title, sentences);
    // }

    // public void menuGenerator(String title, String[] sentence) {
    // System.out.printf("*****%S********\n\n", title);
    // for (int i = 0; i < sentence.length; i++) {
    // sentence[i] = String.format("%d %S\n", (i + 1), sentence[i]);
    // System.out.println(sentence[i]);
    // }
    // }

    public Menu() {
        int dni = 53629275;

        System.out.println(validateDni(dni));
        // System.out.println(validarDNI(dni));


    }

    public String validateDni(int dni) {
        String str = "TRWAGMYFPDXBNJZSQVHLCKE";
        char letra = 'a';
        int result = dni % str.length();
        String dniStr = null;
        dniStr = String.valueOf(dni);
        if (REGEXP1.matcher(dniStr).matches()) {
            letra = str.charAt(result);

        } else {
            System.out.print("Dni invalido\n");
            System.out.println("Presione enter para continuar...");
            Util.myInput.nextLine();
        }
        return dniStr + letra;
    }

    public void testMenu() {
        String message = "introduce your answer ";
        char validate[] = { 's', 'n', 'o' };
        System.out.println(Control.one(message, validate));

    }

    public boolean validarDNI(String dni) {
        return Arrays.binarySearch(INVALIDOS, dni) < 0 // (1)
                && REGEXP.matcher(dni).matches() // (2)
                && dni.charAt(8) == DIGITO_CONTROL.charAt(Integer.parseInt(dni.substring(0, 8)) % 23); // (3)
    }

}
