package Tema10.Ejercicios.Propios.Ejercicio8;

import java.util.HashMap;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;

import Util.Lib;

public class Ejercicio8 {

    int userInt, opcion;
    String userString;
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
            userInt = Integer.parseInt(Lib.myInput.nextLine());
            correct = userInt <= 5 && userInt > 0;
        } while (!correct);

        switch (userInt) {
            case 1:
                System.out.println("Introduce the keyword ");
                String key = userString = Lib.myInput.nextLine();
                System.out.println("Now introduce the meaning for the keyword");
                String value = userString = Lib.myInput.nextLine();
                word.addElement(key, value);
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

    // public void faker(int numElements){
    // Faker f = new Faker;
    // for(int i = 0; i < numElements; i++) {

    // String key = f.animal().name();
    // String value = f.relationships().inLaw();

    // }

    // }

}
