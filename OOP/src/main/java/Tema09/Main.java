package Tema09;

import Tema09.utils.*;

public class Main {

    private final static Pila<String> pila = new Pila(10);

    public static void main(String[] args) {
        int opcion;
        crearOpcionesMenuPrincipal();
        do {
            opcion = menuPrincipal();
            switch (opcion) {
                case 1:
                    int opcionPrimero = menuPrimero();
                    switch (opcionPrimero) {
                        case 1:
                            System.out.println("1");
                            break;
                        case 2:
                            System.out.println("2");
                            break;
                        case 0:
                            pila.pop();
                            break;
                    }
                    break;
                case 2:
                    int opcionSegundo = menuSegundo();
                    switch (opcionSegundo) {
                        case 1:
                            System.out.println("1");
                            break;
                        case 2:
                            System.out.println("2");
                            break;
                        case 0:
                            pila.pop();
                            break;
                    }
                    break;
                case 0:
                    pila.pop();
                    break;
            }
        } while (opcion != 0);
    }

    private static void crearOpcionesMenuPrimero() {
        StringBuilder builder = new StringBuilder();
        builder.append("MENU PRIMERO\n");
        builder.append("1. PRIMERO\n");
        builder.append("2. SEGUNDO\n");
        builder.append("----------\n");
        builder.append("0. Salir\n");
        pila.push(builder.toString());
    }

    private static int menuPrimero() {
        int opcion;
        crearOpcionesMenuPrimero();
        do {
            System.out.println(pila.top());
            opcion = Lib.readInt("Elige una opción:");
        } while (opcion < 0 || opcion > 2);
        return opcion;
    }

    private static void crearOpcionesMenuSegundo() {
        StringBuilder builder = new StringBuilder();
        builder.append("MENU SEGUNDO\n");
        builder.append("1. PRIMERO\n");
        builder.append("2. SEGUNDO\n");
        builder.append("----------\n");
        builder.append("0. Salir\n");
        pila.push(builder.toString());
    }

    private static int menuSegundo() {
        int opcion;
        crearOpcionesMenuSegundo();
        do {
            System.out.println(pila.top());
            opcion = Lib.readInt("Elige una opción:");
        } while (opcion < 0 || opcion > 2);
        return opcion;
    }

    private static int menuPrincipal() {
        int opcion;
        do {
            System.out.println(pila.top());
            opcion = Lib.readInt("Elige una opción:");
        } while (opcion < 0 || opcion > 2);
        return opcion;
    }

    private static void crearOpcionesMenuPrincipal() {
        StringBuilder builder = new StringBuilder();
        builder.append("MENÚ PRINCIPAL\n");
        builder.append("1. PRIMERO\n");
        builder.append("2. SEGUNDO\n");
        builder.append("----------\n");
        builder.append("0. Salir\n");
        pila.push(builder.toString());
    }

    /*
     * 
     * public static byte[] readFile(String filePath) throws IOException,
     * InputMismatchException {
     * int fileSize = getFileSize();
     * byte[] data = new byte[fileSize];
     * // abrir archivo
     * // leer archivo
     * // cerrar
     * try {
     * // abrir archivo
     * // leer archivo
     * } catch (IOException ioe) {
     * // cerrar archivo
     * throw new IOException(ioe.getMessage());
     * } finally {
     * // cerrar archivo
     * }
     * return data;
     * }
     */

}
