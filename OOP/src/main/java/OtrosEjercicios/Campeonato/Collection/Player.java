package OtrosEjercicios.Campeonato.Collection;

import OtrosEjercicios.Campeonato.Collection.base.Person;
import OtrosEjercicios.Campeonato.Collection.numeric.tPlayer;

public class Player extends Person {

    private tPlayer tPlayer;

    public Player(String id, String name, String lastName, int age, String nacionality, tPlayer tPlayer) {
        super(id, name, lastName, age, nacionality);
        this.tPlayer = tPlayer;
    }

    @Override
    public String toString() {
        return "Player " + super.toString() + " [tPlayer=" + tPlayer + "] \n";
    }

}
