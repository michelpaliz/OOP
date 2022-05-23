package Tema11.Propios.ejercicio06.models;

public enum Format {
    CD, DVD, BLUE_RAY, FOLDER;
    public static Format getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }

}
