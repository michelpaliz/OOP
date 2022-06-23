package Examen.numeric;

public enum String {
    INVIERNO, PRIMAVERA, VERANO;

    public String getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }
}
