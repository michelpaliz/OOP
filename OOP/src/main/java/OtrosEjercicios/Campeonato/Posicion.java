package OtrosEjercicios.Campeonato;

public enum Posicion {
    DELANTERO, MEDIOCAMPISTA, DEFENSA, PORTERO;

    public static Posicion getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }

}
