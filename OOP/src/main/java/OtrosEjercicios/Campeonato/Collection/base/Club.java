package OtrosEjercicios.Campeonato.Collection.base;

import java.time.LocalDate;

import OtrosEjercicios.Campeonato.Collection.numeric.tTeam;

public class Club {
    private tTeam name;
    private LocalDate fundationDate;
    private String country;
    private String city;
    
    public Club(tTeam name, LocalDate fundationDate, String country, String city) {
        this.name = name;
        this.fundationDate = fundationDate;
        this.country = country;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Club [city=" + city + ", country=" + country + ", fundationDate=" + fundationDate + ", name=" + name
                + "]";
    }
}
