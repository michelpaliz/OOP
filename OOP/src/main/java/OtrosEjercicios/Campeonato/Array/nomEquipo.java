package OtrosEjercicios.Campeonato.Array;

public enum nomEquipo {
    MADRID, BARCELONA, BAYERN, VALENCIA, ATLETICO_MADRID, VILLARREAL;

    public static nomEquipo getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }
}
