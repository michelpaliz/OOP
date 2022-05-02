package Tema11.Propios.ejercicio07;

import java.util.Scanner;

import Lib.Control;
import Tema11.Propios.ejercicio07.models.Match;

public class Exer7 {
    DataBase db = new DataBase();
    Match m = new Match();
    Scanner myInput = new Scanner(System.in);
    int usrInt;
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
                usrInt = Integer.parseInt(myInput.nextLine());
                m = db.matchSelected(usrInt);
                System.out.println("This is the match that you selected " + m);
                System.out.println("This is the minimum price base for all the matches " + m.getBasePrice());

                break;
            case 2:

                break;
        }

    }

}
