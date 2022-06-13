package Tema11.Propios.ejercicio06.models;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

import Lib.Control;

public class Socio {
    private static int N_SOCIOS = 0;
    private String nif;
    private String nombre;
    private String poblacion;
    private int edad;
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

    public void generarRecargo(Alquiler alquiler, double cantidadPagar) {
        this.recargos.add(new Recargo(alquiler, cantidadPagar));
    }

    public boolean tieneRecargosPendientes() {
        for (Recargo recargo : recargos) {
            if (recargo.getFechaPago() == null) {
                return true;
            }
        }
        return false;

    }

}
