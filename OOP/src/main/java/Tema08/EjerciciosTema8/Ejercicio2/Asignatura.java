package Tema08.EjerciciosTema8.Ejercicio2;

public class Asignatura {
    //creacion de atributos
    private String nombre;
    private int codigo;
    private CURSO curso;
    private String cursoVerano;

    public Asignatura(String nombre, int codigo, CURSO curso, String cursoVerano) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.curso = curso;
        this.cursoVerano = cursoVerano;
    }

    public Asignatura(String nombre, int codigo, String cursoVerano) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.cursoVerano = cursoVerano;
    }

    //Creacion getters
    public String getNombre() {
        return nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public CURSO getCurso() {
        return curso;
    }

    public String getCursoVerano() {
        return cursoVerano;
    }

    //    Creacion de constructores
    public enum CURSO {
        CURSO1,
        CURSO2,
        CURSO3
    }

    @Override
    public String toString() {
        return "Asignatura{" +
                "nombre='" + nombre + '\'' +
                ", codigo=" + codigo +
                ", curso=" + curso +
                ", cursoVerano='" + cursoVerano + '\'' +
                '}';
    }
}
