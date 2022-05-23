package Tema11.Propios.ejercicio04.model;

public enum Color {
    WHITE, BLACK, BLUE, GREY;
    
    public static Color getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }

}
