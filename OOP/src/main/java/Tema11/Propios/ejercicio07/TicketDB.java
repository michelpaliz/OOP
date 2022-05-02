package Tema11.Propios.ejercicio07;

import java.util.HashMap;
import java.util.Map.Entry;

import Tema11.Propios.ejercicio07.models.ticket.Influence;
import Tema11.Propios.ejercicio07.models.ticket.State;
import Tema11.Propios.ejercicio07.models.ticket.Ticket;
import Tema11.Propios.ejercicio07.models.ticket.VIP;

public class TicketDB {

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
            vip = new VIP(i, ref, inf, State.FREE);
            tickets.put(i, ticket);
            vips.put(i, vip);
        }
        System.out.println("Random data created");
    }

    public void showDB() {
        for (Integer match : tickets.keySet()) {
            System.out.println(match + " = " + tickets.get(match));
        }
        System.out.println("************VIP**************");
        for (Integer match : vips.keySet()) {
            System.out.println(match + " = " + vips.get(match));
        }
    }

    public String matchSelected(int ref) {
        Ticket selected = null;
        for (Entry<Integer, Ticket> entry : tickets.entrySet()) {
            Integer key = entry.getKey();
            if (ref == key) {
                selected = tickets.get(key);
                if (selected.sold() == true) {
                    selected.setState(State.RESERVED);
                    return "The ticket is now yours " + selected;
                } else {
                    // ticket.setState(State.RESERVED);
                    return "The ticket is not avaliable";
                }
            }

        }
        return null;

    }

    public boolean checkState(Ticket t) {

        return false;
    }

}
