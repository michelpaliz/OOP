package Tema11.Propios.ejercicio06.numeric;

public enum Platforma {
    PLAYSTATION4, XBOX, NINTENDO, SWITCH;

    public static Platforma getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }

}
