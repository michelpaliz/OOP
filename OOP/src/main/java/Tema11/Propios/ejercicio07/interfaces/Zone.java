package Tema11.Propios.ejercicio07.interfaces;

import Tema11.Propios.ejercicio07.models.Match;
import Tema11.Propios.ejercicio07.models.ticket.Influence;

public interface Zone {

    public default double zone(Influence inf, Match m) {
        double result;
        switch (inf) {
            case LOW_INFLUENCE:
                return m.getBasePrice();
            case MEDIUM_INFLUENCE:
                result = m.getBasePrice() * 0.75;
                return m.getBasePrice() + result;
            case HIGH_INFLUENCE:
                result = m.getBasePrice() * 1.3;
                return m.getBasePrice() + result;
        }
        return 0;

    }

}
