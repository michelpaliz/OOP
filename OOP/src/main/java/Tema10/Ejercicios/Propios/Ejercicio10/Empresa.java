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

import Tema08.EjemplosTema8.Tema8Adv.Cajero.util.Bombo;
import Tema08.EjemplosTema8.Tema8Adv.Cajero.util.Lib;

public class Empresa {

    private List<Empleado> empleados;
    Empleado[] values;
    int numValues;
    Bombo bombo;
    // List<Empleado> empleados = new ArrayList<Empleado>();
    // Map<Integer, String> map = new HashMap<Integer, String>();

    public Empresa(int cantidad) {
        fakerGenerator(cantidad);

    }

    private void fakerGenerator(int cantidad) {
        System.out.println("GENERACION DE STOCK RANDOM");
        // here we initilzate the emplado's vector
        values = new Empleado[cantidad];
        numValues = 0;
        if (true) {
            fakerEmpleado(cantidad);
            System.out.println(Arrays.toString(empleados.toArray()));
        }
    }

    private void fakerEmpleado(int cantidad) {
        Date fechaMin = new GregorianCalendar(2000, Calendar.JANUARY, 1).getTime();
        Date fechaMax = new GregorianCalendar().getTime();
        Faker faker = new Faker(new Locale("es"));
        bombo = new Bombo(cantidad, 1);

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
            // we conver a vector into a List
            // empleados = Arrays.asList(values);
            empleados = new ArrayList<>(Arrays.asList(values));
            //COOMMNT
        }

    }

    public boolean addHijo(Empleado empleado, Hijo hijo) {
        if (empleado != null) {
            for (Empleado empleadoEncontrado : empleados) {
                if (empleadoEncontrado.equals(empleado)) {
                    empleadoEncontrado.addHijo(hijo);
                    System.out.println(Arrays.toString(empleados.toArray()));
                    return true;
                }

            }
        }
        System.out.println("Esta vacio");
        return false;
    }

    public boolean addEmpleado(Empleado empleado) {
        if (empleado != null) {
            empleados.add(empleado);
            // empleados.addAll(empleadosAmpliado);
            System.out.println("LLEGO AL TRUE");
            return true;
        }
        return false;
    }

}
