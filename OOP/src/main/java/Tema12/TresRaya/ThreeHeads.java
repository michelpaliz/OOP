package Tema12.TresRaya;

import Lib.Util;

public class ThreeHeads {
    final int MAX_NUM = 3;
    int head = 0;
    int count = 0;

    public ThreeHeads() {
        startGame();
    }

    public void startGame() {

        while (head < MAX_NUM) {
            int flip = Util.randBetween(0, 2);
            count++;
            if (flip == 0) {
                System.out.println("H");
                head++;
            } else {
                System.out.println("T");
                head++;
            }
        }
        System.out.println("\nIt took " + count + " flips to achieve three heads in a row");
    }

}
