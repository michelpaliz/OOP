package EjerciciosTema8.Ejercicio7;

public enum Sintomatologia {
    DOLOR_ABDOMINAL, MAREO_GENERALIZADO, DOLOR_PECHO, ESCALOFRIOS, MIGRAÑA, CONTUSION_EXTREMIDADES;

    public static Sintomatologia getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }

}
