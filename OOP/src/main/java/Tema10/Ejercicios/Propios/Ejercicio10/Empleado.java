package Tema10.Ejercicios.Propios.Ejercicio10;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.HashMap;

public class Empleado {
    public static final int INITIAL_SIZE = 10;
    private Integer id;
    private String nombre;
    private String apellido;
    private GregorianCalendar fechaNacimiento;
    private Double sueldo;
    private HashMap<Hijo, Hijo> hijos;

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
        // lo metemos aqui porque el empleado puede o no tener un hijo asi que no es
        // necesario tenerlo como parametro
        this.hijos = new HashMap<>();
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
                ", hijo=" + hijos + ", id=" + id + ", sueldo=" + sueldo + "]" + "\n";
    }

    // util para saber las posciiones de los maps

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Empleado other = (Empleado) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    // now we're going to create functions to manage some actions



    public Hijo addHijo(Hijo hijo) {
        if (hijo != null) {
            return hijos.put(hijo.getKey(hijo), hijo.getValues(hijo));
        }
        return null;

    }

}
