package Tema11.Propios.ejercicio07;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Tema11.Propios.ejercicio07.models.Match;
import Util.Control;
import Util.Lib;

public class Exer7 {
    String[] teams = { "MADRID", "BARCELONA", "ATLETICO_MADRID", "VALENCIA" };
    ArrayList<String> teamList = new ArrayList<String>();

    final int MAX_MATCHES = 5;
    HashMap<Integer, Match> matches = new HashMap<>();
    Match match;
    String localTeam, awayTeam;
    // Match[] arrMatch = new Match[20];

    public Exer7() {
        // Displaying HashMap
        teamList.add("MADRID");
        teamList.add("BARCELONA");
        teamList.add("ATLETICO_MADRID");
        teamList.add("VALENCIA");
        randomValues();

        // check element is present or not. if not loop will
        // break.

    }

    public void randomValues() {

        LocalDate date;
        for (int i = 0; i < 16; i++) {

            do {
                localTeam = teamList.get(getRandom(teamList));
                awayTeam = teamList.get(getRandom(teamList));
            } while (localTeam == awayTeam);

            // if (localTeam.equals(awayTeam)) {
            // localTeam = teamList.get(getRandom(teamList));
            // }
            date = Control.rndLocalDate();
            match = new Match(i, localTeam, awayTeam, date);
            // matches.put(match.getMatchReference(), match);
            matches.put(i, match);
            // matches.putAll(matches);

        }

        // System.out.println(matches + "\n");
        for (Integer match : matches.keySet()) {
            System.out.println(match + " = " + matches.get(match));
        }
    }

    public int getRandom(ArrayList<String> array) {
        int index = 0;
        index = Lib.r.nextInt(array.size());
        // System.out.println("This is the index " + index);
        // array.remove(index);
        // array.get(index);
        return index;

    }

    public String getRandomList() {
        String value = "";
        int index;
        do {
            System.out.println(teamList.size());
            for (int i = 0; i < teamList.size(); i++) {
                index = Lib.r.nextInt(teamList.size());
                value = teams[index];
                teamList.remove(index);
            }
        } while (value == null);
        System.out.println(teamList);
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
