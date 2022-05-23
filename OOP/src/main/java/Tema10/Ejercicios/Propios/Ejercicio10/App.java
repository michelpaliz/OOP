package Tema10.Ejercicios.Propios.Ejercicio10;

import java.util.GregorianCalendar;

import Lib.Control;
import Lib.Util;
import Tema08.EjemplosTema8.Tema8Adv.Cajero.util.Bombo;
import Tema10.Ejercicios.Clases.ejercicio05.Consulta;

public class App {
    Empresa empresa;
    int cantidad;
    String userStr;
    boolean correct;

    public App() {
        System.out.println("INTRODUCE LA CANTIDAD DE EMPLEADOS QUE QUIERES PARA AL EMPRESA");
        cantidad = Integer.parseInt(Util.myInput.nextLine());
        empresa = new Empresa(cantidad);
        System.out.println("INTRODUCE UN EMPLEADO ");
        correct = addEmpleado();

    }

    public boolean addEmpleado() {
        Empleado nuevoEmpleado;
        System.out.println("El id se genera automaticamente ");
        int cantidadElementos = (cantidad) + 1;
        int valorMinimo = (cantidad) + 1;
        Bombo bombo = new Bombo(cantidadElementos, valorMinimo);
        int id = bombo.extraerBola();
        System.out.println("Inserte el nombre del empleado");
        String nombre = Util.myInput.nextLine();
        System.out.println("Inserte el apellido del empleado");
        String apellido = Util.myInput.nextLine();
        System.out.println("Insert la fecha de nacimiento del empleado");
        GregorianCalendar fecha = Control.birthFormat();
        System.out.println("Introduce el salario");
        double salario = Double.parseDouble(Util.myInput.nextLine());
        String message = "El empleado tiene hijo s/n";
        char[] validate = { 's' };
        boolean answer = Control.one(message, validate);
        if (answer == true) {
            System.out.println("Introduce el nombre del hijo");
            String nomHijo = Util.myInput.nextLine();
            System.out.println("Introude la edad del hijo");
            int edad = Integer.parseInt(Util.myInput.nextLine());
            Hijo nuevoHijo = new Hijo(nomHijo, edad);
            nuevoEmpleado = new Empleado(id, nombre, apellido, fecha, salario);
            empresa.addEmpleado(nuevoEmpleado);
            empresa.addHijo(nuevoEmpleado, nuevoHijo);
            System.out.println(empresa);
            return true;
        } else {
            System.out.println(empresa);
            return false;
        }
    }

    // Logica del juego

}