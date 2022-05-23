package Tema10.Ejercicios.Propios.Ejercicio8;

import Lib.Util;

public class Ejercicio8 {

    int userInt, opcion;
    String key, value;
    boolean correct;
    Gestion word = new Gestion();

    public Ejercicio8() {
        System.out.println("Let's start");
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
            userInt = Integer.parseInt(Util.myInput.nextLine());
            correct = userInt <= 5 && userInt > 0;
        } while (!correct);

        switch (userInt) {
            case 1:
                System.out.println("Introduce the keyword ");
                key = Util.myInput.nextLine();
                System.out.println("Now introduce the meaning for the keyword");
                value = Util.myInput.nextLine();
                word.addElement(key, value);
                menu();
                break;
            case 2:
                System.out.println("Introduce the keyword");
                key = Util.myInput.nextLine();
                System.out.println("And now introduce the value that you want to replace");
                value  = Util.myInput.nextLine();
                word.replace(key, value);
                menu();
                break;
            case 3:
                System.out.println("Introduce the key that you want to delete");
                key  = Util.myInput.nextLine();
                word.remove(key);
                menu();
                break;
            case 4:
                System.out.println("Introduce the key that you want to delete");
                key  = Util.myInput.nextLine();
                word.show(key);
                menu();
                break;
            case 5:
                System.out.println(word.diccionario.keySet());
                menu();
                break;
        }

    }



}
