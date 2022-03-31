package Tema10.Ejercicios.Propios.Ejercicio10;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Empleado {
    public static final int INITIAL_SIZE = 10;
    private Integer id;
    private String nombre;
    private String apellido;
    private GregorianCalendar fechaNacimiento;
    private Double sueldo;
    private Hijo hijo;

    public Empleado() {
        this(INITIAL_SIZE);
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
        return "Empleado [nombre =" + nombre + " apellido=" + apellido + " fechaNacimiento="
                + sdf.format(fechaNacimiento.getTime()) +
                ", hijo=" + hijo + ", id=" + id + ", sueldo=" + sueldo + "]" + "\n";
    }

}