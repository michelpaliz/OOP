package Tema9.EjerciciosTm9;

import java.util.Calendar;

import javax.naming.spi.DirStateFactory.Result;

import Util.Lib;

public class Ejercicio10 {

    public double userDouble;
    public int userInt;
    public boolean correct;

    public static void Ejercicio10() {

    }

    public void calculadoraManual() {

        System.out.println("********** CALCULADORA ***********");
        System.out.println("Introduce el primer numero");
        userInt = Integer.parseInt(Lib.myInput.nextLine());
        char operator;
        double num1, num2;
        System.out.println("Enter the operator (+,-,*,/)");
        operator = Lib.myInput.next().charAt(0);
        System.out.println("Enteer the two numbers one by one");
        num1 = Lib.myInput.nextDouble();
        num2 = Lib.myInput.nextDouble();

        switch (operator) {
            case '+':
                System.out.printf("%f2.2 + %f2.2 = %f2.2", num1, num2, (num1 + num2));
                break;
            case '/':
                System.out.printf("%f2.2 / %f2.2 = %f2.2", num1, num2, (num1 / num2));
                break;
            case '-':
                System.out.printf("%f2.2 - %f2.2 = %f2.2", num1, num2, (num1 - num2));
                break;
            case '*':
                System.out.printf("%f2.2 * %f2.2 = %f2.2", num1, num2, (num1 * num2));
            default:
                System.out.println("Enter a valid operator");
                break;
        }

    }

    public void menu() {

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

                break;
            case 3:
        }

    }

}
