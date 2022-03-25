package TestWorlde.Clase;

import java.util.Dictionary;

import TestWorlde.Clase.Dictionary.DictionaryManager;
import TestWorlde.Clase.Dictionary.Language;
import Util.Lib;

public class Main {

    public static void main(String[] args) {
        // pensar si esta declaracion de abajo esta bien colocada
        String[] words = DictionaryManager.loadDictionary(Language.ES);

        int option = menuLanguage();

        int option = DictionaryManager.loadDictionary(Language.ES);

    }

    public static int menuLanguage() {
        Language[] languages = Language.values();
        int option = -1;
        boolean exit = 0;
        do {
            System.out.println("***************");
            System.out.println("*LANGUAGUE****");
            System.out.println("**************");
            for (int i = 0; i < languages.length; i++) {
                System.out.printf("%d. %s", (i + 1), languages[i]);
            }
            System.out.println("0.Exit\n", languages.length);
            System.out.println("-------------------");
            System.out.println(" Choose option: ");
            try {
                option = Integer.parseInt(Lib.myInput.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("only numbers, please");
            }
            exit = option < 0 || option > languages.length;
            if (option) {

            }

        } while (option < 0 || option > languages.length);

        return option;

    }

}
