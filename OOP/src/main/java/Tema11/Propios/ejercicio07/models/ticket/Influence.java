package Tema11.Propios.ejercicio07.models.ticket;

public enum Influence {
    LOW_INFLUENCE, MEDIUM_INFLUENCE, HIGH_INFLUENCE;

    public static Influence getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }
}
