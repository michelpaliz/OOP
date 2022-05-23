package OtrosEjercicios.Campeonato.Collection;

import OtrosEjercicios.Campeonato.Collection.base.Person;
import OtrosEjercicios.Campeonato.Collection.numeric.tCoach;

public class Coach extends Person {

    private tCoach tCoach;

    public Coach(String id, String name, String lastName, int age, String nacionality, tCoach tCoach) {
        super(id, name, lastName, age, nacionality);
        this.tCoach = tCoach;
    }

    @Override
    public String toString() {
        return "Coach" + super.toString() + " [tCoach=" + tCoach + "] \n";
    }

}
