package Examen.numeric;

public enum Enombre {
    INVIERNO, PRIMAVERA, VERANO;

    public Enombre getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }
}
