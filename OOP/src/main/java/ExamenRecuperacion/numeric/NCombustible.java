package ExamenRecuperacion.numeric;

public enum NCombustible {
    DIESEL, GASOLINA, GAS, HIBRIDO, ELECTRICO;

    public NCombustible getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }
}
