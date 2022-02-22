package EjerciciosTema8.Ejercicio7;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Paciente {
    // Creacion de atributos
    private final int sip;
    private final String nombre;
    private final Genero genero;
    private final GregorianCalendar edad;
    private final GregorianCalendar fechaEntrada;
    private final String sintomalogia;

    public Paciente(int sip, String nombre, Genero genero, GregorianCalendar edad, GregorianCalendar fechaEntrada,
            String sintomalogia) {
        this.sip = sip;
        this.nombre = nombre;
        this.genero = genero;
        this.edad = edad;
        this.fechaEntrada = fechaEntrada;
        this.sintomalogia = sintomalogia;
    }

    public int getSip() {
        return sip;
    }

    public String getNombre() {
        return nombre;
    }

    public Genero getGenero() {
        return genero;
    }

    public GregorianCalendar getEdad() {
        return edad;
    }

    public GregorianCalendar getFechaEntrada() {
        return fechaEntrada;
    }

    public String getSintomalogia() {
        return sintomalogia;
    }

    /**
     * 
     * @return devuelve la edad del paciente
     */

    public int getEdad1() {
        int anyoNacimiento = edad.get(Calendar.YEAR);
        int mesNacimiento = edad.get(Calendar.MONTH) + 1; //
        int diaNacimiento = edad.get(Calendar.DAY_OF_MONTH);

        GregorianCalendar fecha = new GregorianCalendar();
        int anyoActual = fecha.get(Calendar.YEAR);
        int mesActual = fecha.get(Calendar.MONTH) + 1;
        int diaActual = fecha.get(Calendar.DAY_OF_MONTH);

        int edad = anyoActual - anyoNacimiento;
        if (mesActual < mesNacimiento) {
            edad--;
        } else if (mesActual == mesNacimiento) {
            if (diaActual < diaNacimiento) {
                edad--;
            }
        }
        return edad;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");

        return "Paciente{" +
                "sip=" + sip +
                ", nombre='" + nombre + '\'' +
                ", genero=" + genero +
                ", edad=" + (getEdad1()) +
                ", fechaEntrada=" + sdf.format(fechaEntrada.getTime()) +
                ", sintomalogia='" + sintomalogia + '\'' +
                '}';
    }
}