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
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((tPlayer == null) ? 0 : tPlayer.hashCode());
        return result;
    }

    

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Player other = (Player) obj;
        if (tPlayer != other.tPlayer)
            return false;
        return true;
    }


    @Override
    public String toString() {
        return "Player " + super.toString() + " [tPlayer=" + tPlayer + "] \n";
    }


    @Override
    public String getId() {
        // TODO Auto-generated method stub
        return super.getId();
    }



}
