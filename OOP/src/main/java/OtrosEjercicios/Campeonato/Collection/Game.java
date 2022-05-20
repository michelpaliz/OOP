package OtrosEjercicios.Campeonato.Collection;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.github.javafaker.Faker;

import Lib.Control;
import Lib.Util;
import OtrosEjercicios.Campeonato.Collection.numeric.tCoach;
import OtrosEjercicios.Campeonato.Collection.numeric.tPlayer;
import OtrosEjercicios.Campeonato.Collection.numeric.tTeam;

public class Game {
    Player p;
    Coach c;
    Team t;
    List<Team> teamList;
    List<Player> playerList;
    List<Coach> coachList;
    Faker fk = new Faker();
    final int maxPlayer = 12;
    final int maxCoach = 3;
    final int maxTeam = 4;
    String usr;
    int usrInt;

    public Game() {
        String tittle = "START GAME";
        String[] sentence = { "EXIT", "GENERATE NEW TEAM", "CREATE NEW PLAYER", "CREATE NEW COACH", "EXIT" };
        usrInt = Control.menuGenerator(tittle, sentence);
        switch (usrInt) {
            case 0:
                System.out.println("See you soon");
                break;
            case 1:
                System.out.println("generate data");
                // System.out.println(gnPlayer());
                // System.out.println(gnCoach());
                System.out.println(gnTeam());
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
        }
    }

    public List<Player> gnPlayer() {
        playerList = new ArrayList<>(maxPlayer);
        tPlayer tPlayer = OtrosEjercicios.Campeonato.Collection.numeric.tPlayer.DEFENSE;
        for (int i = 0; i < maxPlayer; i++) {
            String id = Control.DNIgeneratorChar(fk.number().digits(8));
            String name = fk.name().firstName();
            String lastName = fk.name().lastName();
            int age = fk.random().nextInt(18, 30);
            String nacionality = fk.country().name();
            tPlayer = tPlayer.getRandom();
            p = new Player(id, name, lastName, age, nacionality, tPlayer);
            playerList.add(p);
        }
        return playerList;
    }

    public List<Coach> gnCoach() {
        coachList = new ArrayList<>(maxCoach);
        tCoach tCoach = OtrosEjercicios.Campeonato.Collection.numeric.tCoach.MAIN_COACH;
        for (int i = 0; i < maxCoach; i++) {
            String id = Control.DNIgeneratorChar(fk.number().digits(8));
            String name = fk.name().firstName();
            String lastName = fk.name().lastName();
            int age = fk.random().nextInt(18, 30);
            String nacionality = fk.country().name();
            tCoach = tCoach.getRandom();// TODO Try to get values without duplicates so we can have the 3 coaches
            c = new Coach(id, name, lastName, age, nacionality, tCoach);
            coachList.add(c);
        }
        return coachList;
    }

    public List<Team> gnTeam() {
        teamList = new ArrayList<>(maxTeam);
        tTeam tTeam = OtrosEjercicios.Campeonato.Collection.numeric.tTeam.ATLETICO_MADRID;
        for (int i = 0; i < maxTeam; i++) {
            tTeam = tTeam.getRandom();
            LocalDate fundationDate = Control.rndLocalDate();
            String country = fk.country().name();
            String city = fk.country().capital();

            t = new Team(tTeam, fundationDate, country, city, gnPlayer(), gnCoach());
            teamList.add(t);
        }
        return teamList;
    }

}
