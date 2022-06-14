package Tema11.Propios.ejercicio06.models;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import com.github.javafaker.Faker;
import Lib.Util;
import Tema11.Propios.ejercicio06.numeric.Formato;
import Tema11.Propios.ejercicio06.numeric.Plataforma;

public class Tienda {
    /** Enumerado para representar el tipo de ordenación */
    private enum Orden {
        DEFAULT, TITULO, ANYO, FECHA_ALQUILER
    }

    /** Constantes de configuración */
    private static final int N_PELICULAS = 30;
    private static final int N_VIDEOJUEGOS = 30;
    private static final int N_SOCIOS = 50;
    /** Atributos */
    private final VideoClub videoClub;

    /**
     * Muestra el menú principal, solicita una opción al usuario y ejecuta la opción
     * elegida
     */
    public Tienda() {
        int opcion;
        videoClub = new VideoClub(N_PELICULAS, N_VIDEOJUEGOS, N_SOCIOS);
        do {
            opcion = menuPrincipal();
            switch (opcion) {
                case 1:
                    altas();
                    break;
                case 2:
                    alquilar();
                    Util.pause();
                    break;
                case 3:
                    devolver();
                    Util.pause();
                    break;
                case 4:
                    consultas();
                    break;

                case 0:
                    System.out.println("Hasta pronto");
                    break;
            }
        } while (opcion != 0);
    }

    /**
     * Muestra el menú de altas, solicita una opción al usuario y la ejecuta
     */
    private void altas() {
        int opcion;
        do {
            opcion = menuAltas();
            switch (opcion) {
                case 1:
                    nuevaPelicula();
                    Util.pause();
                    break;
                case 2:
                    nuevoVideojuego();
                    Util.pause();
                    break;
                case 3:
                    nuevoSocio();
                    Util.pause();
                    break;
            }
        } while (opcion != 0);
    }

    /**
     * Crea un Socio solicitando los datos al usuario y validándolos
     */
    private void nuevoSocio() {
        String nif;
        String nombre;
        int edad;
        String poblacion;
        boolean validado;

        do {
            nif = solicitarNif();
            validado = nif.length() >= 2;
            if (validado) {
                validado = Util.validarNIF(nif);
                if (!validado) {
                    System.out.println("El nif introducido no es válido");
                }
            } else {
                System.out.println("El nif debe tener al menos 2 caracteres");
            }
        } while (!validado);

        do {
            nombre = solicitarNombre();
            validado = nombre.length() >= 2;
            if (!validado) {
                System.out.println("El nombre debe tener 2 o más caracteres");
            }
        } while (!validado);

        do {
            edad = solicitarEdad();
            validado = edad >= VideoClub.EDAD_MINIMA;
            if (!validado) {
                System.out.println("La edad mínima para hacese socio es de " + VideoClub.EDAD_MINIMA + " años");
            }
        } while (!validado);

        do {
            poblacion = solicitarPoblacion();
            validado = poblacion.length() >= 3;
            if (!validado) {
                System.out.println("La población debe tener 3 o más caracteres");
            }
        } while (!validado);

        videoClub.nuevoSocio(nif, nombre, edad, poblacion);
        System.out.println("Socio añadido correctamente");
    }

    /**
     * Crea una Pelicula solicitando los datos al usuario y validándolos
     */
    private void nuevaPelicula() {
        boolean validado;
        String titulo;
        Autor autor = null;
        Formato formato = null;
        int duracion;
        int anyo;
        Actor actorPrincipal;
        Actor actrizPrincipal;
        do {
            titulo = solicitarTitulo();
            validado = titulo.length() >= 3;
            if (!validado) {
                System.out.println("El título debe tener al menos 3 caracteres");
            }
        } while (!validado);

        do {
            int idAutor = solicitarAutor();
            validado = idAutor >= 0;
            if (validado) {
                autor = videoClub.buscarAutor(idAutor);
                validado = autor != null;
            } else {
                System.out.println("El id del autor debe ser un número positivo");
            }
        } while (!validado);

        do {
            int ordinalFormato = solicitarFormato();
            validado = ordinalFormato >= 0 && ordinalFormato < Formato.values().length;
            if (validado) {
                formato = Formato.values()[ordinalFormato];
            } else {
                System.out.println("Elija una opción del menú");
            }
        } while (!validado);

        do {
            duracion = solicitarDuracion();
            validado = duracion >= 0;
            if (!validado) {
                System.out.println("Duración debe ser un número positivo");
            }
        } while (!validado);

        do {
            anyo = solicitarAnyo();
            int anyoActual = Calendar.getInstance().get(Calendar.YEAR);
            validado = anyo >= 1900 && anyo <= anyoActual;
            if (!validado) {
                System.out.println("Anyo debe ser un número entre 1900 y " + anyoActual);
            }
        } while (!validado);

        do {
            int idActor = solicitarActorPrincipal();
            actorPrincipal = videoClub.buscarActor(idActor);
            validado = actorPrincipal != null;
        } while (!validado);

        do {
            int idActriz = solicitarActrizPrincipal();
            actrizPrincipal = videoClub.buscarActor(idActriz);
            validado = actrizPrincipal != null;
        } while (!validado);

        videoClub.nuevaPelicula(titulo, autor, formato, anyo, duracion, actorPrincipal, actrizPrincipal);
        System.out.println("Película añadida correctamente");
    }

    /**
     * Crea un Videojuego solicitando los datos al usuario y validándolos
     */
    private void nuevoVideojuego() {
        boolean validado;
        String titulo;
        Autor autor = null;
        Formato formato = null;
        int anyo;
        Plataforma plataforma = null;

        do {
            titulo = solicitarTitulo();
            validado = titulo.length() >= 3;
            if (!validado) {
                System.out.println("El título debe tener al menos 3 caracteres");
            }
        } while (!validado);

        do {
            int idAutor = solicitarAutor();
            validado = idAutor >= 0;
            if (validado) {
                autor = videoClub.buscarAutor(idAutor);
                validado = autor != null;
            } else {
                System.out.println("El id del autor debe ser un número positivo");
            }
        } while (!validado);

        do {
            int ordinalFormato = solicitarFormato();
            validado = ordinalFormato >= 0 && ordinalFormato < Formato.values().length;
            if (validado) {
                formato = Formato.values()[ordinalFormato];
            } else {
                System.out.println("Elija una opción del menú");
            }
        } while (!validado);

        do {
            anyo = solicitarAnyo();
            int anyoActual = Calendar.getInstance().get(Calendar.YEAR);
            validado = anyo >= 1900 && anyo <= anyoActual;
            if (!validado) {
                System.out.println("Anyo debe ser un número entre 1900 y " + anyoActual);
            }
        } while (!validado);

        do {
            int ordinalPlataforma = solicitarPlataforma();
            validado = ordinalPlataforma >= 0 && ordinalPlataforma < Plataforma.values().length;
            if (validado) {
                plataforma = Plataforma.values()[ordinalPlataforma];
            } else {
                System.out.println("Elija una opción del menú");
            }
        } while (!validado);

        videoClub.nuevoVideojuego(titulo, autor, formato, anyo, plataforma);
        System.out.println("Videojuego añadido correctamente");
    }

    /**
     * Solicita una plataforma válida al usuario a partir de un enumerado
     * 
     * @return La opción elegida por el usuario
     */
    private int solicitarPlataforma() {
        int ordinalPlataforma = -1;
        mostrarPlataformas();
        System.out.println("Elija una plataforma: ");
        try {
            ordinalPlataforma = Integer.parseInt(Util.myInput.nextLine());
        } catch (NumberFormatException nfe) {
            System.out.println("Indique el número que representa la plataforma");
        }
        return ordinalPlataforma;
    }

    /**
     * Solicita una actriz al usuario
     * 
     * @return La actriz elegida por el usuario
     */
    private int solicitarActrizPrincipal() {
        int idActriz = -1;
        mostrarActores();
        System.out.println("Id Actriz principal: ");
        try {
            idActriz = Integer.parseInt(Util.myInput.nextLine());
        } catch (NumberFormatException nfe) {
            System.out.println("Sólo números");
        }
        return idActriz;
    }

    /**
     * Solicita una actor al usuario
     * 
     * @return La actriz elegida por el usuario
     */
    private int solicitarActorPrincipal() {
        int idActor = -1;
        mostrarActores();
        System.out.println("Id Actor principal: ");
        try {
            idActor = Integer.parseInt(Util.myInput.nextLine());
        } catch (NumberFormatException nfe) {
            System.out.println("Sólo números");
        }
        return idActor;
    }

    /**
     * Muestra todos los Actores
     */
    private void mostrarActores() {
        for (Actor actor : videoClub.getActores()) {
            System.out.println(actor.toString());
        }
    }

    /**
     * Solicita un año
     * 
     * @return El año elegido o -1 en caso de error
     */
    private int solicitarAnyo() {
        int anyo = -1;
        System.out.println("Año: ");
        try {
            anyo = Integer.parseInt(Util.myInput.nextLine());
        } catch (NumberFormatException nfe) {
            System.out.println("Solo números");
        }
        return anyo;
    }

    /**
     * Solicita la duración
     * 
     * @return La duración elegida o -1 en caso de error
     */
    private int solicitarDuracion() {
        int duracion = -1;
        System.out.println("Duración: ");
        try {
            duracion = Integer.parseInt(Util.myInput.nextLine());
        } catch (NumberFormatException nfe) {
            System.out.println("Solo números");
        }
        return duracion;
    }

    /**
     * Solicita un formato
     * 
     * @return El ordinal del Formato o -1 en caso de error
     */
    private int solicitarFormato() {
        int ordinalFormato = -1;
        mostrarFormatos();
        System.out.println("Elija un formato: ");
        try {
            ordinalFormato = Integer.parseInt(Util.myInput.nextLine());
        } catch (NumberFormatException nfe) {
            System.out.println("Indique el número que representa el formato");
        }
        return ordinalFormato;
    }

    /**
     * Solicita un autor
     * 
     * @return El id del Autor elegido o -1 en caso de error
     */
    private int solicitarAutor() {
        int idAutor;
        mostrarAutores();
        System.out.println("Id Autor: ");
        try {
            idAutor = Integer.parseInt(Util.myInput.nextLine());
        } catch (NumberFormatException nfe) {
            idAutor = -1;
        }
        return idAutor;
    }

    /**
     * Muestra todas las Plataformas
     */
    private void mostrarPlataformas() {
        for (Plataforma plataforma : Plataforma.values()) {
            System.out.println(plataforma.ordinal() + ". " + plataforma);
        }
    }

    /**
     * Muestra todos los Formatos
     */
    private void mostrarFormatos() {
        for (Formato formato : Formato.values()) {
            System.out.println(formato.ordinal() + ". " + formato);
        }
    }

    /**
     * Muestra todos los Autores
     */
    private void mostrarAutores() {
        for (Autor autor : videoClub.getAutores()) {
            System.out.println(autor.toString());
        }
    }

    /**
     * Solicita el campo edad al usuario
     * 
     * @return La edad elegida por el usuario o -1 en caso de error
     */
    private int solicitarEdad() {
        int edad = -1;
        System.out.println("Edad: ");
        try {
            edad = Integer.parseInt(Util.myInput.nextLine());
        } catch (NumberFormatException nfe) {

        }
        return edad;
    }

    /**
     * Solicita el campo población al usuario
     * 
     * @return La población elegida por el usuario
     */
    private String solicitarPoblacion() {
        String poblacion;
        System.out.println("Población: ");
        poblacion = Util.myInput.nextLine();
        return poblacion;
    }

    /**
     * Solicita el campo nombre al usuario
     * 
     * @return El nombre elegido por el usuario
     */
    private String solicitarNombre() {
        String nombre;
        System.out.println("Nombre: ");
        nombre = Util.myInput.nextLine();
        return nombre;
    }

    /**
     * Solicita el campo título
     * 
     * @return El título elegido por el usuario
     */
    private String solicitarTitulo() {
        String titulo;
        System.out.println("Título: ");
        titulo = Util.myInput.nextLine();
        return titulo;
    }

    /**
     * Muestra el menú de altas y solicita una opción válida al usuario
     * 
     * @return La opción válida elegida por el usuario
     */
    private int menuAltas() {
        int opcion = -1;
        do {
            Util.cleanScreen();
            System.out.println("*************");
            System.out.println("**  ALTAS  **");
            System.out.println("*************");
            System.out.println("1. Nueva película");
            System.out.println("2. Nuevo videojuego");
            System.out.println("3. Nuevo socio");
            System.out.println("----------------------------------------------");
            System.out.println("0. Volver al menú principal\n");
            System.out.println("Elija una opción: ");
            try {
                opcion = Integer.parseInt(Util.myInput.nextLine());
                if (opcion < 0 || opcion > 3) {
                    System.out.println("Elija una opción del menú [0-3]");
                    Util.pause();
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Solo números por favor");
                Util.pause();
            }
        } while (opcion < 0 || opcion > 3);
        return opcion;
    }

    /**
     * Alquila un Multimedia solicitando los datos al usuario y validándolos
     */
    private void alquilar() {
        String nif;
        int codigo;
        nif = solicitarNif();
        Socio socio = videoClub.buscarSocio(nif);
        if (socio == null) {
            System.out.println("El nif indicado no corresponde a ningún socio");
            return;
        }
        if (socio.tieneRecargosPendientes()) {
            System.out.println("*** Imposible alquilar ***");
            System.out.println("El socio " + socio.getNombre() + " tiene recargos pendientes");
            return;
        }
        System.out.println("Socio: " + socio.getNombre());
        codigo = solicitarCodigo();
        if (codigo >= 0) {
            Multimedia m = videoClub.buscarMultimedia(codigo);
            if (m != null) {
                System.out.println("Multimedia: " + m.getTitulo());
                double precio = m.alquilar(socio);
                if (precio >= 0) {
                    System.out.println("El precio del alquiler es de " + precio + " €");
                } else {
                    System.out.println("No se ha podido realizar el alquiler");
                }
            } else {
                System.out.println("El código introducido no corresponde a ningún multimedia");
            }
        }
    }

    /**
     * Solicita un NIF al usuario
     * 
     * @return NIF elegido por el usuario
     */
    private String solicitarNif() {
        String nif;
        System.out.println("Nif: ");
        nif = Util.myInput.nextLine();
        return nif;
    }

    /**
     * Solicita el campo codigo al usuario
     * 
     * @return El código elegido o -1 en caso de error
     */
    private int solicitarCodigo() {
        int codigo = -1;
        System.out.println("Código: ");
        try {
            codigo = Integer.parseInt(Util.myInput.nextLine());
            if (codigo < 0) {
                System.out.println("El código debe ser mayor o igual que 0");
            }
        } catch (NumberFormatException nfe) {
            System.out.println("El código debe ser numérico");
        }
        return codigo;
    }

    /**
     * Devuelve un Alquiler solicitando y validando los datos necesarios
     */
    private void devolver() {
        int codigo;
        double recargo = 0;
        codigo = solicitarCodigo();
        if (codigo >= 0) {
            Multimedia m = videoClub.buscarMultimedia(codigo);
            if (m != null) {
                if (m.isAlquilado()) {
                    recargo = m.devolver();
                    if (recargo > 0) {
                        System.out.println("**** DEVOLUCIÓN CON RECARGO ****");
                        System.out.println("La devolución ha generado un recargo de " + recargo + "€");
                        Alquiler a = m.getAlquileres().get(m.getAlquileres().size() - 1);
                        System.out.println(a.toString());
                    } else {
                        System.out.println("La devolución se ha realizado correctamente");
                    }
                } else {
                    System.out.println("Imposible devolver. No existe ningún alquiler");
                }
            } else {
                System.out.println("El código introducido no corresponde a ningún multimedia");
            }
        }
    }

    /**
     * Muestra el menú principal de la aplicación y solicita al usuario una opción
     * válida
     * 
     * @return La opción (válida) elegida por el usuario
     */
    private int menuPrincipal() {
        int opcion = -1;
        do {
            Util.cleanScreen();
            System.out.println("*************************");
            System.out.println("* GESTIÓN DE ALQUILERES *");
            System.out.println("*************************");
            System.out.println("1. Altas ...");
            System.out.println("2. Alquilar");
            System.out.println("3. Devolver");
            System.out.println("4. Consultas...");
            System.out.println("-----------------------");
            System.out.println("0. Salir\n");
            System.out.println("Elija una opción: ");
            try {
                opcion = Integer.parseInt(Util.myInput.nextLine());
                if (opcion < 0 || opcion > 4) {
                    System.out.println("Elija una opción del menú [0-4]");
                    Util.pause();
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Solo números por favor");
                Util.pause();
            }
        } while (opcion < 0 || opcion > 4);
        return opcion;
    }

    /**
     * Muestra el menú de consultas, solicita una opción y ejecuta la opción
     * seleccionada
     */
    private void consultas() {
        int opcion;
        Socio socio;
        do {
            opcion = menuConsultas();
            switch (opcion) {
                case 1:
                    mostrarMultimedia(Orden.DEFAULT);
                    Util.pause();
                    break;
                case 2:
                    mostrarPeliculas(Orden.TITULO);
                    Util.pause();
                    break;
                case 3:
                    mostrarVideojuegos(Orden.ANYO);
                    Util.pause();
                    break;
                case 4:
                    mostrarAlquileres(Orden.FECHA_ALQUILER);
                    Util.pause();
                    break;
                case 5:
                    socio = solicitarSocio();
                    if (socio != null) {
                        mostrarHistoricoAlquileresSocio(socio);
                    } else {
                        System.out.println("El nif introducido no corresponde a ningún socio");
                    }
                    Util.pause();
                    break;
                case 6:
                    socio = solicitarSocio();
                    if (socio != null) {
                        mostrarAlquileresActualesSocio(socio);
                    } else {
                        System.out.println("El nif introducido no corresponde a ningún socio");
                    }
                    Util.pause();
                    break;
                case 7:
                    mostrarAlquileresPendientesDevolver();
                    Util.pause();
                    break;
                case 8:
                    mostrarSociosConRecargosPendientes();
                    Util.pause();
                    break;
                case 0:
                    break;
            }
        } while (opcion != 0);
    }

    /**
     * Solicita un Socio al usuario a partir de su NIF
     * 
     * @return El Socio indicado o null en caso de no encontrarlo
     */
    private Socio solicitarSocio() {
        System.out.println("Nif: ");
        String nif = Util.myInput.nextLine();
        for (Socio socio : videoClub.getSocios()) {
            if (socio.getNif().equalsIgnoreCase(nif)) {
                return socio;
            }
        }
        return null;
    }

    /**
     * Muestra aquellos Socios que tienen recargos pendientes
     */
    private void mostrarSociosConRecargosPendientes() {
        for (Socio socio : videoClub.getSocios()) {
            for (Recargo r : socio.getRecargos()) {
                if (r.getFechaPago() == null) {
                    System.out.println(r.toString());
                }
            }
        }
    }

    /**
     * Muestra el histórico de alquileres del Socio indicado como parámetro
     * 
     * @param socio Socio del historial
     */
    private void mostrarHistoricoAlquileresSocio(Socio socio) {
        ArrayList<Alquiler> alquileres = new ArrayList<>();
        for (Multimedia m : videoClub.getMultimedia()) {
            for (Alquiler a : m.getAlquileres()) {
                if (a.getSocio().getNif().equalsIgnoreCase(socio.getNif())) {
                    alquileres.add(a);
                }
            }
        }

        ordenarAlquileres(alquileres, Orden.FECHA_ALQUILER);
        for (Alquiler a : alquileres) {
            System.out.println(a.toString());
        }
    }

    /**
     * Muestra los Alquileres activos de un Socio
     * 
     * @param socio Socio del que se quieren obtener los Alquileres
     */
    private void mostrarAlquileresActualesSocio(Socio socio) {
        ArrayList<Alquiler> alquileres = new ArrayList<>();
        for (Multimedia m : videoClub.getMultimedia()) {
            if (m.getAlquileres().size() > 0) {
                Alquiler ultimoAlquiler = m.getAlquileres().get(m.getAlquileres().size() - 1);
                if (ultimoAlquiler.getSocio().getNif().equalsIgnoreCase(socio.getNif())
                        && ultimoAlquiler.getFechaDevolucion() == null) {
                    alquileres.add(ultimoAlquiler);
                }
            }
        }
        ordenarAlquileres(alquileres, Orden.FECHA_ALQUILER);
        for (Alquiler a : alquileres) {
            System.out.println(a.toString());
        }
    }

    /**
     * Muestra todos los Alquileres están pendientes de devolver
     */
    private void mostrarAlquileresPendientesDevolver() {
        for (Multimedia m : videoClub.getMultimedia()) {
            for (Alquiler a : m.getAlquileres()) {
                if (a.getFechaDevolucion() == null) {
                    System.out.print("[" + m.getId() + " " + m.getTitulo() + "] ");
                    System.out.println(a.toString());
                }
            }
        }
    }

    /**
     * Muestra los alquileres según el orden indicado
     * 
     * @param orden Ordenación elegida
     */
    private void mostrarAlquileres(Orden orden) {
        ArrayList<Alquiler> alquileres = new ArrayList<>();
        for (Multimedia m : videoClub.getMultimedia()) {
            for (Alquiler a : m.getAlquileres()) {
                alquileres.add(a);
            }
        }
        ordenarAlquileres(alquileres, orden);
        for (Alquiler a : alquileres) {
            System.out.println(a.toString());
        }
    }

    /**
     * Muestra los videojuegos ordenados según el parámetro indicado
     * 
     * @param orden Ordenación elegida
     */
    private void mostrarVideojuegos(Orden orden) {
        ordenarMultimedia(videoClub.getMultimedia(), orden);
        for (Multimedia m : videoClub.getMultimedia()) {
            if (m instanceof Videojuego) {
                System.out.println(m.toString());
            }
        }
    }

    /**
     * Muestra los Multimedia ordenados según el parámetro indicado
     * 
     * @param orden Ordenación elegida
     */
    private void mostrarMultimedia(Orden orden) {
        ordenarMultimedia(videoClub.getMultimedia(), orden);
        for (Multimedia m : videoClub.getMultimedia()) {
            System.out.println(m.toString());
        }
    }

    /**
     * Ordena los multimedia indicados según el orden pasado como parámetro
     * 
     * @param multimedia Lista de Multimedia a ordenar
     * @param orden      Orden elegido
     */
    private void ordenarMultimedia(ArrayList<Multimedia> multimedia, Orden orden) {
        switch (orden) {
            case TITULO:
                multimedia.sort(new Multimedia.ComparatorTitulo());
                break;
            case ANYO:
                multimedia.sort(new Multimedia.ComparatorAnyo());
                break;
        }
    }

    /**
     * Ordena los alquileres indicados según el orden pasado como parámetro
     * 
     * @param alquileres Lista de Alquileres a ordenar
     * @param orden      Orden elegido
     */
    private void ordenarAlquileres(ArrayList<Alquiler> alquileres, Orden orden) {
        switch (orden) {
            case FECHA_ALQUILER:
                alquileres.sort(new Alquiler.ComparatorFechaAlquiler());
                break;
        }
    }

    /**
     * Muestra las Peliculas ordenados según el orden indicado
     * 
     * @param orden Orden elegido
     */
    private void mostrarPeliculas(Orden orden) {
        ordenarMultimedia(videoClub.getMultimedia(), orden);
        for (Multimedia m : videoClub.getMultimedia()) {
            if (m instanceof Pelicula) {
                System.out.println(m.toString());
            }
        }
    }

    /**
     * Muestra el menú de consultas y solicita una opción válida al usuario
     * 
     * @return La opción elegida por el usuario
     */
    private int menuConsultas() {
        int opcion = -1;
        do {
            Util.cleanScreen();
            System.out.println("**************");
            System.out.println("* CONSULTAS  *");
            System.out.println("**************");
            System.out.println("1. Mostrar todos los objetos multimedia");
            System.out.println("2. Mostrar películas ordenadas por título");
            System.out.println("3. Mostrar videojuegos ordenados por año");
            System.out.println("4. Mostrar todos los alquileres");
            System.out.println("5. Mostrar histórico de alquileres de un socio");
            System.out.println("6. Mostrar alquileres actuales de un socio");
            System.out.println("7. Mostrar alquileres pendientes de devolver");
            System.out.println("8. Mostrar socios con recargos pendientes");
            System.out.println("----------------------------------------------");
            System.out.println("0. Volver al menú principal\n");
            System.out.println("Elija una opción: ");
            try {
                opcion = Integer.parseInt(Util.myInput.nextLine());
                if (opcion < 0 || opcion > 8) {
                    System.out.println("Elija una opción del menú [0-8]");
                    Util.pause();
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Solo números por favor");
                Util.pause();
            }
        } while (opcion < 0 || opcion > 8);
        return opcion;

    }
}
