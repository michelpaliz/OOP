package TestWorlde.Propio;

import Lib.Util;

public class main {

    public static boolean correct;
    public static int userInt;

    public static void main(String[] args) {
        System.out.println("Vamos a empezar");

        


    }

    public void menu() {

        do {
            System.out.println("*********WORDLE *********");
            System.out.println("0.Salir");
            System.out.println("1.Nuevo Juego");
            userInt = Integer.parseInt(Util.myInput.nextLine());
            correct = userInt <= 1;
        } while (!correct);
        switch (userInt) {
            case 0:
                //
                
                break;
            case 1:
                // Nuevo juego


                break;

        }

    }

}
