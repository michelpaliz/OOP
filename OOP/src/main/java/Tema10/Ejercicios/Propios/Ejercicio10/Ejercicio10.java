package Tema10.Ejercicios.Propios.Ejercicio10;

import java.util.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.github.javafaker.Faker;

import Tema8.EjemplosTema8.Tema8Adv.Cajero.util.Bombo;
import Tema8.EjemplosTema8.Tema8Adv.Cajero.util.Lib;

public class Ejercicio10 {

    static List<Empleado> empleados;
    Empleado[] values;
    int numValues;
    // List<Empleado> empleados = new ArrayList<Empleado>();
    // Map<Integer, String> map = new HashMap<Integer, String>();

    public Ejercicio10() {
        fakerGenerator(10);
        System.out.println(Arrays.toString(empleados.toArray()));

    }

        // public void mostarStock() {
    // for (Empleado empleado : empleados) {
    // map.put(empleado.getId(), empleado.getNombre());
    // }
    // System.out.println(map);
    // }


    public void fakerGenerator(int min) {
        System.out.println("GENERACION DE STOCK RANDOM");
        values = new Empleado[min];
        numValues = 0;
        if (true) {
            fakerEmpleado(min / 2);
        }
    }


    public void fakerEmpleado(int cantidad) {
        Date fechaMin = new GregorianCalendar(2000, Calendar.JANUARY, 1).getTime();
        Date fechaMax = new GregorianCalendar().getTime();
        Faker faker = new Faker(new Locale("es"));
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
            empleados = Arrays.asList(values);
        }

    }








}
