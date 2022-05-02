package Tema11.Propios.ejercicio07;

import java.util.Scanner;

import Tema11.Propios.ejercicio07.models.Match;
import Util.Control;

public class Exer7 {
    DataBase db = new DataBase();
    Scanner myInput = new Scanner(System.in);
    boolean correct;

    public Exer7() {
        String tittle = "***********MENU***********\n";
        String[] sentence = { "EXIT", "PROGRAMMED MATCHES", "NEW MATCH" };
        int choice = Control.menuGenerator(tittle, sentence);
        switch (choice) {
            case 0:
                System.out.println("See ya!");
                break;
            case 1:
                System.out.println("Select the match you want to buy a ticket");
                db.randomValues();
                db.showDB();


                break;
            case 2:

                break;
        }

    }



}
