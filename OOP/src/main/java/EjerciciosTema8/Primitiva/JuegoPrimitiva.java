package EjerciciosTema8.Primitiva;

//*IMPORTS LIBRERIAS
import util.Lib;

//*IMPORTS PARA OPERACIONES
import java.util.Scanner;

public class JuegoPrimitiva {
    // Variables Globales
    // Scanner & Random
    Scanner myInput = new Scanner(System.in);
    // Operaciones
    int[] numeros = new int[Config.MAX_NUMERO_SUERTE];
    int userInt;
    boolean correct;
    int primerNumero, segundoNumero, tercerNumero, cuartoNumero, quintoNumero, sextoNumero;

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
                Primitiva numeros = new Primitiva(validarNumeros());
                System.out.println(numeros);
                break;
            case 2:
                System.out.println("El sistema generara 6 numero automaticamente para ti");

        }
    }

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
