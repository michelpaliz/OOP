package ExamenRecuperacion.Models;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import Lib.Control;
import Lib.Util;

public class Conductor {
    private String dni;
    private String nombre;
    private GregorianCalendar fechaNacimiento;
    private GregorianCalendar fechaLicenciaConducir;
    // creamos una lista de vehiculos en caso que el conductor tenga mas de un
    // vehiculo alquilado
    private List<Vehiculo> vehiculoAlquilado;

    public Conductor(String dni, String nombre, GregorianCalendar fechaNacimiento,
            GregorianCalendar fechaLicenciaConducir) {
        this.dni = dni;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaLicenciaConducir = fechaLicenciaConducir;

        this.vehiculoAlquilado = new ArrayList<>();
    }

    public String getDni() {
        return dni;
    }

    public GregorianCalendar getFechaLicenciaConducir() {
        return fechaLicenciaConducir;
    }

    public GregorianCalendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return Control.getEdad(this.fechaNacimiento);
    }

    public int getFechaExperiencia() {
        return Control.getEdad(this.fechaLicenciaConducir);
    }

    public List<Vehiculo> getVehiculoAlquilado() {
        return vehiculoAlquilado;
    }

    @Override
    public String toString() {
        return "Conductor{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", fechaNacimiento=" + Util.dateFrmYear(fechaNacimiento) +
                ", fechaLicenciaConducir=" + Util.dateFrmYear(fechaLicenciaConducir) +
                ", vehiculoAlquilado=" + vehiculoAlquilado +
                '}';
    }
}
