package Examen;

public enum Genero {
    AVENTURAS, FICCIÓN, POLICÍACA,DRAMA;

    public static Genero  getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }
    
}
