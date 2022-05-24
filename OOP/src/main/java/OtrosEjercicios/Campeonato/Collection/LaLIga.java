package OtrosEjercicios.Campeonato.Collection;

import java.time.LocalDate;
import java.util.List;

public class LaLIga {
    private LocalDate startDate;
    private LocalDate endDate;
    private int nSeason;
    private List<Match> matches;
    private List<Team> teams;
    private List<Player> players;
    private List<Coach> coaches;

    public LaLIga(LocalDate startDate, LocalDate endDate, int nSeason, List<Match> matches, List<Team> teams,
            List<Player> players, List<Coach> coaches) {
                
        this.startDate = startDate;
        this.endDate = endDate;
        this.nSeason = nSeason;
        this.matches = matches;
        this.teams = teams;
        this.players = players;
        this.coaches = coaches;
    }




    @Override
    public String toString() {
        return "LaLIga [coaches=" + coaches + ", endDate=" + endDate + ", matches=" + matches + ", nSeason=" + nSeason
                + ", players=" + players + ", startDate=" + startDate + ", teams=" + teams + "]";
    }

    


}
