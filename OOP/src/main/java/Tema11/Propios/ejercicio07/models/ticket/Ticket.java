package Tema11.Propios.ejercicio07.models.ticket;

public class Ticket {
    // this ticket class that is going to be the one to print out the type of ticket
    final int MAX = 100;
    private int[] maxCapacity = new int[MAX]; //MAX FOR TICKETS
    private int ticketNumber;
    private String matchNumber;

    public Ticket() {
        this.ticketNumber += ticketNumber;
        matchNumber = null; // TODO generate a random function to create this.
    }

    public Ticket(int ticketNumber, String matchString) {
        this.ticketNumber = ticketNumber;
        this.matchNumber = matchString;
    }

    @Override
    public String toString() {
        return "Ticket [matchNumber=" + matchNumber + ", ticketNumber=" + ticketNumber + "]";
    }

}
