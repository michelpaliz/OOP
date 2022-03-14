package OtrosEjercicios.Campeonato;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Entrenador {
    
    // Creacion de atributos
    private final  long  id;
    private final  String nombre;
    private final  String apellido;
    private final GregorianCalendar edad;


    public Entrenador(long id, String nombre, String apellido, GregorianCalendar edad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }


    public long getId() {
        return id;
    }


    public String getNombre() {
        return nombre;
    }


    public String getApellido() {
        return apellido;
    }

       /**
     * 
     * @return devuelve la edad del paciente
     */

    public int getEdad() {
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
        
        return "Entrenador{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + getEdad() +
                '}';
    }
}
