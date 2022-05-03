package Tema11.Propios.ejercicio07.models.ticket;

import Lib.Util;

public class VIP extends Ticket {
    private String alphaNumber;

    public VIP() {
        super();
        alphaNumber = Util.generateString();
    }

    public VIP(int ticketNumber, int matchNumber, Influence influence, State state) {
        super(ticketNumber, matchNumber, influence, state);
        alphaNumber = Util.generateString();
    }

    

    @Override
    public String toString() {
        return super.toString() + "VIP [alphaNumber=" + alphaNumber + "]";
    }

}
