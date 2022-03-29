package Tema10.Ejercicios.Propios.Ejercicio8;

import java.util.HashMap;

import Util.menu;

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
        if (diccionario.containsKey(key)) {
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

    public void replace(String key, String value) {
        if (diccionario.get(key).isEmpty() == false) {
            if (diccionario.containsKey(key)) {
                System.out.println("The key already exits so we have only edit the value for it");
                diccionario.replace(key, value);
                System.out.println(diccionario);
            } else {
                System.out.println(
                        "There is no matching key for this word in the dictioray, so we've got to add a new key with its value");
                diccionario.put(key, value);
                System.out.println(diccionario);
            }
        } else {
            System.out.println("Error");
        }

    }

    public void remove(String key) {
        if (diccionario.get(key).isEmpty() == false) {
            if (diccionario.containsKey(key)) {
                diccionario.remove(key);
                System.out.println(diccionario);
            } else {
                System.out.println("Keyword that you've inserted does not exists");
            }
        } else {
            System.out.println("Error");
        }
    }

    public void show(String key) {
        if (diccionario.get(key).isEmpty() == false) {
            if (diccionario.containsKey(key)) {
                System.out.println(diccionario.get(key));
            } else {
                System.out.println("Keyword that you've inserted does not exists");
            }
        } else {
            System.out.println("Error");
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