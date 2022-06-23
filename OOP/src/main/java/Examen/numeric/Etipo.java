package Examen.numeric;

public enum Etipo {
    INVIERNO, PRIMAVERA, VERANO;

    public Etipo getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }
}
