package Tema10.Ejercicios.Propios.Ejercicio8;

import java.util.HashMap;

public class Gestion {

    public HashMap<String, String> diccionario = new HashMap<>();
    public static final int INITIAL_SIZE = 10;

    public Gestion(HashMap<String, String> diccionario) {
        this.diccionario = diccionario;
    }

    public Gestion() {
        this(INITIAL_SIZE);
    }

    public Gestion(int initialSize) {
        diccionario = new HashMap<>(initialSize);
    }

    /**
     * 
     * @param key
     * @param value
     */

    public void addElement(String key, String value) {
        System.out
                .println("First let's check out if the elements exits if not we would add the keyword and the meaning");
        if (diccionario.containsKey(key) == true) {
            System.out.println("The keyword exits so we will only add the value for the key");
            diccionario.put(key, value);
            System.out.println(diccionario);
        } else {
            System.out.println(
                    "There is not any matching key in the dictionary so we're going to create it with the already elemments inserted");
            diccionario.put(key, value);
            System.out.println(diccionario);

        }
    }

    /**
     * 
     * @param key
     * @param value
     */

    public void replaceValue(String key, String value) {
        if (diccionario.isEmpty()) {
            if (diccionario.containsKey(key) == true) {
                diccionario.replace(key, value);
                System.out.println(diccionario.get(key));
            } else {
                System.out.println(
                        "There is no matching key in the dictioray, so for we've got to add a new key with its value");
                diccionario.put(key, value);
                System.out.println(diccionario.get(key));

            }
        } else {
            System.out.println("Error");
        }

    }

    /**
     * 
     * @param key
     * @param value
     */

    public void replaceKey(String key, String value) {

        if (diccionario.remove(key) != null) {
            System.out.println("The remove was completed sucessfully");
        } else {
            System.out.println("They key does not match with any other key");
        }

    }

    /**
     * 
     * @param palabra
     * @return true if exists or false it doesn't
     */
    public boolean checkExits(String palabra) {
        return diccionario.get(palabra) == null;
    }

    @Override
    public String toString() {
        return "Gestion [diccionario=" + diccionario + "]";
    }

}
