package Tema11.Propios.ejercicio07.models.ticket;

import Lib.Util;
import Tema11.Propios.ejercicio07.interfaces.Zone;

public class Normal extends Ticket {

    private int aleatoryNumb;

    public Normal() {
        super();
        this.aleatoryNumb = Util.random(0, 100);
    }

    public Normal(int ticketNumber, int matchNumber, Zone zone, State state) {
        super(ticketNumber, matchNumber, zone, state);
        this.aleatoryNumb = Util.random(0, 100);
    }

    @Override
    public String toString() {
        return super.toString() + " Normal [aleatoryNumb=" + aleatoryNumb + "]";
    }

}
