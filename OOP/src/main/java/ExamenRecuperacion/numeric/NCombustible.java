package ExamenRecuperacion.numeric;

public enum NCombustible {
    DIESEL, GASOLINA, ELECTRICO;

    public NCombustible getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }
}
