package Tema08.EjerciciosTema8.Ejercicio3;

import java.util.Scanner;

public class Ejercicio03 {
    // Variables
    private final Scanner myInput = new Scanner(System.in);
    public static Alumno NuevoAlumno;
    public final int maxRange = 9999;
    public final int minRange = 999;
    public static int range;
    public static int NUM = 0;
    // Variables
    Alumno alumno1 = new Alumno(12345, "Michael", "paliz", 2000, 12, 8,
            GrupoAlumno.DAM1, 654681542);
    Alumno alumno2 = new Alumno(12345, "Sanyi", "Ramos", 2002, 10, 15,
            GrupoAlumno.DAM3, 654681542);

    // *Fuciones
    private void menuGestionAlumnos() {
        int opcion;
        boolean correct;
        System.out.println("****BIENBENIDO INSERTA UNA OPCION *********");
        do {
            System.out.println("*********GESTION ALUMNOS **********");
            System.out.println("1.Nuevo ALUMNO");
            System.out.println("2.Baja ALUMNO");
            System.out.println("3.Consultas");
            System.out.println("----------------------");
            System.out.println("0.Salir");
            opcion = Integer.parseInt(myInput.nextLine());
            correct = opcion <= 3 && opcion > 0;
            if (!correct) {
                System.out.println("Porfavor ingresa un numero valido del  1  al 3");
            }
        } while (!correct);

        switch (opcion) {
            case 1:
                ingresarNuevoAlumno();
                break;
            case 2:

        }

    }

    public Alumno ingresarNuevoAlumno() {
        System.out.printf(
                "Ingresa el nia del  nuevo Alumno (No puede superar los %d digitos y necesita tener almenos 4 digitos)\n",
                maxRange);
        int nia = Integer.parseInt(myInput.nextLine());
        validarNia(nia);
        System.out.println("Ingresa el nombre del  nuevo Alumno");
        String nombre = myInput.nextLine();
        System.out.println("Ingresa el apellido del nuevo Alumno");
        String apellido = myInput.nextLine();
        System.out.println("Ingresa el año de nacimiento del alumno");
        int anyo = Integer.parseInt(myInput.nextLine());
        System.out.println("Ingresa el mes de nacimineto del alumno");
        int mes = Integer.parseInt(myInput.nextLine());
        System.out.println("Ingresa el dia de nacimiento del alumno");
        int dia = Integer.parseInt(myInput.nextLine());
        // *Determinar el grupo del alumno
        System.out.println("Inserta el grupo del alumno");
        GrupoAlumno eleccion = determinaGrupo();
        System.out.println("Inserta el numero de telefono del alumno");
        int telefono = Integer.parseInt(myInput.nextLine());
        // *Declarando nuevo alumno
        NuevoAlumno = new Alumno(nia, nombre, apellido, anyo, mes, dia, eleccion, telefono);
        // System.out.print("Este es el alumno que has creado \n" + NuevoAlumno);
        // System.out.println(NuevoAlumno); me devuelve una direccion
        // !Volver al menu principal
        volverMenuPrincipal();
        return NuevoAlumno;

    }

    public void volverMenuPrincipal() {
        System.out.println("Quieres volver al menu principal ?");
        String strUser = myInput.nextLine();
        if (strUser.equalsIgnoreCase("Si")) {
            menuGestionAlumnos();
        } else {
            System.out.println("Antes de que te vayas te muesto la base de datos de los alumnos ");
            mostrarDatos();
            System.out.println("Hasta pronto!");
        }
    }

    public GrupoAlumno determinaGrupo() {

        boolean correct;
        GrupoAlumno g = GrupoAlumno.DAM1; // I needed to initialitate the value bcs it wouldn't let me function to
                                          // recall the variable;
        int grupoUser;
        do {
            System.out.println("1. DAM1");
            System.out.println("2. DAM2");
            System.out.println("3. DAM3");
            grupoUser = Integer.parseInt(myInput.nextLine());
            correct = grupoUser <= 3 && grupoUser > 0;
            if (!correct) {
                System.out.println("Inserta un valor correcto");
            }
        } while (!correct);

        switch (grupoUser) {
            case 1:
                GrupoAlumno g1 = GrupoAlumno.DAM1;
                g = g1;
                break;
            case 2:
                GrupoAlumno g2 = GrupoAlumno.DAM2;
                g = g2;
                break;
            case 3:
                GrupoAlumno g3 = GrupoAlumno.DAM3;
                g = g3;
                break;
            default:
                System.err.println("Ingresa un numoro valido");
        }

        return g;
    }

    public int validarNia(int user) {
        int nia;
        if (user >= 1 && user <= maxRange) {
            nia = user;
        } else {
            throw new IllegalArgumentException("Number out of range, the range is " + maxRange);
        }
        if (user > minRange) {
            nia = user;
        } else {
            throw new IllegalArgumentException("The number needs to have at least 4 digits");
        }

        return nia;
    }

    public void mostrarDatos() {
        // LISTA LOS ALUMNOS
        System.out.println("********LISTADO DE ALUMNOS *********");
        // *Creacion de los objedtos de Alumno ;
        Alumno basedatos = new Alumno();
        basedatos.crearAlumno(alumno1);
        basedatos.crearAlumno(alumno2);
        basedatos.crearAlumno(NuevoAlumno);

        // Alumno[] basedatos = { alumno1, alumno2, NuevoAlumno };

        for (Alumno i : basedatos.listaAlumnos) {
            System.out.println(i);
        }
        System.out.println("*********FIN LISTADO ALUMNOS *************");
    }

    public Ejercicio03() {

        menuGestionAlumnos();

    }

}
