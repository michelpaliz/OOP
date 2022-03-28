package Tema10.Ejercicios.Propios.Ejercicio8;

import java.util.HashMap;

public class Gestion {

    public HashMap<String, String> diccionario = new HashMap<>();
    public static final int INITIAL_SIZE = 10;

    public Gestion(){
        this(INITIAL_SIZE);
    }

    public Gestion(int initialSize){
        diccionario = new HashMap<>(initialSize);
    }

    
    /**
     * 
     * @param key
     * @param value
     */

    public void  addElement(String key, String value){
        if (diccionario.containsKey(key)) {
            diccionario.put(key, value);
        } else {
            System.out.println("No existe la palabra");
        }
    }

    /**
     * 
     * @param palabra
     * @return existe o no existe la palabra
     */
    public boolean checkExits(String palabra){
        return diccionario.get(palabra) == null;
    }





}
