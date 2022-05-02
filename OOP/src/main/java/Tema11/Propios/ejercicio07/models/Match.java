package Tema11.Propios.ejercicio07.models;

import java.sql.Date;
import java.time.LocalDate;
import java.util.GregorianCalendar;

import Tema11.Propios.ejercicio07.interfaces.Model;
import Util.Control;
import Util.Lib;

public class Match implements Model {
    private int matchReference;
    private double basePrice;
    private Influence influence;
    private String localTeam;
    private String awayTeam;
    private LocalDate date;

    public Match() {
        this.matchReference = matchReference + 1;
        this.basePrice = 50;
        this.influence = Influence.LOW_INFLUENCE;
    }

    public Match(int matchReference, String localTeam, String awayTeam, LocalDate date) {
        this.matchReference = matchReference;
        this.localTeam = localTeam;
        this.awayTeam = awayTeam;
        this.date = date;
        this.basePrice = 50;
    }

    public Match(String localTeam, String awayTeam, double basePrice, Influence influence, LocalDate date) {
        this.matchReference = matchReference + 1;
        this.localTeam = localTeam;
        this.awayTeam = awayTeam;
        this.basePrice = basePrice;
        this.influence = influence;
        this.date = date;
    }

    public int getMatchReference() {
        return matchReference;
    }

    public double getBasePrice() {
        return basePrice;
    }

    @Override
    public boolean equals(Object match) {
        if (this == match)
            return true;
        if (match == null || this.getClass() != match.getClass())
            return false;
        Match m = (Match) match;
        return this.matchReference == m.matchReference;

    }

    // TODO CONSTRUCTOR TO CREATE NEW MATCHES

    @Override
    public String toString() {
        return "Match [ Reference " + getMatchReference() + " awayTeam= " + awayTeam + " localTeam= " + localTeam
                + " Date " + Lib.dateFrmYear(date) + "]";
    }

}
