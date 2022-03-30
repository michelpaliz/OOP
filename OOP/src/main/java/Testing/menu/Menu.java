package Testing.menu;

public class Menu {

    public Menu() {
        String[] sentences = { "Hello, bye, goodbye" };
        String title = "title";
        menuFunction(title, sentences);
    }

    public void menuFunction(String title, String[] sentence) {
        // String con = "";
        System.out.printf("*****%S********", title);
        for (int i = 0; i < sentence.length; i++) {
            sentence[i] = String.format("1. %S", sentence[i]);
            System.out.print(sentence);
        }
        System.out.println();
    }

}
