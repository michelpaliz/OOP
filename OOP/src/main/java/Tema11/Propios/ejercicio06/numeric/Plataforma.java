package Tema11.Propios.ejercicio06.numeric;

public enum Plataforma {
    PLAYSTATION4, XBOX, NINTENDO, SWITCH;

    public static Plataforma getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }

}
