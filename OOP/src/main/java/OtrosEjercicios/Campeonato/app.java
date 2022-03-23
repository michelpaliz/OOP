package OtrosEjercicios.Campeonato;

import java.util.GregorianCalendar;
import java.util.Scanner;

public class App {
    // reacion de varaibles globales
    public static Equipo equipo = new Equipo();
    // Creacion de variables static
    public static Scanner myInput = new Scanner(System.in);
    // User response
    private static int userInt;
    private String userStr;
    // para la creacion
    public App(){
        menu();
    }

    // Constructor
    // MENU DEL JUEGO
    public void  menu() {
        System.out.println("*******MENU DATOS******");
        System.out.println("Elige una opcion");
        System.out.println("1.  Nuevo Equipo");
        System.out.println("2. Nuevo Jugador");
        System.out.println("3.Generar Datos Aleatorios");
        System.out.println("4.Ver los equipos creados");
        System.out.println("5.Ver tabla de Posiciones");

        userInt = Integer.parseInt(myInput.nextLine());

        switch (userInt) {
            case 0:
                System.out.println("Hasta Luego");
                menu();
                break;
            case 1:
                // Todo Crear Equipos
                
                break;
            case 2:
                // Todo crear nuevo Jugador
                creacionJugador();
                
                menu();
                break;
            case 3:
                equipo.generarDatosAleatorios();
                menu();
                break;
            case 4:
                equipo.mostrarDatosPrueba();
                menu();
                break;
            case 5:
                // Todo Ver tabla de posiciones
                break;
        }
    }

    
    // Para la creacion de un jugador
    public Jugador creacionJugador() {

        System.out.println("Vamos a crear un jugador");
        System.out.println("Introduce el id del jugador (Cuidado el id del jugador no puede estar ya escogido )");
        int id = userInt = Integer.parseInt(myInput.nextLine());
        System.out.println("Introduce el nombre del jugador");
        String nombre = userStr = myInput.nextLine();
        System.out.println("Introduce el apellido de jugador");
        String apellido = userStr = myInput.nextLine();
        /// ---------
        GregorianCalendar edad = new GregorianCalendar();
        System.out.println("Introduce el anyo de nacimiento del jugador");
        int year = userInt = Integer.parseInt(myInput.nextLine());
        System.out.println("Introcde el mes de nacimiento");
        int month = userInt = Integer.parseInt(myInput.nextLine());
        System.out.println("Introduce el dia de nacimiento");
        int date = userInt = Integer.parseInt(myInput.nextLine());
        edad.set(year, month, date);
        System.out.println("Introduce la posicion del jugador");
        Posicion pos = elegirPosicion();
        Jugador jugador = new Jugador(id, nombre, apellido, edad, pos);
        System.out.println("Jugador creado");
        System.out.println(jugador);
        return jugador;
    }

    public Posicion elegirPosicion() {
        Posicion pos = Posicion.DEFENSA;

        do {
            System.out.println("1.Delatero");
            System.out.println("2.Mediocampista");
            System.out.println("3.Defensa");
            System.out.println("4.Portero");
            userInt = Integer.parseInt(myInput.nextLine());
        } while (userInt >= 4 && userInt < 0);
        switch (userInt) {
            case 1:
                pos = Posicion.DELANTERO;
                break;
            case 2:
                pos = Posicion.MEDIOCAMPISTA;
                break;
            case 3:
                pos = Posicion.DEFENSA;
                break;
            case 4:
                pos = Posicion.PORTERO;
                break;
        }
        return pos;
    }


    
}
