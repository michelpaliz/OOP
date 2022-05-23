package Tema08.EjerciciosTema8.Ejercicio6;

public enum Modelo {
    CARRETERA, MONTANYA, COMPETICION;

    public static Modelo getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }
}
