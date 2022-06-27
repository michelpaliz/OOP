package ExamenRecuperacion.Models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Conductor {
    private String dni;
    private String nombre;
    private Date fechaNacimiento;
    private Date fechaLicenciaConducir;
    // creamos una lista de vehiculos en caso que el conductor tenga mas de un
    // vehiculo alquilado
    private List<Vehiculo> vehiculoAlquilado;

    public Conductor(String dni, String nombre, Date fechaNacimiento, Date fechaLicenciaConducir) {
        this.dni = dni;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaLicenciaConducir = fechaLicenciaConducir;
        // inicialmente tendra una lista
        this.vehiculoAlquilado = new ArrayList<>();
    }

    public String getDni() {
        return dni;
    }

    public Date getFechaLicenciaConducir() {
        return fechaLicenciaConducir;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }
}
