package Testing.Hashmap;

import java.util.ArrayList;
import java.util.Arrays;

public class myHashmap {
    private int[] datos;
    private final static int INITIAL = 255; 

    public myHashmap() {
        datos = new int[INITIAL];
    }

    // to add elements we need the key and the value
    public int put(String key, int value) {
        int position = hash(key);
        datos[position] = value;
        return value;
    }

    // this will give us the index to put or to add the new value
    private int hash(String key) {
        int sum = 0;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            sum += c; // we add up each char
        }
        return sum % INITIAL;

    }

    //this will give us the value
    public int get(String key){
        int position = hash(key);
        return datos[position];
    }

    @Override
    public String toString() {
        return "myHashmap [datos=" + Arrays.toString(datos) + "]";
    }

}
