package Tema10.Ejercicios.Particulares;

import java.util.HashMap;

public class Gestion {

    public HashMap<String, String> diccionario;
    public static final int INITIAL_SIZE = 10;

    public Gestion() {
        this(INITIAL_SIZE);
    }

    public Gestion(int initialSize) {
        diccionario = new HashMap<String, String>(initialSize);
    }

    public Gestion(HashMap<String, String> diccionario) {
        this.diccionario = diccionario;
    }

    /**
     * 
     * @param key
     * @param value
     */

    public void addElement(String key, String value) {

        if (diccionario.containsKey(key)) System.out.println("The keyword exits so we will only add the value for the key");
        else diccionario.put(key, value);

    }

    /**
     * 
     * @param key
     * @param value
     */

    public void replace(String key, String value) {

        if ( !diccionario.containsKey(key) )  System.out.println( "There is no matching key for this word in the dictioray, so we've got to add a new key with its value");
        else diccionario.replace(key, value);
    }

    public void remove(String key) {
        if ( diccionario.containsKey(key) )diccionario.remove(key);
        else System.out.println("Keyword that you've inserted does not exists");
    }

    public void show(String key) {

        if (diccionario.containsKey(key)) System.out.println(diccionario.get(key));
        else System.out.println("Keyword that you've inserted does not exists");
    }

    /**
     * 
     * @param palabra
     * @return true if exists or false it doesn't
     */
    public boolean checkExits(String palabra) {
        return diccionario.containsKey(palabra);
    }

    public void showdic() {

        for(String key : diccionario.keySet()) System.out.println(key+" : "+diccionario.get(key));
        
    }



}
