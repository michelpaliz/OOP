// package OtrosEjercicios.Campeonato.Collection.interface;
package OtrosEjercicios.Campeonato.Collection.numeric;

public enum tCoach {
    MAIN_COACH, SECOND_COACH, THIRD_COACH;

    public tCoach getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }
}
