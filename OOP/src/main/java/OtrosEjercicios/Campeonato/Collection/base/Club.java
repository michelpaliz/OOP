package OtrosEjercicios.Campeonato.Collection.base;

import java.time.LocalDate;

import OtrosEjercicios.Campeonato.Collection.numeric.tTeam;

public class Club {
    private String id;
    private tTeam name;
    private LocalDate fundationDate;
    private String country;
    private String city;

    public Club(String id, tTeam name, LocalDate fundationDate, String country, String city) {
        this.id = id;
        this.name = name;
        this.fundationDate = fundationDate;
        this.country = country;
        this.city = city;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Club [ id=" + id + " city=" + city + ", country=" + country + ", fundationDate=" + fundationDate
                + ", name=" + name + "]";
    }

}
