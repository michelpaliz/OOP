package OtrosEjercicios.Campeonato;

import java.util.Scanner;

public class app {
    // Creacion de variables static
    public static Scanner myInput = new Scanner(System.in);    
    // User response
    private int userInt;
    private String userStr;




    public void menu() {

        System.out.println("*******MENU DATOS******");
        System.out.println("Elige una opcion");
        System.out.println("1.  Nuevo Equipo");
        System.out.println("2. Nuevo Jugador");
        System.out.println("3.Consultas");
        userInt = Integer.parseInt(myInput.nextLine());

        switch (userInt) {
            case 1:

                System.out.println("");
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
        }

    }

    public app(){

    }
}
