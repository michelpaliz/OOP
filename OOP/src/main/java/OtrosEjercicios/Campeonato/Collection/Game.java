package OtrosEjercicios.Campeonato.Collection;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.github.javafaker.Faker;

import Lib.Control;
import Lib.Util;
import OtrosEjercicios.Campeonato.Collection.numeric.tCoach;
import OtrosEjercicios.Campeonato.Collection.numeric.tPlayer;
import OtrosEjercicios.Campeonato.Collection.numeric.tSeason;
import OtrosEjercicios.Campeonato.Collection.numeric.tTeam;

public class Game {
    Player p;
    Coach c;
    Team t;
    Match m;
    List<Team> teamList;
    List<Player> playerList;
    List<Coach> coachList;
    List<Match> matchList;
    Faker fk = new Faker();
    final int maxPlayer = 12;
    final int maxCoach = 3;
    final int maxTeam = 2;
    final int maxMatch = 18;
    String usr;
    int usrInt;
    boolean correct;

    public Game() {
        System.out.println(gntMatches());
        // sortSeason(1);
        // mainMenu();

    }

    public boolean mainMenu() {
        String tittle = "START GAME";
        String[] sentence = { "EXIT", "GENERATE NEW TEAM", "CREATE NEW", "SEARCH", "GAME", "SHOW DB" };
        usrInt = Control.menuGenerator(tittle, sentence);
        switch (usrInt) {
            case 0:
                System.out.println("See you soon");
                return false;
            case 1:
                System.out.println("generate data");
                System.out.println(gnTeam());
                break;
            case 2:
                if (addElement() == false) {
                    System.out.println("Do you want to try again ?");
                    usr = Util.checkAnswer("Yes", "No");
                    if (usr.equalsIgnoreCase("yes")) {
                        addElement();
                    }
                }
                break;
            case 3:
                System.out.println("What do you want to search?");
                String[] options = { "Player", "Coach" };
                String option = Control.checkOptions(options);
                if (option.equalsIgnoreCase("Player")) {
                    seekPlayer();
                } else {
                    createCoach();
                }
                break;
            case 4:
                System.out.println("Generate Games");

                break;
            case 5:
                showDB();
                break;
        }
        Util.pause();
        mainMenu();
        // Util.cleanScreen();
        return true;

    }

    // *Generate Random DATA
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
            String id = "B" + (fk.number().digits(8));
            tTeam = tTeam.getRandom();
            LocalDate fundationDate = Control.rndLocalDate();
            String country = fk.country().name();
            String city = fk.country().capital();
            t = new Team(id, tTeam, fundationDate, country, city, gnPlayer(), gnCoach());
            teamList.add(t);
        }
        return teamList;
    }

    // let's generate some matches for the championship

    public List<Match> gntMatches() {
        matchList = new ArrayList<>(maxTeam);
        tTeam localTeam, awayTeam;
        LocalDate date;
        LocalDate minDate = LocalDate.of(2021, 1, 01);
        for (int i = 0; i < maxMatch; i++) {
            String id = "M" + (fk.number().digits(4));
            do {
                localTeam = tTeam.getRandom();
                awayTeam = tTeam.getRandom();
                // localTeam = (tTeam) Control.selectEnum(tTeam.values());
                // awayTeam = (tTeam) Control.selectEnum(tTeam.values());
            } while (localTeam == awayTeam);
            date = Control.rndLD(minDate, LocalDate.now());
            int season = giveSeason(date);
            int[] result = new int[] { fk.random().nextInt(0, 5), fk.random().nextInt(0, 5) };

            m = new Match(id, localTeam, awayTeam, date, result, season);

            matchList.add(m);
        }
        System.out.println("Random data created");
        return matchList;
    }

    // *Create a new player or coach
    public Coach createCoach() {
        String id = Control.DNIgeneratorChar(fk.number().digits(8));
        System.out.println("Write the name");
        String name = Util.myInput.nextLine();
        System.out.println("Write the lastName");
        String lastName = Util.myInput.nextLine();
        System.out.println("Write the age");
        int age = Integer.parseInt(Util.myInput.nextLine());
        System.out.println("Write the nacionality");
        String nacionality = Util.myInput.nextLine();
        tCoach tCoach = (OtrosEjercicios.Campeonato.Collection.numeric.tCoach) Control
                .selectEnum(OtrosEjercicios.Campeonato.Collection.numeric.tCoach.values());
        c = new Coach(id, name, lastName, age, nacionality, tCoach);
        return c;
    }

    public Player createPlayer() {
        String id = Control.DNIgeneratorChar(fk.number().digits(8));
        System.out.println("Write the name");
        String name = Util.myInput.nextLine();
        System.out.println("Write the lastName");
        String lastName = Util.myInput.nextLine();
        System.out.println("Write the age");
        int age = Integer.parseInt(Util.myInput.nextLine());
        System.out.println("Write the nacionality");
        String nacionality = Util.myInput.nextLine();
        tPlayer tPlayer = (OtrosEjercicios.Campeonato.Collection.numeric.tPlayer) Control
                .selectEnum(OtrosEjercicios.Campeonato.Collection.numeric.tPlayer.values());
        p = new Player(id, name, lastName, age, nacionality, tPlayer);
        return p;
    }

    // *Add the player or coach you've created to a specific team
    public Team seekTeam() {

        do {
            System.out.println("Introduce the id of the team");
            String id = Util.myInput.nextLine();
            for (Team team : teamList) {
                if (team.getId().equalsIgnoreCase(id)) {
                    System.out.println(team.getId());
                    return team;
                } else {
                    correct = false;
                }
            }
            System.out.println("Introduce a valid id");
        } while (correct = true);

        return null;
    }

    public Player seekPlayer() {
        System.out.println("First introduce the id of the team where you want to add the new element");
        t = seekTeam();
        do {
            System.out.println("Introduce the id of the player");
            String id = Util.myInput.nextLine();
            for (Player p : t.getPlayers()) {
                if (p.getId().equalsIgnoreCase(id)) {
                    return p;
                } else {
                    correct = false;
                }
            }
            System.out.println("Introduce a valid id");
        } while (correct);

        return null;
    }

    public Coach seekCoach() {
        System.out.println("First introduce the id of the team where you want to add the new element");
        t = seekTeam();
        do {
            System.out.println("Introduce the id of the player");
            String id = Util.myInput.nextLine();
            for (Coach c : t.getCoaches()) {
                if (c.getId().equalsIgnoreCase(id)) {
                    return c;
                } else {
                    correct = false;
                }
            }
            System.out.println("Introduce a valid id");
        } while (correct);

        return null;
    }

    // *Here you can add as coach or player as you'd like
    public boolean addElement() {
        System.out.println("What would you like to create, Player or a Coach?");
        usr = Util.checkAnswer("Coach", "Player");
        if (usr.equalsIgnoreCase("player")) {
            if (t.getPlayers().size() < maxPlayer) {
                t.getPlayers().add((createPlayer()));
                System.out.println("Player added successfully");
                return true;
            } else {
                System.out.println(
                        "The maximum number has been added.\nYou must remove a player in order to suscribe this one");
                p = seekPlayer();
                t.getPlayers().remove(p);
                System.out.println("Player removed successfully");
                return false;
            }
        } else {
            if (t.getCoaches().size() < maxPlayer) {
                t.getCoaches().add((createCoach()));
                return true;
            } else {
                System.out.println(
                        "The maximum number has been added.\nYou must remove a coach in order to suscribe this one");
                c = seekCoach();
                t.getCoaches().remove(c);
                return false;
            }
        }

    }

    // *Show DataBase
    public void showDB() {
        System.out.println("Show");
        System.out.println(teamList);
    }

    // * CREATING LOGIC FOR THE GAME
    // sort games by seasons
    public void sortSeason(int season) {
        System.out.println("Sort by Season");
        for (int i = 0; i < matchList.size(); i++) {
            if (matchList.get(i).getSeason() == season) {
                System.out.println(matchList.get(i));
            }
        }
    }

    public int giveSeason(LocalDate date) {
        LocalDate s1 = LocalDate.of(2021, 9, 1);
        LocalDate s2 = LocalDate.of(2022, 3, 1);
        LocalDate s3 = LocalDate.of(2022, 6, 1);
        int season = 0;

        if (date.isBefore(s3)) {
            season = 3;
            return season;
        } else if (date.isBefore(s2)) {
            season = 2;
            return season;
        } else {
            season = 1;
            return season;
        }
    }

}
