package EjerciciosTema8.Ejercicio6;

public enum Marca {
    SPECIALIZED, TRECK, SCOTT, CERVELO, SANTA;

    public static Marca getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }
}
