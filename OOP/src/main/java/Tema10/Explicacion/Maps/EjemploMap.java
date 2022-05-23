package Tema10.Explicacion.Maps;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class EjemploMap {
    private final int MAXP = 100;

    public EjemploMap() {
            Random r = new Random();
        HashMap<String, String> diccionario = new HashMap<>();

        String value = diccionario.put("hola", "Otro saludoxd");
        System.out.println(value);
        System.out.println(value);

        value = diccionario.put("saludo", "Otro saludo");
        value = diccionario.put("saludo","otra forma de saludar")
        // System.out.println(diccionario.get("hola"));
        // System.out.println(diccionario.get("saludo"));
        for(int i = 0; i < MAXP; i++) {
            int randomLenghtkey = r.nextInt(10+5-1)+5;
            int randomLenght = r.nextInt(10+5-1)+5;
            lastValue = generateWord();
            lastkey = generatWord(randomLenghtKey);
            diccionario.put(generateWord(randomLenghtkey),generateWord(randomLenght));
        }
        System.out.println(diccionario);
        System.out.println((diccionario.get(lastKey)));
     

    }

    public String generateWord(){
        String texto = "abcdefghijklmnopksrtz";
        String word = "";
        int min =0;
        int max = text.lenght
        for(int i = 0; i < MAXP; i++) {
            word += text.charAt(r.nextInt(max-min + 1) + min)
        }
    }

}
