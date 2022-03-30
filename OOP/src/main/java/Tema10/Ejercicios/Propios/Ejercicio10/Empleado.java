package Tema10.Ejercicios.Propios.Ejercicio10;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.HashMap;

import Tema8.EjemplosTema8.Tema8Adv.Cajero.util.Bombo;

public class Empleado {
    public static final int INITIAL_SIZE = 10;
    private Integer id;
    private String nombre;
    private String apellido;
    private GregorianCalendar fechaNacimiento;
    private Double sueldo;
    private Hijo hijo;

    private HashMap<Bombo, Empleado> empleados;

    public Empleado() {
        this(INITIAL_SIZE);
    }

    public Empleado(int initialSize) {
        empleados = new HashMap<Bombo, Empleado>(initialSize);
    }

    public Empleado(Integer id2) {
        this.id = id2;
    }

    public Empleado(Integer id, String nombre, String apellido, GregorianCalendar fechaNacimiento, Double sueldo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.sueldo = sueldo;
    }

    public Empleado(String nombre, String apellido, GregorianCalendar fechaNacimiento, Double sueldo, Hijo hijo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.sueldo = sueldo;
        this.hijo = hijo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return "Empleado [apellido=" + apellido + " fechaNacimiento="
                + sdf.format(fechaNacimiento.getTime()) +
                ", hijo=" + hijo + ", id=" + id + ", nombre=" + nombre + ", sueldo=" + sueldo + "]";
    }

}
