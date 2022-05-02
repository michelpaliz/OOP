package Tema11.Propios.ejercicio07;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import Lib.Control;
import Lib.Util;
import Tema11.Propios.ejercicio07.models.Match;

public class DataBase {
    String[] teams = { "MADRID", "BARCELONA", "ATLETICO_MADRID", "VALENCIA" };
    static ArrayList<String> teamList = new ArrayList<String>();

    final int MAX_MATCHES = 5;
    static HashMap<Integer, Match> matches = new HashMap<>();
    Match match;
    String localTeam, awayTeam;
    // Match[] arrMatch = new Match[20];

    public DataBase() {
        // Displaying HashMap
        teamList.add("MADRID");
        teamList.add("BARCELONA");
        teamList.add("ATLETICO_MADRID");
        teamList.add("VALENCIA");
        // randomValues();

        // check element is present or not. if not loop will
        // break.

    }

    public Match matchSelected(int ref) {

        for (Entry<Integer, Match> entry : matches.entrySet()) {
            Integer key = entry.getKey();
            // Match value = entry.getValue();
            if (ref == key)
                return match = matches.get(key);
        }
        return null;

    }

    public void randomValues() {

        LocalDate date;
        for (int i = 0; i < 16; i++) {

            do {
                localTeam = teamList.get(getRandom(teamList));
                awayTeam = teamList.get(getRandom(teamList));
            } while (localTeam == awayTeam);

            date = Control.rndLocalDate();
            match = new Match(i, localTeam, awayTeam, date);
            matches.put(i, match);
        }
        System.out.println("Random data created");
        // System.out.println(matches + "\n");
        // for (Integer match : matches.keySet()) {
        // System.out.println(match + " = " + matches.get(match));
        // }
    }

    public void showDB() {
        for (Integer match : matches.keySet()) {
            System.out.println(match + " = " + matches.get(match));
        }
    }

    public int getRandom(ArrayList<String> array) {
        int index = 0;
        index = Util.r.nextInt(array.size());
        return index;

    }

    public String getRandomList() {
        String value = "";
        int index;
        do {
            System.out.println(teamList.size());
            for (int i = 0; i < teamList.size(); i++) {
                index = Util.r.nextInt(teamList.size());
                value = teams[index];
                teamList.remove(index);
            }
        } while (value == null);
        System.out.println(teamList);
        return value;
    }

}
