package Tema10.Ejercicios.Propios.Ejercicio5;

import java.util.HashMap;

public class Traducir implements ITraducir {

    private HashMap<String, String> diccionario;

    public Traducir() {
        this(10);
    }

    public Traducir(int initialCapacity) {
        diccionario = new HashMap<>(initialCapacity);
    }

    @Override
    public String introducirPareja(String palabraIng, String palabraVal) {
        if (!checkExists(palabraIng)) {
            return diccionario.put(palabraIng, palabraVal);
        } else {
            return "esta traduccion ya existe";
        }

    }

    @Override
    public String traducirPalabra(String palabra) {
        if (!checkExists(palabra)) {
            return "la palabra no existe";
        }

        return diccionario.get(palabra);
    }

    private boolean checkExists(String palabra) {
        return diccionario.get(palabra) == null;
    }

}
