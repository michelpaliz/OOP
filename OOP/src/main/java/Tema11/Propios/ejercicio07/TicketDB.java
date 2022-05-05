package Tema11.Propios.ejercicio07;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Map.Entry;

import Tema11.Propios.ejercicio07.models.ticket.Influence;
import Tema11.Propios.ejercicio07.models.ticket.State;
import Tema11.Propios.ejercicio07.models.ticket.Ticket;
import Tema11.Propios.ejercicio07.models.ticket.VIP;
import Testing.Hashmap.hashmap;

public class TicketDB {

    Scanner myInput = new Scanner(System.in);
    int usr;
    static HashMap<Integer, Ticket> tickets = new HashMap<>();
    static HashMap<Integer, Ticket> vips = new HashMap<>();
    Ticket ticket;
    VIP vip;
    MatchesDB db = new MatchesDB();
    // **************
    static HashMap<Integer, Ticket> freeTickets = new HashMap<>();
    static HashMap<Integer, Ticket> reservedTikets = new HashMap<>();

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
        System.out.println("*********TICKET**********");
        for (Integer match : tickets.keySet()) {
            System.out.println(match + " = " + tickets.get(match));
        }
        // System.out.println("************VIP**************");
        // for (Integer match : vips.keySet()) {
        // System.out.println(match + " = " + vips.get(match));
        // }
    }

    /**
     * 
     * @param tickets you want to print out in the screen
     */
    public void showDB(HashMap<Integer, Ticket> tick) {
        for (Integer match : tick.keySet()) {
            System.out.println(match + " = " + tick.get(match));
        }
    }

    public void showDB() {
        for (Integer free : freeTickets.keySet()) {
            System.out.println(free + " = " + freeTickets.get(free));
        }
        for (Integer reserved : freeTickets.keySet()) {
            System.out.println(reserved + " = " + freeTickets.get(reserved));
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

    // Let's list all the free tickets and reserved tickects

    public void type() {
        Ticket free;
        Integer key;
        Ticket value;
        // we got all the tickets, we get a ticket, then we compare the state and store
        // it to a new array
        System.out.println("dasjflksa");
        for (Integer match : tickets.keySet()) {
            System.out.println(match);
            System.out.println("sdfasfd");
            free = tickets.get(match);
            System.out.println(free.getState());
            if (free.getState().equals(State.FREE)) {
                for (Entry<Integer, Ticket> entry : tickets.entrySet()) {
                    key = entry.getKey();
                    value = entry.getValue();
                    freeTickets.put(key, value);
                    // System.out.println("This is the free ticket list");
                    // showDB(freeTickets);
                    // System.out.println(freeTickets);
                }
            } else {
                reservedTikets.put(match, ticket);
                // System.out.println("This is the reserved ticket list");
                // showDB(reservedTikets);
                // System.out.println(reservedTikets);
            }

        }
    }

    // Now let's do a refund for those who don't want the ticket
    /**
     * 
     * @param ticket
     * @return the refunded ticket
     */

    public Ticket refundTicket(Ticket ticket) {
        if (ticket.getState() == State.RESERVED) {
            ticket.setState(State.FREE);
            return ticket;
        } else {
            System.out.println("The ticket is already free. please insert a reserved ticket");
        }
        return null;
    }

    /**
     * 
     * @param ticket
     * @return the VIP refunded ticket
     */

    public VIP refundPIV(VIP ticket) {
        if (ticket.getState() == State.RESERVED) {
            ticket.setState(State.FREE);
            return ticket;
        } else {
            System.out.println("The ticket is already free. please insert a reserved ticket");
        }
        return null;
    }

}
