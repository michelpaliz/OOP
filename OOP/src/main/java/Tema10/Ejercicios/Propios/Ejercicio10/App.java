package Tema10.Ejercicios.Propios.Ejercicio10;

import Util.Lib;

public class App {

    int userInt;
    String userStr;

    public App() {

        Empresa e = new Empresa();

    }

    public Empleado addEmpleado() {
        System.out.println("Inserte el id del empleado");
        userInt = Lib.myInput.nextInt();
        System.out.println("Inserte el nombre del empleado");
        userStr = Lib.myInput.nextLine();
        System.out.println("Inserte el apellido del empleado");
        userStr = Lib.myInput.nextLine();
        System.out.println("Insert la fecha de nacimiento del empleado");

        

        return null;

    }

    // Logica del juego

}