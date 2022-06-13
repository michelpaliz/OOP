package Tema11.Propios.ejercicio06.numeric;

public enum Formato {
    CD, DVD, BLUE_RAY, FOLDER;
    public static Formato getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }

}
