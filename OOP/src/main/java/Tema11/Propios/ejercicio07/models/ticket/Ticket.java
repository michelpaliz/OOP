package Tema11.Propios.ejercicio07.models.ticket;

import Tema11.Propios.ejercicio07.interfaces.Zone;
import Tema11.Propios.ejercicio07.models.Match;

public class Ticket implements Zone{
    // this ticket class that is going to be the one to print out the type of ticket
    final int MAX = 100;
    private int[] maxCapacity = new int[MAX]; //MAX FOR TICKETS
    private int ticketNumber;
    private int matchNumber;

    public Ticket() {
        this.ticketNumber += ticketNumber;
        matchNumber = 0; // TODO generate a random function to create this.
    }

    public Ticket(int ticketNumber, int matchint) {
        this.ticketNumber = ticketNumber;
        this.matchNumber = matchint;
    }

    @Override
    public double zone(Influence inf, Match m) {
        // TODO Auto-generated method stub
        return Zone.super.zone(inf, m);
    }

    @Override
    public String toString() {
        return "Ticket [matchNumber=" + matchNumber + ", ticketNumber=" + ticketNumber + "]";
    }

}
