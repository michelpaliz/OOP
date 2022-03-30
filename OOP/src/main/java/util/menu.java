package Util;

public class menu {

    public void menuGenerator(String title, String[] sentence) {
        System.out.printf("*****%S********\n\n", title);
        for (int i = 0; i < sentence.length; i++) {
            sentence[i] = String.format("%d %S\n", (i + 1), sentence[i]);
            System.out.println(sentence[i]);
        }
    }
    
}
