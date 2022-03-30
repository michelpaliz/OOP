package Tema10.Ejercicios.Propios.Ejercicio10;

import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;

import com.github.javafaker.Faker;

import Tema8.EjemplosTema8.Tema8Adv.Cajero.util.Bombo;
import Tema8.EjemplosTema8.Tema8Adv.Cajero.util.Lib;

public class Ejercicio10 {

    Empleado[] values;
    Empleado[] keys;
    int numValues = 0;
    // HashMap<Empleado, Empleado> empleados;
    // List<Empleado> empleados = new ArrayList<Empleado>();
    List<Empleado> empleados = new ArrayList<Empleado>();

    public Ejercicio10() {
        mostrarStockPrueba(10);
    }

    public void mostrarStockPrueba(int min) {
        System.out.println("GENERACION DE STOCK RANDOM");
        values = new Empleado[min];
        numValues = 0;
        if (true) {
            fakerEmpleado(min / 2);
        }
    }

    /**
     * muestra el stock actual
     */

    public void mostarStock() {
        for (Empleado empleado : values) {
            empleados.add(empleado);
        }
        System.out.println(empleados);
    }

    public void fakerEmpleado(int cantidad) {
        Date fechaMin = new GregorianCalendar(2000, Calendar.JANUARY, 1).getTime();
        Date fechaMax = new GregorianCalendar().getTime();
        Faker faker = new Faker();
        Bombo bombo = new Bombo(cantidad, 0);

        for (int i = 0; i < cantidad; i++) {
            Integer ID = bombo.extraerBola();
            String nombre = faker.name().firstName();
            String apellido = faker.name().lastName();
            Double sueldo = faker.number().randomDouble(2, 1, 100);
            Date fecha = faker.date().between(fechaMin, fechaMax);
            GregorianCalendar nacimiento = new GregorianCalendar();
            nacimiento.setTime(fecha);
            values[i] = new Empleado(ID, nombre, apellido, nacimiento, sueldo);
            numValues++;
            mostarStock();

        }

    }

}
