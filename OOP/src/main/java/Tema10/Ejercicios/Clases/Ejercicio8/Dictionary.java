package Tema10.Ejercicios.Clases.Ejercicio8;

import java.util.HashMap;

import com.github.javafaker.Faker;

public class Dictionary implements IDictionary {

    // Atributos
    private final static int INITIAL_CAPACITY = 10;
    private final HashMap<String, String> dictionary;

    public Dictionary() {
        this(INITIAL_CAPACITY);
    }

    public Dictionary(int initialSize) {
        dictionary = new HashMap<String, String>(initialSize);
    }

    private void generateWord() {
        Faker faker = new Faker();
        for (int i = 0; i < INITIAL_CAPACITY / 2; i++) {
            dictionary.put(faker.lorem().word().toUpperCase());
        }
    }

    // Metodos Throw exeption
    @Override
    public void add(String word) {
        // TODO Auto-generated method stub

    }

    @Override
    public void modify(String newKey) {
        // TODO Auto-generated method stub

    }

    @Override
    public void remove(String word) {
        // TODO Auto-generated method stub

    }

    @Override
    public String query(String word) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void show() {
        // TODO Auto-generated method stub

    }

    public static void printAll() {
        
    }

}
