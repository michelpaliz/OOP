package TestWorlde.Propio.Worlde;

import java.util.Arrays;
import java.util.Random;

public class Wordle {
    Random r = new Random();
    
    //Atributos
    private final String targetWord;
    private final String[] words;
    private final int currentAttempt;


    public Wordle(String targetWord, String[] words, int currentAttempt) {
        this.targetWord = targetWord;
        this.words = words;
        this.currentAttempt = currentAttempt;
    }


    public String getTargetWord() {
        return targetWord;
    }


    public String[] getWords() {
        return words;
    }


    public int getCurrentAttempt() {
        return currentAttempt;
    }


    @Override
    public String toString() {
        return "Wordle [currentAttempt=" + currentAttempt + ", targetWord=" + targetWord + ", words="
                + Arrays.toString(words) + "]";
    }

    public void  insertWord(String word){

        int cont = 0;
        do {
            
        } while (condition);
    }




    

}
