package OtrosEjercicios.Campeonato.Collection;

import java.time.LocalDate;
import java.util.List;

import OtrosEjercicios.Campeonato.Collection.base.Club;
import OtrosEjercicios.Campeonato.Collection.numeric.tTeam;

public class Team extends Club {

    // here comes the composition between this class to other classes;
    private final List<Player> players;
    private final List<Coach> coaches;
    private int point;

    public Team(String id, tTeam tTeam, LocalDate fundationDate, String country, String city, List<Player> players,
            List<Coach> coaches, int point) {
        super(id, tTeam, fundationDate, country, city);
        this.players = players;
        this.coaches = coaches;
        this.point = point;
    }

    @Override
    public String getId() {
        return super.getId();
    }

    public List<Coach> getCoaches() {
        return coaches;
    }

    public List<Player> getPlayers() {
        return players;
    }

    @Override
    public String toString() {
        return "Team" + super.toString() + " [coaches=" + coaches + ", players=" + players +", point ="+  point"]+ \n";
    }

}
