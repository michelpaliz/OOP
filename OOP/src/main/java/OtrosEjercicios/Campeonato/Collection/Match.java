package OtrosEjercicios.Campeonato.Collection;

import java.time.LocalDate;
import java.util.Arrays;

import OtrosEjercicios.Campeonato.Collection.numeric.tTeam;

public class Match {
    private String id;
    private tTeam localTeam;
    private tTeam awayTeam;
    private LocalDate date;
    private int season;
    private int[] result;
    // private boolean localWInner;
    // private boolean awayWinner;

    public Match(String id, tTeam localTeam, tTeam awayTeam, LocalDate date, int[] result, int season) {
        this.id = id;
        this.localTeam = localTeam;
        this.awayTeam = awayTeam;
        this.date = date;
        this.season = season;
        this.result = result;
    }

    @Override
    public String toString() {
        return "Match [awayTeam=" + awayTeam + ", date=" + date + ", id=" + id + ", localTeam=" + localTeam
                + ", result=" + Arrays.toString(result) + ", number of season=" + season + "]\n";
    }

}
