package OtrosEjercicios.Campeonato;

import java.util.Scanner;

public class App {
    // reacion de varaibles globales
    public static Equipo equipo = new Equipo();
    // Creacion de variables static
    public static Scanner myInput = new Scanner(System.in);
    // User response
    private static int userInt;
    private String userStr;

    // Constructor
    public App() {
        menu();
    }

    // ENU DEL JUEGO
    public static void menu() {
        System.out.println("*******MENU DATOS******");
        System.out.println("Elige una opcion");
        System.out.println("1.  Nuevo Equipo");
        System.out.println("2. Nuevo Jugador");
        System.out.println("3.Generar Datos Aleatorios");
        System.out.println("4.Ver los equipos creados");
        System.out.println("5.Ver tabla de Posiciones");

        userInt = Integer.parseInt(myInput.nextLine());

        switch (userInt) {
            case 1:

                break;
            case 2:
                break;
            case 3:
                equipo.generarDatosAleatorios();
                break;
            case 4:
                equipo.mostrarDatosPrueba();
                break;
            case 5:
                break;
        }
    }

}
