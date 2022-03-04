package Tema8.EjerciciosTema8.Ejercicio3;

// import java.util.Date;
import java.time.LocalDate;

public class Alumno {
    // Creacion de atributos
    private int nia;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private GrupoAlumno grupoAlumno;
    private int telefono;
    Alumno listaAlumnos[] = new Alumno[5];
    int range;

    // Creacion de contructores de los alumnos

    public Alumno(int nia, String nombre, String apellido, int anyo, int mes, int dia, GrupoAlumno grupo,
            int telefono) {
        this.nia = nia;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = LocalDate.of(anyo, mes, dia);
        this.grupoAlumno = grupo;
        this.telefono = telefono;
    }

    public Alumno(Alumno alumno) {
        this.nia = alumno.nia;
        this.nombre = alumno.nombre;
        this.apellido = alumno.apellido;
        this.fechaNacimiento = alumno.fechaNacimiento;
        this.grupoAlumno = alumno.grupoAlumno;
        this.telefono = alumno.telefono;
    }

    public Alumno() {
    }

    public void crearAlumno(Alumno alumno) {
        listaAlumnos[range++] = new Alumno(alumno);
    }

    @Override
    public String toString() {
        return "Alumno [apellido=" + apellido + ", fechaNacimiento=" + fechaNacimiento + ", grupoAlumno=" + grupoAlumno
                + ", nia=" + nia + ", nombre=" + nombre + ", telefono=" + telefono + "]";
    }

}
