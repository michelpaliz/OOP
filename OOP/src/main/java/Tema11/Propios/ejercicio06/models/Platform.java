package Tema11.Propios.ejercicio06.models;

public enum Platform {
    PLAYSTATION4, XBOX, NINTENDO, SWITCH;

    public static Platform getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }

}
