package Tema11.Propios.ejercicio05;

import Tema11.Propios.ejercicio05.models.Craft;
import Tema11.Propios.ejercicio05.models.Egg;
import Tema11.Propios.ejercicio05.models.Peak;

public class Inventary {

    private final int INITIALIZER_X = 4;
    private final int INITIALIZER_Y = 4;
    // Create atributtes fort the arrays
    private double x;
    private double y;
    // we also need to create an array
    Inventary[][] inventary = new Inventary[INITIALIZER_X][INITIALIZER_Y];

    public Inventary() {
        Egg egg = new Egg(80);
        egg.addElement(70);
        System.out.println(egg);
        Peak peak = new Peak();
        System.out.println(peak);
    }

    // public Craft[] dataBase(){
    // for (int x = 0; x < inventary.length; x++) {
    // for(int y = 0; y < inventary.length ; y++) {
    // inventary[x][y] =
    // }
    // }

    // return null;
    // }

}
