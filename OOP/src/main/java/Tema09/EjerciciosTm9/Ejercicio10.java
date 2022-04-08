package Tema09.EjerciciosTm9;

import Util.Lib;

public class Ejercicio10 {

    public double userDouble;
    public static int userInt;
    public static boolean correct;

    public static void Ejercicio10() {
        menu();

    }

    public static void calculadoraManual() {
        char operator;
        double num1, num2;
        String alphabet = "abcdefjhijkmnlopqstrz";

        do {
            System.out.println("********** CALCULADORA ***********");

            System.out.println("Introduce el primer numero");
            num1 = Lib.myInput.nextDouble();
            System.out.println("Enter the operator (+,-,*,/)");
            operator = Lib.myInput.next().charAt(0);
            System.out.println("Introduce el segundo numero");
            num2 = Lib.myInput.nextDouble();

            for (int i = 0; i < 50; i++) {
                num2 = (alphabet.charAt(Lib.r.nextInt(alphabet.length())));
            }

        } while (!correct);
        switch (operator) {
            case '+':
                System.out.printf("%.2f + %.2f = %.2f", num1, num2, (num1 + num2));
                break;
            case '/':
                System.out.printf("%.2f / %.2f = %.2f", num1, num2, (num1 / num2));
                break;
            case '-':
                System.out.printf("%.2f - %.2f = %.2f", num1, num2, (num1 - num2));
                break;
            case '*':
                System.out.printf("%.2f * %.2f = %.2f", num1, num2, (num1 * num2));
                break;
            default:
                System.out.println("Enter a valid operator");
                break;
        }

    }

    public static void calculadoraAutomatica() {
        char operator;
        double num1, num2;

        try {

            do {
                System.out.println("********** CALCULADORA ***********");
                num1 = Lib.randomDouble(0, 100);
                System.out.println("Enter the operator (+,-,*,/)");
                operator = Lib.myInput.next().charAt(0);
                num2 = Lib.randomDouble(0, 100);

            } while (!correct);

            switch (operator) {
                case '+':
                    System.out.printf("%.2f + %.2f = %.2f", num1, num2, (num1 + num2));
                    break;
                case '/':
                    System.out.printf("%.2f / %.2f = %.2f", num1, num2, (num1 / num2));
                    break;
                case '-':
                    System.out.printf("%.2f - %.2f = %.2f", num1, num2, (num1 - num2));
                    break;
                case '*':
                    System.out.printf("%.2f * %.2f = %.2f", num1, num2, (num1 * num2));
                    break;
                default:
                    System.out.println("Enter a valid operator");
                    break;
            }

        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    public static void menu() {

        do {
            System.out.println("0.Salir");
            System.out.println("1.Juego Manual");
            System.out.println("2.Juego Atumatico");
            userInt = Integer.parseInt(Lib.myInput.nextLine());
            correct = userInt < 3;
        } while (!correct);

        switch (userInt) {
            case 1:
                calculadoraManual();
                break;
            case 2:
                calculadoraAutomatica();
                break;
            case 3:
        }

    }

}
