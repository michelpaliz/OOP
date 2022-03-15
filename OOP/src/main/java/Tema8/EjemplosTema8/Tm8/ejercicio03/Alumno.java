package Tema8.EjemplosTema8.ejercicio03;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Alumno {
    private final long nia;
    private final String nombre;
    private final String apellidos;
    private final GregorianCalendar fechaNacimiento;
    private final String grupo;
    private final String telefono;

    public Alumno(long nia, String nombre, String apellidos, GregorianCalendar fechaNacimiento, String grupo, String telefono) {
        this.nia = nia;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.grupo = grupo;
        this.telefono = telefono;
    }

    public long getNia() {
        return nia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public GregorianCalendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getGrupo() {
        return grupo;
    }

    public String getTelefono() {
        return telefono;
    }

    public int getEdad() {
        int anyoNacimiento = fechaNacimiento.get(Calendar.YEAR);
        int mesNacimiento = fechaNacimiento.get(Calendar.MONTH) + 1; //
        int diaNacimiento = fechaNacimiento.get(Calendar.DAY_OF_MONTH);

        GregorianCalendar fecha = new GregorianCalendar();
        int anyoActual = fecha.get(Calendar.YEAR);
        int mesActual = fecha.get(Calendar.MONTH) + 1;
        int diaActual = fecha.get(Calendar.DAY_OF_MONTH);

        int edad = anyoActual - anyoNacimiento;
        if(mesActual < mesNacimiento) {
            edad--;
        } else if(mesActual == mesNacimiento) {
            if(diaActual < diaNacimiento) {
                edad--;
            }
        }
        return edad;
    }

    public int getEdad2() {
        LocalDate fechaActual = LocalDate.now();
        int anyoNacimiento = fechaNacimiento.get(Calendar.YEAR);
        int mesNacimiento = fechaNacimiento.get(Calendar.MONTH) + 1; //
        int diaNacimiento = fechaNacimiento.get(Calendar.DAY_OF_MONTH);
        LocalDate fechaNacimiento = LocalDate.of(diaNacimiento, mesNacimiento, anyoNacimiento);
        Period periodo = Period.between(fechaActual, fechaNacimiento);
        return periodo.getYears();
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return "Alumno{" +
                "nia=" + nia +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", fechaNacimiento=" + sdf.format(fechaNacimiento.getTime()) +
                ", grupo='" + grupo + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
