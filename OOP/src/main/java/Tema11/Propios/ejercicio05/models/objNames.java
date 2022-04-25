package Tema11.Propios.ejercicio05.models;

public enum objNames {
    ROCK, WOOD, PERL, EGG, SWORD, PEAK;

    public static objNames getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }

    public boolean equalsIgnoreCase(String string) {
        return false;
    }

}
