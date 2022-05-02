package Tema11.Propios.ejercicio07.models.ticket;

import Lib.Util;
import Tema11.Propios.ejercicio07.interfaces.Zone;

public class VIP extends Ticket {
    private String alphaNumber;

    public VIP() {
        super();
        alphaNumber = Util.generateString();
    }

    public VIP(int ticketNumber, int matchNumber, Zone zone, State state) {
        super(ticketNumber, matchNumber, zone, state);
        alphaNumber = Util.generateString();
    }

    @Override
    public String toString() {
        return super.toString() + "VIP [alphaNumber=" + alphaNumber + "]";
    }

}
