package OtrosEjercicios.Campeonato.Collection.numeric;

public enum tPlayer {
    FORWARD, MIDDLEFIELDER, DEFENSE, GOALKEEPER;

    public tPlayer getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }
}
