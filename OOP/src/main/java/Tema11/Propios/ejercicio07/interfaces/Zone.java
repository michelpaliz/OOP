package Tema11.Propios.ejercicio07.interfaces;

import Tema11.Propios.ejercicio07.models.Match;
import Tema11.Propios.ejercicio07.models.ticket.Influence;

public interface Zone {

    public default double zone(Influence inf, Match m) {

        switch (inf) {
            case LOW_INFLUENCE:
                return m.getBasePrice() * 0.75;
            case MEDIUM_INFLUENCE:
                return m.getBasePrice() * 0.75;
            case HIGH_INFLUENCE:
                return m.getBasePrice() * 130;
        }
        return 0;

    }

}
