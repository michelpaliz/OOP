package OtrosEjercicios.Campeonato.Collection.numeric;

public enum tTeam {
    MADRID, BARCELONA, BAYERN, VALENCIA, ATLETICO_MADRID, VILLARREAL;
    public static tTeam getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }
}
