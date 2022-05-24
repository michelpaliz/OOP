package OtrosEjercicios.Campeonato.Collection.numeric;

public enum tSeason {
    First_Season, Secon_Season, Third_Season;

    public tSeason getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }
}
