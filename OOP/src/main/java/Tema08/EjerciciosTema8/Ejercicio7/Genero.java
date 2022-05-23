package Tema08.EjerciciosTema8.Ejercicio7;

public enum Genero {
    MASCULINO,FEMENINO, TRANSEXUAL;
    public static Genero  getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }
    
}
