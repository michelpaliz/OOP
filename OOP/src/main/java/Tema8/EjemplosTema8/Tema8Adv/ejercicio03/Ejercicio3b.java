package Tema8.EjemplosTema8.Tema8Adv.ejercicio03;


// import com.germangascon.tema08.utils.Ansi;
// import com.germangascon.tema08.utils.Lib;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

import Tema8.EjemplosTema8.Tema8Adv.utils.Ansi;
import Tema8.EjemplosTema8.Tema8Adv.utils.Lib;

/**
 * El ejercicio 3 podemos abordarlo con dos estrategias bien diferenciadas:
 * - Opción A) Al borrar un elemento, simplemente marcarlo como null y tener en cuenta que
 *   pueden existir elementos del array a null.
 *   * Ventajas: borrado rápido.
 *   * Desventajas: búsquedas lentas. Una posible mejora es llevar la cuenta de los elementos
 *     efectivos que hay en el array.
 * - Opción B) Al borrar un elemento desplazamos todos los elementos que queden a la derecha
 *   del elemento borrado una posición hacia la izquierda.
 *   * Ventajas: búsquedas rápidas
 *   * Desventajas: borrado más lento.
 *
 *  En este caso implementamos la opción B)
 */
public class Ejercicio3b {
    private final Scanner lector;
    private final Alumno[] alumnos;
    private int contadorAlumnos;
    private final Grupo[] grupos;

    private final static String[] nombres = {"Juan", "Isabel", "Pablo", "Sergio", "Rubén", "Alicia", "Ana", "María", "José", "Fernando", "Germán"};
    private final static String[] apellidos = {"Fernández", "Gutiérrez", "Ramírez", "Torregrosa", "Signes", "García", "Gallego", "Alonso", "Tormos"};

    public Ejercicio3b(int maxAlumnos, int nGrupos) {
        lector = new Scanner(System.in);
        int opcion;
        alumnos = new Alumno[maxAlumnos];
        contadorAlumnos = 0;
        grupos = new Grupo[nGrupos];
        generarDatosAleatorios(8);
        do {
            opcion = menuPrincipal();
            switch (opcion) {
                case 1:
                    nuevoAlumno();
                    break;
                case 2:
                    bajaAlumno();
                    break;
                case 3:
                    consultas();
                    break;
                case 0:
                    System.out.println("Hasta pronto!");
                    break;
            }
        } while(opcion != 0);
    }

    private void nuevoAlumno() {
        boolean validado = false;
        int nia;
        String nombre;
        String apellidos;
        String fechaNacimientoString;
        GregorianCalendar fechaNacimiento = null;
        Grupo grupo = null;
        long telefono;
        Ansi.clearScreen();

        if(contadorAlumnos < alumnos.length) {

            System.out.println("*** NUEVO ALUMNO ***");
            do {
                System.out.println("Nia: ");
                nia = Integer.parseInt(lector.nextLine());
                validado = nia < 1999999 && nia > 0;
                if (!validado) {
                    System.out.println("Nia debe estar comprendido en el rango [0-1999999]");
                    Lib.pause();
                }
                /** Comprobamos que dicho NIA no esté duplicado **/
                if (buscarAlumnoPorNia(nia) >= 0) {
                    validado = false;
                    System.out.println("El nia introducido ya corresponde a un alumno.");
                    System.out.println("Introduzca otro por favor");
                    Lib.pause();
                }
            } while (!validado);

            do {
                System.out.println("Nombre: ");
                nombre = lector.nextLine();
                validado = nombre.length() > 2;
                if (!validado) {
                    System.out.println("Nombre debe tener almenos 2 caracteres");
                    Lib.pause();
                }
            } while (!validado);

            do {
                System.out.println("Apellidos: ");
                apellidos = lector.nextLine();
                validado = apellidos.length() > 2;
                if (!validado) {
                    System.out.println("Apellidos debe tener almenos 2 caracteres");
                    Lib.pause();
                }
            } while (!validado);

            do {
                System.out.println("Fecha nacimiento (dd-mm-yyyy): ");
                fechaNacimientoString = lector.nextLine();
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                try {
                    Date date = sdf.parse(fechaNacimientoString);
                    fechaNacimiento = new GregorianCalendar();
                    fechaNacimiento.setTime(date);
                    validado = true;
                } catch (ParseException pe) {
                    validado = false;
                    System.out.println("El formato de la fecha de nacimiento no es válido. Recuerde (dd-mm-yyyy).");
                    Lib.pause();
                }
            } while (!validado);

            do {
                int i;
                System.out.println("Grupos disponibles");
                for (i = 0; i < grupos.length; i++) {
                    System.out.println("Código: " + grupos[i].getCodigo() + ", nombre: " + grupos[i].getNombre());
                }
                System.out.println("Código del grupo: ");
                int codigo = Integer.parseInt(lector.nextLine());
                validado = false;
                i = 0;
                /** Buscamos que el código que ha introducido el usuario corresponde a un grupo válido **/
                /** En caso afirmativo lo asignamos **/
                while (i < grupos.length && !validado) {
                    if (grupos[i].getCodigo() == codigo) {
                        grupo = grupos[i];
                        validado = true;
                    } else {
                        i++;
                    }
                }
            } while (!validado);

            do {
                System.out.println("Teléfono: ");
                telefono = Long.parseLong(lector.nextLine());
                /** Para facilitar la introducción de datos permitimos poner números pequeños como teléfono **/
                validado = telefono > 0 && telefono < 999999999;
            } while (!validado);


            /** Finalmente añadimos el alumno */
            alumnos[contadorAlumnos] = new Alumno(nia, nombre, apellidos, fechaNacimiento, grupo, telefono);
            contadorAlumnos++;
            System.out.println("Alumno guardado correctamente");
        } else {
            System.out.println("Imposible añadir el alumno.");
            System.out.println("El array de alumnos está lleno");
        }
        Lib.pause();
    }

    private void bajaAlumno() {
        int nia;
        int pos;
        Ansi.clearScreen();
        System.out.println("*** BAJA ALUMNO ***" );
        System.out.println("Nia: ");
        nia = Integer.parseInt(lector.nextLine());
        pos = buscarAlumnoPorNia(nia);
        if(pos >= 0) {
            alumnos[pos] = null;
            contadorAlumnos--;
            desplazar(alumnos, pos+1);
            System.out.println("Alumno borrado correctamente");
        } else {
            System.out.println("No existe ningún alumno con el nia " + nia);
        }
        Lib.pause();
    }

    /**
     * Desplaza los elementos del array una posición a partir de la posición pos
     * @param alumnos Array a desplazar
     * @param pos Posición a partir de la cual se desplazarán los elementos
     */
    private void desplazar(Alumno[] alumnos, int pos) {
        int i = pos;
        boolean fin = false;
        while(i < alumnos.length && !fin) {
            fin = alumnos[i] == null;
            if(!fin) {
                alumnos[i-1] = alumnos[i];
                alumnos[i] = null;
            }
            i++;
        }
    }

    private void consultas() {
        int opcion;
        int i;
        do {
            opcion = menuConsultas();
            switch (opcion) {
                case 1:
                    //Por grupo
                    int codigo;
                    Alumno[] alumnosGrupo;
                    System.out.println("Grupos disponibles");
                    for (i = 0; i < grupos.length; i++) {
                        System.out.println("Código: " + grupos[i].getCodigo() + ", nombre: " + grupos[i].getNombre());
                    }
                    System.out.println("Código del grupo: ");
                    codigo = Integer.parseInt(lector.nextLine());
                    alumnosGrupo = buscarAlumnoPorGrupo(codigo);
                    if (alumnosGrupo != null) {
                        for (i = 0; i < alumnosGrupo.length; i++) {
                            System.out.println(alumnosGrupo[i].toString());
                        }
                    } else {
                        System.out.println("No se han encontrado alumnos del grupo con código " + codigo);
                    }
                    Lib.pause();
                    break;
                case 2:
                    //Por edad
                    int edad;
                    Alumno[] alumnosEdad;
                    System.out.println("Edad: ");
                    edad = Integer.parseInt(lector.nextLine());
                    alumnosEdad = buscarAlumnoPorEdad(edad);
                    if (alumnosEdad != null) {
                        for (i = 0; i < alumnosEdad.length; i++) {
                            System.out.println(alumnosEdad[i].toString());
                        }
                    } else {
                        System.out.println("No se han encontrado alumnos que tengan " + edad + " años");
                    }
                    Lib.pause();
                    break;
                case 3:
                    //Por nia
                    int nia;
                    System.out.println("Nia: ");
                    nia = Integer.parseInt(lector.nextLine());
                    int pos = buscarAlumnoPorNia(nia);
                    if(pos >= 0) {
                        System.out.println(alumnos[pos].toString());
                    } else {
                        System.out.println("No se ha encontrado ningún alumno con el nia " + nia);
                    }
                    Lib.pause();
                    break;
                case 4:
                    //Por apellidos
                    String apellidos;
                    Alumno[] alumnosApellidos;
                    System.out.println("Apellidos: ");
                    apellidos = lector.nextLine();
                    alumnosApellidos = buscarAlumnoPorApellidos(apellidos);
                    if (alumnosApellidos != null) {
                        for (i = 0; i < alumnosApellidos.length; i++) {
                            System.out.println(alumnosApellidos[i].toString());
                        }
                    } else {
                        System.out.println("No se han encontrado alumnos que tengan " + apellidos + " como apellidos");
                    }
                    Lib.pause();
                    break;
                case 5:
                    mostrarTodos();
                    Lib.pause();
                    break;
            }
        } while (opcion != 0);

    }

    /**
     * Muestra todos los alumnos
     */
    public void mostrarTodos() {
        // En este caso podemos utilizar un bucle for ya que todos los elementos están consecutivos
        for(int i = 0; i < contadorAlumnos; i++) {
            System.out.println(alumnos[i].toString());
        }
    }

    private void generarDatosAleatorios(int nAlumnos) {
        generarGruposAleatorios();
        generarAlumnosAleatorios(nAlumnos);
    }

    private void generarGruposAleatorios() {
        for(int i = 0; i < grupos.length; i++) {
            grupos[i] = new Grupo(i, "GRUPO " + i);
        }
    }

    private void generarAlumnosAleatorios(int nAlumnos) {
        for(int i = 0; i < nAlumnos; i++) {
            alumnos[i] = alumnoAleatorio();
            contadorAlumnos++;
        }
    }
    private Alumno alumnoAleatorio() {
        int nia = Lib.random(1000000, 1099999);
        String nombre = nombres[Lib.random(0, nombres.length-1)];
        String apellido1 = apellidos[Lib.random(0, apellidos.length-1)];
        String apellido2 = apellidos[Lib.random(0, apellidos.length-1)];
        GregorianCalendar fechaNacimiento = new GregorianCalendar(Lib.random(1985, 2005), Lib.random(0, 11), Lib.random(1,28));
        Grupo grupo = grupos[Lib.random(0, grupos.length-1)];
        int telefono = Lib.random(965700000, 965799999);
        return new Alumno(nia, nombre, apellido1 + " " + apellido2, fechaNacimiento, grupo, telefono);
    }

    private int menuPrincipal() {
        int opcion = -1;
        do {
            Ansi.clearScreen();
            System.out.println("*********************");
            System.out.println("** GESTIÓN ALUMNOS **");
            System.out.println("*********************");
            System.out.println("1. Nuevo alumno...");
            System.out.println("2. Baja de alumno...");
            System.out.println("3. Consultas...");
            System.out.println("---------------------");
            System.out.println("0. Salir\n");
            System.out.println("Elija una opción: ");
            opcion = Integer.parseInt(lector.nextLine());
            if(opcion < 0 || opcion > 3) {
                System.out.println("Elija una opción del menú [0-3]");
                Lib.pause();
            }
        } while (opcion < 0 || opcion > 3);
        return opcion;
    }

    private int menuConsultas() {
        int opcion = -1;
        do {
            Ansi.clearScreen();
            System.out.println("***************");
            System.out.println("** CONSULTAS **");
            System.out.println("****************");
            System.out.println("1. Por grupo...");
            System.out.println("2. Por edad...");
            System.out.println("3. Por nia...");
            System.out.println("4. Por apellidos...");
            //Aunque no lo pide el ejercicio, añadimos la opción de mostrar todos para facilitar las pruebas
            System.out.println("5. Mostrar todos...");
            System.out.println("----------------");
            System.out.println("0. Volver al menú principal\n");
            System.out.println("Elija una opción: ");
            opcion = Integer.parseInt(lector.nextLine());
            if(opcion < 0 || opcion > 5) {
                System.out.println("Elija una opción del menú [0-5]");
                Lib.pause();
            }
        } while (opcion < 0 || opcion > 5);
        return opcion;
    }

    /**
     * Busca alumnos por Grupo
     * @param codigoGrupo
     * @return Un array con los alumnos que ha encontrado, null si no ha encontrado
     */
    private Alumno[] buscarAlumnoPorGrupo(int codigoGrupo) {
        Alumno[] alumnosGrupo = null;
        /** Lo ideal sería hacerlo con ArrayLists pero aún no los hemos visto */
        /** Calculamos primero cuantos alumnos hay que coincidan con el criterio de búsqueda **/
        int nAlumnos = 0;
        for(int i = 0; i < contadorAlumnos; i++) {
            if (alumnos[i].getGrupo().getCodigo() == codigoGrupo) {
                nAlumnos++;
            }
        }
        if(nAlumnos > 0) {
            alumnosGrupo = new Alumno[nAlumnos];
            int cont = 0;
            /** Una vez sabemos el número de alumnos los asignamos al vector **/
            for(int i = 0; i < contadorAlumnos; i++) {
                if (alumnos[i].getGrupo().getCodigo() == codigoGrupo) {
                    alumnosGrupo[cont] = alumnos[i];
                    cont++;
                }
            }
        }
        return alumnosGrupo;
    }

    /**
     * Busca alumnos por Edad
     * @param edad
     * @return Un array con los alumnos que ha encontrado, null si no ha encontrado
     */
    private Alumno[] buscarAlumnoPorEdad(int edad) {
        Alumno[] alumnosEdad = null;
        /** Lo ideal sería hacerlo con ArrayLists pero aún no los hemos visto */
        /** Calculamos primero cuantos alumnos hay que coincidan con el criterio de búsqueda **/
        int nAlumnos = 0;
        for(int i = 0; i < contadorAlumnos; i++) {
            if (alumnos[i].getEdad() == edad) {
                nAlumnos++;
            }
        }
        if(nAlumnos > 0) {
            alumnosEdad = new Alumno[nAlumnos];
            int cont = 0;
            /** Una vez sabemos el número de alumnos los asignamos al vector **/
            for(int i = 0; i < contadorAlumnos; i++) {
                if (alumnos[i].getEdad() == edad) {
                    alumnosEdad[cont] = alumnos[i];
                    cont++;
                }
            }
        }
        return alumnosEdad;
    }

    /**
     * Busca un alumno por Nia
     * @param nia
     * @return Si lo encuentra devuelve la posición del array donde está el alumno,
     * en caso contrario devuelve -1
     */
    private int buscarAlumnoPorNia(int nia) {
        for(int i = 0; i < contadorAlumnos; i++) {
            if (alumnos[i].getNia() == nia) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Busca alumnos por Apellidos
     * @param apellidos
     * @return Un array con los alumnos que ha encontrado, null si no ha encontrado
     */
    private Alumno[] buscarAlumnoPorApellidos(String apellidos) {
        Alumno[] alumnosApellidos = null;
        /** Lo ideal sería hacerlo con ArrayLists pero aún no los hemos visto */
        /** Calculamos primero cuantos alumnos hay que coincidan con el criterio de búsqueda **/
        int nAlumnos = 0;
        //Convertimos a minúsculas
        apellidos = apellidos.toLowerCase();

        for(int i = 0; i < contadorAlumnos; i++) {
            if (alumnos[i].getApellidos().toLowerCase().contains(apellidos)) {
                nAlumnos++;
            }
        }
        if(nAlumnos > 0) {
            alumnosApellidos = new Alumno[nAlumnos];
            int cont = 0;

            /** Una vez sabemos el número de alumnos los asignamos al vector **/
            for(int i = 0; i < contadorAlumnos; i++) {
                if (alumnos[i].getApellidos().toLowerCase().contains(apellidos)) {
                    alumnosApellidos[cont] = alumnos[i];
                    cont++;
                }
            }
        }
        return alumnosApellidos;
    }
}
