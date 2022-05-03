package Tema11.Propios.ejercicio07;

import java.util.Scanner;

import Lib.Control;
import Tema11.Propios.ejercicio07.models.Match;
import Tema11.Propios.ejercicio07.models.ticket.Ticket;

public class Exer7 {
    MatchesDB mDB = new MatchesDB();
    TicketDB tDB = new TicketDB();
    Match m = new Match();
    Ticket t = new Ticket();
    Scanner myInput = new Scanner(System.in);
    int usrInt;
    String usrStr;
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
                mDB.randomValues();
                mDB.showDB();
                usrInt = Integer.parseInt(myInput.nextLine());
                m = mDB.matchSelected(usrInt);
                System.out.println("This is the match that you selected " + m);
                System.out.println("This is the minimum price base for all the matches " + m.getBasePrice());
                System.out.println("These are the avaliable tickect for now, Select one");

                correct = Control.one("Do you want a VIP ticket (y/n) ", 'y');
                System.out.println(tDB.ticketSelected(usrInt, correct));
                // tDB.rndTicket(usrInt);
                // usrInt = Integer.parseInt(myInput.nextLine());
                // String t = tDB.normalTiketSelected(usrInt);
                // System.out.println(t);

                break;
            case 2:

                break;
        }

    }

}
