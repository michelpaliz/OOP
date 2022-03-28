package Tema10.Ejercicios.Propios.Ejercicio8;

import Util.Lib;

public class Ejercicio8 {

    int userInt, opcion;
    boolean correct;
    Gestion diccionario = new Gestion();

    public Ejercicio8() {
        menu();

    }

    public void menu() {
        do {
            System.out.println("MENU");
            System.out.println("1.Anyadir  palabra en el diccionario");
            System.out.println("2.Modificar palabra ");
            System.out.println("3.Eliminar palabra");
            System.out.println("4.Consultar palabra");
            System.out.println("5.Mostrar el diccionario");
            correct = userInt <= 5 && userInt > 0;
        } while (correct);

        switch (userInt) {
            case 1:

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

}
