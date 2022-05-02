package Tema11.Propios.ejercicio05;

import java.util.Arrays;

import com.github.javafaker.Faker;

import Lib.MyArr;
import Tema11.Propios.ejercicio05.models.Inventary;
import Tema11.Propios.ejercicio05.models.Egg;
import Tema11.Propios.ejercicio05.models.Element;
import Tema11.Propios.ejercicio05.models.Peak;
import Tema11.Propios.ejercicio05.models.Perl;
import Tema11.Propios.ejercicio05.models.Rock;
import Tema11.Propios.ejercicio05.models.Sword;
import Tema11.Propios.ejercicio05.models.Wood;
import Tema11.Propios.ejercicio05.models.objNames;

public class Play {

    private final int INITIALIZER_X = 4;
    private final int INITIALIZER_Y = 4;
    // Create atributtes fort the arrays
    private double x;
    private double y;
    // we also need to create an array
    // private Inventary[][] inventary = new
    // Inventary[INITIALIZER_X][INITIALIZER_Y];
    private Inventary[] inventary = new Inventary[INITIALIZER_X];
    private Egg egg;
    private Perl perl;
    private Peak peak;
    private Sword sword;
    private Rock rock;
    private Wood wood;
    private Egg[] eggs = new Egg[INITIALIZER_X];
    private Perl[] perls = new Perl[INITIALIZER_X];
    private Peak[] peaks = new Peak[INITIALIZER_X];
    private Sword[] swords = new Sword[INITIALIZER_X];
    private Rock[] rocks = new Rock[INITIALIZER_X];
    private Wood[] woods = new Wood[INITIALIZER_X];
    // we store the wided array in this variable in order to use it afterwards
    // private Inventary[] totalArr = new Inventary[8];
    private Inventary[] totalArr;
    private Element element;
    private Element[] elements = new Element[INITIALIZER_X];

    public Play() {
        // System.out.println((dataBase()));
        fillValues();
        System.out.println(Arrays.toString(dataBase()));
        // System.out.println(Arrays.toString(eggs));
        // totalArr = (Inventary[]) MyArr.mergeObj(rocks, eggs);
        // System.out.println(Arrays.toString((Inventary[]) totalArr));
        // printArray2D(dataBase());
        // System.out.println(Arrays.toString(dataBase()));
    }

    public void fillValues() {
        Faker faker = new Faker();
        objNames name = objNames.EGG;
        int number = 0;
        for (int x = 0; x < inventary.length; x++) {
            // egg = new Egg(faker.random().nextInt(1, 15));
            // perl = new Perl(faker.random().nextInt(1, 15));
            // peak = new Peak(faker.random().nextInt(1, 1));
            // sword = new Sword(faker.random().nextInt(1, 1));
            // wood = new Wood(faker.random().nextInt(1, 63));
            // rock = new Rock(faker.random().nextInt(1, 63));
            name = objNames.getRandom();
            number = faker.random().nextInt(1, 63);
            element = new Element(name, number);
            elements[x] = element;

            eggs[x] = egg;
            perls[x] = perl;
            peaks[x] = peak;
            swords[x] = sword;
            rocks[x] = rock;
            woods[x] = wood;

            // inventary[x] = new Inventary(eggs[x]);
            // inventary[x] = new Inventary(perls[x]); inventary[x] = new
            // Inventary(eggs[x]);
            // inventary[x] = new Inventary(swords[x]);
            // inventary[x] = new Inventary([x]);
            // inventary[x] = new Inventary(perls[x]); inventary[x] = new
            // Inventary(eggs[x]);
            // inventary[x] = new Inventary(perls[x]);
        }
    }

    public Inventary[] dataBase() {
        for (int x = 0; x < inventary.length; x++) {
            inventary[x] = new Inventary(elements[x]);
        }
        return inventary;
    }

    // public Inventary[][] dataBase() {

    // for (int x = 0; x < inventary.length; x++) {
    // for (int y = 0; y < inventary[0].length; y++) {
    // // inventary[x][y] = new Inventary(eggs[x]);
    // inventary[x]= new Inventary(MyArr.getRndValueArr(totalArr));
    // }
    // }

    // return inventary;
    // }

    public <T> void printArray2D(T matrix[][]) {
        for (int i = 0; i < matrix.length; i++) { // this equals to the row in our matrix.
            for (int j = 0; j < matrix[i].length; j++) { // this equals to the column in each row.
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println(); // change line on console as row comes to end in the matrix.
        }
    }

}
