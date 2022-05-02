package Tema11.Propios.ejercicio07;

import java.util.HashMap;
import java.util.Map.Entry;

import Tema11.Propios.ejercicio07.models.ticket.Influence;
import Tema11.Propios.ejercicio07.models.ticket.State;
import Tema11.Propios.ejercicio07.models.ticket.Ticket;

public class TicketDB {

    static HashMap<Integer, Ticket> tickets = new HashMap<>();
    Ticket ticket;
    MatchesDB db = new MatchesDB();

    public TicketDB() {

    }

    public void rndTicket() {

        for (int i = 0; i < 10; i++) {
            Influence inf = Influence.getRandom();
            ticket = new Ticket(i, i, inf, State.FREE);
            tickets.put(i, ticket);
        }
        System.out.println("Random data created");
    }

    public void showDB() {
        for (Integer match : tickets.keySet()) {
            System.out.println(match + " = " + tickets.get(match));
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
