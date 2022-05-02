package Tema11.Propios.ejercicio07.models.ticket;

import Tema11.Propios.ejercicio07.interfaces.Zone;
import Tema11.Propios.ejercicio07.models.Match;

public class Ticket implements Zone {
    // this ticket class that is going to be the one to print out the type of ticket
    final int MAX = 100;
    // private int[] maxCapacity = new int[MAX]; // MAX FOR TICKETS
    private int ticketNumber;
    private int matchNumber;
    private Influence influence;
    private State state;

    public Ticket() {
        this.ticketNumber = +1;
        this.matchNumber = 0;
        // this.zone = zone;
    }

    public Ticket(int ticketNumber, int matchNumber, Influence influence, State state) {
        this.ticketNumber = ticketNumber;
        this.matchNumber = matchNumber;
        this.influence = influence;
        this.state = state;
    }

    /**
     * 
     * @param st introduce the new State which is being sold
     * @return reserved or free
     */
    public boolean sold() {

        if (State.FREE.equals(this.state)) {
            return true;
        }
        // this.state = State.RESERVED;
        // setState(State.RESERVED);
        return false;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public double zone(Influence inf, Match m) {
        // TODO Auto-generated method stub
        return Zone.super.zone(inf, m);
    }

    @Override
    public String toString() {
        return "Ticket [influence=" + influence + ", matchNumber=" + matchNumber + ", state=" + state
                + ", ticketNumber=" + ticketNumber + "]";
    }

}
