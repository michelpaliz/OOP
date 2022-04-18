package Testing.menu;

import Util.Lib;

public class Arr {

    public Arr() {
        main();
    }

    public void main() {
        char randomizedCharacter = (char) (Lib.r.nextInt(6) + 'a');
        System.out.println("Generated Random Character: " + randomizedCharacter);

    }
}
