package Tema11.Propios.ejercicio07;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map.Entry;

import com.github.javafaker.Faker;

import Tema11.Propios.ejercicio07.models.Match;
import TestWorlde.Propio.main;
import Testing.Hashmap.hashmap;
import Util.Control;
import Util.Lib;

public class Exer7 {
    String[] teams = { "MADRID", "BARCELONA", "ATLETICO_MADRID", "VALENCIA" };
    final int MAX_MATCHES = 5;
    HashMap<Integer, Match> matches = new HashMap<>();
    Match match;
    // Match[] arrMatch = new Match[20];

    public Exer7() {
        // Displaying HashMap
        randomValues();

        // check element is present or not. if not loop will
        // break.

    }

    public void randomValues() {
        String localTeam, awayTeam;
        LocalDate date;
        for (int i = 0; i < 16; i++) {
            localTeam = getRandom();
            awayTeam = getRandom();
            date = Control.rndLocalDate();
            match = new Match(localTeam, awayTeam, date);
            // matches.put(match.getMatchReference(), match);
            matches.put(i, match);
            // matches.putAll(matches);

        }

        // System.out.println(matches);
        for (Integer match : matches.keySet()) {
            System.out.println(match + " = " + matches.get(match));
        }
    }

    public String getRandom() {
        String value = "";
        int index = 0;
        for (int i = 0; i < teams.length; i++) {
            index = Lib.r.nextInt(teams.length);
            value = teams[index];
        }
        return value;
    }

    // public HashMap<Integer, Match> randomValues() {
    // Faker faker = new Faker();
    // for (int i = 0; i < matches.size(); i++) {
    // int index = Lib.r.nextInt(teams.length);
    // String localTeam = teams[index];
    // String awayTeam = teams[index];
    // LocalDate date = Control.rndLocalDate();

    // match = new Match(localTeam, awayTeam, date);
    // matches.put(match.getMatchReference(), match);

    // }

    // return matches;
    // }

}
