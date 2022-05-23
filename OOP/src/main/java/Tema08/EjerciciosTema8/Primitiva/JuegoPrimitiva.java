package Tema08.EjerciciosTema8.Primitiva;

//*IMPORTS PARA OPERACIONES
import java.util.Scanner;
import java.util.Set;

import Lib.Util;

import java.util.LinkedHashSet;
import java.util.Random;

public class JuegoPrimitiva {
    // Variables Globales
    // Variable de la clase primitiva
    Primitiva numerosElegidos;
    // Scanner & Random
    Scanner myInput = new Scanner(System.in);
    Random r = new Random();
    // Para uso de Operaciones
    static int[] numeros = new int[Config.MAX_NUMERO_SUERTE];
    int userInt;
    boolean correct;
    int primerNumero, segundoNumero, tercerNumero, cuartoNumero, quintoNumero, sextoNumero;
    // +Todo variable para contar los numeros de intentos

    public void menu() {
        do {
            System.out.println("*******JUEGO DE LA PRIMITIVA ******");
            System.out.println("Para empezar necesitamos que escojas 6 numeros");
            System.out.println("Tienes dos opciones");
            System.out.println("1.Introducir los numeros manualmente");
            System.out.println("2.Introducir los numeros automaticamente");
            userInt = Integer.parseInt(myInput.nextLine());
            correct = userInt > 0 && userInt <= 2;

        } while (!correct);

        switch (userInt) {
            case 1:
                System.out.println("Seleccion de numeros");
                numerosElegidos = new Primitiva(validarNumeros());
                System.out.println(numerosElegidos);
                break;
            case 2:
                System.out.println("El sistema generara 6 numero automaticamente para ti");
                numerosElegidos = new Primitiva(generatorRandom());
                System.out.println(numerosElegidos);
                break;
        }

    }

    public void subMenu() {

        do {
            System.out.println("****ELIGE UNA MODALIDAD DE JUEGO *****");
            System.out.println("1. Juego Unico");
            System.out.println("2.Jugar hasta obtener un premio(con reintegro)");
            System.out.println("3.Jugar hasta obtener un premio (Sin reintegro)");
            System.out.println("4.Ciclo de 1000 sorteos");
            System.out.println("5.Jugar hasta obtener premio categoria especial");
            userInt = Integer.parseInt(myInput.nextLine());
            correct = userInt > 0 && userInt >= 5;

        } while (!correct);

        switch (userInt) {
            case 1:
                System.out.println("");
            case 2:

            case 3:

            case 4:

            case 5:
        }
    }

    /**
     * 
     * @return a set object which stores group of elements, it grows dynamically and
     *         it does not allow duplicate elements.
     */

    public Set<Integer> generatorRandom() {
        Set<Integer> set = new LinkedHashSet<Integer>();
        while (set.size() < Config.MAX_NUMERO_SUERTE) {
            set.add(r.nextInt(49) + 1);
        }
        // System.out.println("Random numbers with no duplicates = " + set);
        return set;
    }

    /**
     * 
     * @return numeros que el jugador a optado
     */

    public int[] validarNumeros() {
        for (int i = 0; i < Config.MAX_NUMERO_SUERTE; i++) {
            do {
                correct = true;
                System.out.print("Introduce un numero (del 1 al 49): ");
                try {
                    userInt = Integer.parseInt(myInput.nextLine());
                    if (userInt < 1 || userInt > 49) {
                        System.out.println("Error: Incorrect integer.");
                        correct = false;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error: El input no es un integer");
                    correct = false;
                }
                for (int j = 0; j < i; j++) {
                    if (numeros[j] == userInt) {
                        System.out.println("Introduce un numero que no hayas escogido");
                        correct = false;
                        break;
                    }
                }
                numeros[i] = userInt;
            } while (!correct);
        }
        return numeros;
    }

    public JuegoPrimitiva() {

        menu();
    }



}
