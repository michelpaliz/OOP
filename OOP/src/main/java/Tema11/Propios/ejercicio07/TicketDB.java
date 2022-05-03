package Tema11.Propios.ejercicio07;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Map.Entry;

import Tema11.Propios.ejercicio07.models.ticket.Influence;
import Tema11.Propios.ejercicio07.models.ticket.State;
import Tema11.Propios.ejercicio07.models.ticket.Ticket;
import Tema11.Propios.ejercicio07.models.ticket.VIP;

public class TicketDB {

    Scanner myInput = new Scanner(System.in);
    int usr;
    static HashMap<Integer, Ticket> tickets = new HashMap<>();
    static HashMap<Integer, Ticket> vips = new HashMap<>();
    Ticket ticket;
    VIP vip;
    MatchesDB db = new MatchesDB();

    public TicketDB() {

    }

    public void rndTicket(int ref) {

        for (int i = 0; i < 10; i++) {
            Influence inf = Influence.getRandom();
            ticket = new Ticket(i, ref, inf, State.FREE);
            // vip = new VIP(i, ref, inf, State.FREE);
            tickets.put(i, ticket);
            // vips.put(i, vip);
        }
        System.out.println("Generated normal tickets");
    }

    public void rndVIP(int ref) {
        for (int i = 0; i < 10; i++) {
            Influence inf = Influence.getRandom();
            vip = new VIP(i, ref, inf, State.FREE);
            vips.put(i, vip);
        }
        System.out.println("Generted VIP tickets");
    }

    public void showNormalDB() {
        for (Integer match : tickets.keySet()) {
            System.out.println(match + " = " + tickets.get(match));
        }
        System.out.println("************VIP**************");
        for (Integer match : vips.keySet()) {
            System.out.println(match + " = " + vips.get(match));
        }
    }

    public void showVIP() {
        System.out.println("************VIP**************");
        for (Integer match : vips.keySet()) {
            System.out.println(match + " = " + vips.get(match));
        }
    }

    public Ticket normalTiketSelected(int ref) {
        Ticket selected = null;
        for (Entry<Integer, Ticket> entry : tickets.entrySet()) {
            Integer key = entry.getKey();
            if (ref == key) {
                selected = tickets.get(key);
                if (selected.sold() == true) {
                    selected.setState(State.RESERVED);
                    System.out.println("The ticket is now yours" + selected);
                    return selected;
                } else {
                    System.out.println("The ticket is not avaliable");
                }
            }

        }
        return null;

    }

    public <T> Ticket ticketSelected(int ref, boolean choice) {
        if (choice == true) {
            rndVIP(ref);
            showVIP();
            System.out.println("Please select the TICKET_REFERENCE for your ticket");
            int newRef = usr = Integer.parseInt(myInput.nextLine());
            ref = newRef;
            VIP selected = null;
            for (Entry<Integer, Ticket> entry : vips.entrySet()) {
                Integer key = entry.getKey();
                if (ref == key) {
                    selected = (VIP) vips.get(key);
                    if (selected.sold() == true) {
                        selected.setState(State.RESERVED);
                        // return "The ticket is now yours " + selected;
                        System.out.println("The ticket is now yours " + selected);
                        return selected;
                    } else {
                        System.out.println("The ticket is not avaliable");
                    }
                }
            }
        } else {
            System.out.println("Please select the TICKET_REFERENCE for your ticket");
            int newRef = usr = Integer.parseInt(myInput.nextLine());
            ref = newRef;
            rndTicket(ref);
            showNormalDB();
            return normalTiketSelected(ref);
        }
        return null;

    }

    // Now let's do the payments for our clients

}
