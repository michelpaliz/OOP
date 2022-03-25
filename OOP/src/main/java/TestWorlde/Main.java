package TestWorlde;

import java.util.Dictionary;

import TestWorlde.Clase.Dictionary.DictionaryManager;
import TestWorlde.Clase.Dictionary.Language;

public class Main {

    public static void main(String[] args) {
        // pensar si esta declaracion de abajo esta bien colocada
        String[] words = DictionaryManager.loadDictionary(Language.ES);

    }

}
