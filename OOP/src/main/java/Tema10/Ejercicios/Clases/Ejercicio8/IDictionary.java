package Tema10.Ejercicios.Clases.Ejercicio8;

public interface IDictionary {
    void add(String word);
    void modify(String newKey);// oldDenition no
    void remove(String word);//return String or null
    String query(String word);
    void show();// ToString mejor
    
}
