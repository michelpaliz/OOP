package Tema11.Propios.ejercicio06.models;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import Lib.Control;

public class Socio implements Comparable<Socio> {
    private static int N_SOCIOS = 0;
    private String nif;
    private String nombre;
    private String poblacion;
    private int edad;
    // El socio puede contener recargos
    private final List<Recargo> recargos;

    public Socio(String nif, String nombre, int edad, String poblacion) {
        N_SOCIOS++;
        this.nif = nif;
        this.nombre = nombre;
        this.poblacion = poblacion;
        this.edad = edad;
        this.recargos = new ArrayList<>();
    }

    public Socio(String nombre, int edad, String poblacion) {
        this(" ", nombre, edad, poblacion);
        this.nif = " " + N_SOCIOS + Control.letraNIF(N_SOCIOS);
    }

    public String getNif() {
        return nif;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCiudad() {
        return poblacion;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public List<Recargo> getRecargos() {
        return recargos;
    }

    // METODOS A GENERAR
    // 1. generarRecargo() == la cantidad del recargo
    // 2.Solo pueden ser mayor de edad los socios;
    // 3. Busquedas por nombre y por edad

    /**
     * EL RECARGO QUE PUEDE TENER EL SOCIO
     * 
     * @param alquiler
     * @param cantidadPagar
     */
    public void generarRecargo(Alquiler alquiler, double cantidadPagar) {
        this.recargos.add(new Recargo(alquiler, cantidadPagar));
    }

    // Recorre los recargos que tiene el socio y comprueba si tiene recargos
    public boolean tieneRecargosPendientes() {
        for (Recargo recargo : recargos) {
            if (recargo.getFechaPago() == null) {
                return true; // si tiene recargos pendientes
            }
        }
        return false;

    }

    // !PARA LAS BUSQUEDAS DE LOS SOCIOS
    // Necesitamos implementatr este constructor para que funcione las demas.
    @Override
    public int compareTo(Socio o) {
        return 0;
    }

    public static class ComparatorNombre implements Comparator<Socio> {
        @Override
        public int compare(Socio o1, Socio o2) {
            return o1.nombre.compareTo(o2.nombre);
        }
    }

    public static class ComparatorEdad implements Comparator<Socio> {
        @Override
        public int compare(Socio o1, Socio o2) {
            return o1.getEdad() - o2.getEdad();
        }
    }

    @Override
    public String toString() {
        return "Socio [edad=" + edad + ", nif=" + nif + ", nombre=" + nombre + ", poblacion=" + poblacion
                + ", recargos=" + recargos + "]\n";
    }

}
