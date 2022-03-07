package OtrosEjercicios.Campeonato;

import java.util.Scanner;

public class Organizacion {

    private static Scanner myInput = new Scanner(System.in);
    private int userInt;
    private String userStr;
    private boolean correct;

    public void menu() {

        do {
            System.out.println("******MENU******");
            System.out.println("1.Equipo");
            System.out.println("2.Jugador");
            System.out.println("3.Consultas");
            System.out.println("0.Salir");
            userInt = Integer.parseInt(myInput.nextLine());
            correct = userInt <= 3;
        } while (!correct);
        switch (userInt) {

            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;

        }
    }

    public Organizacion() {

    }

}
