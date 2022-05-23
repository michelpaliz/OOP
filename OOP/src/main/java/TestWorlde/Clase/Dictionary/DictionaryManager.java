package TestWorlde.Clase.Dictionary;

public class DictionaryManager {
    //va recibir un idioma y el diccionario que se eencarga de es idioma
    public  static String[] loadDictionary(Language language){
        switch (language){
            case ES:
                    return WordleES.words;
            case EN:
                return WorldEN.words;
            default:
                return null;
        }
    }
    
}
