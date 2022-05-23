package Testing.menu;

import Lib.Util;

public class Arr {

    public Arr() {
        main();
    }

    public void main() {
        char randomizedCharacter = (char) (Util.r.nextInt(6) + 'a');
        System.out.println("Generated Random Character: " + randomizedCharacter);

    }
}
