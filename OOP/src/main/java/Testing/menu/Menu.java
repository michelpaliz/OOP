package Testing.menu;

import java.util.Arrays;

public class Menu {

    public Menu() {
        String[] sentences = { "Hello, bye, goodbye" };
        String title = "title";
        menuFunction(title, sentences);
    }

    public void menuFunction(String title, String[] sentence) {
        String con = "";
        System.out.printf("*****%S********\n", title);
        for (int i = 0; i < sentence.length; i++) {
            // sentence[i] = String.format("%d %S\n", (i + 1), sentence[i]);
            con = String.format("%d %S\n", (i + 1), sentence[i]);
            System.out.print((con));
        }
        System.out.println();
    }

}
