package Tema10.Ejercicios.Propios.Ejercicio11.controlador;

import java.util.ArrayList;

import Tema10.Ejercicios.Propios.Ejercicio11.actores.Alumno;
import Tema10.Ejercicios.Propios.Ejercicio11.actores.Aula;
import Tema10.Ejercicios.Propios.Ejercicio11.actores.Grupo;
import Tema10.Ejercicios.Propios.Ejercicio11.actores.Profesor;
import Tema8.EjemplosTema8.Tema8Adv.Ejercicio2.Asignatura;

public class Centro {

    private ArrayList<Aula> aulas;
    private ArrayList<Grupo> grupos;
    private ArrayList<Profesor> profesores;
    private ArrayList<Asignatura> asignaturas;
    private ArrayList<Alumno> alumnos;

    public Centro() {
        this(10);
    }

    // el centro contiene la base de datos de todos los datos, ASI QUE HAREMOS LAS
    // OPERACIONES DEL EJERCICIO
    public Centro(int initialCapacity) {
        alumnos = new ArrayList<>(initialCapacity);
        asignaturas = new ArrayList<>(initialCapacity);
        profesores = new ArrayList<>(initialCapacity);
        grupos = new ArrayList<>(initialCapacity);
        aulas = new ArrayList<>(initialCapacity);
    }



    @Override
    public String toString() {
        return "Centro [alumnos=" + alumnos + ", asignaturas=" + asignaturas + ", aulas=" + aulas + ", grupos=" + grupos
                + ", profesores=" + profesores + "]";
    }



    

}
