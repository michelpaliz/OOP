package Tema08.EjemplosTema8.Tema8Adv.Cajero;

import java.util.Scanner;

import Tema08.EjemplosTema8.Cajero.config.Config;
import Tema08.EjemplosTema8.Cajero.util.Lib;

public class Cajero {
    private final Scanner scanner;
    private final Proxy proxy;

    public Cajero(Proxy proxy) {
        int opcion;
        this.proxy = proxy;
        scanner = new Scanner(System.in);
        do {
            opcion = mostrarMenuInicial();
            switch (opcion) {
                case 1:
                    insertarTarjeta();
                    opcion = 0;
                    break;
                case 0:
                    System.out.println("Hasta pronto!");
                    break;
            }
        } while (opcion != 0);
    }

    private void insertarTarjeta() {
        int intentosRestantes = Config.NUMERO_INTENTOS_PIN;
        boolean validado = false;
        do {
            System.out.println("Número tarjeta: ");
            String numeroTarjeta = scanner.nextLine();
            System.out.println("PIN: ");
            String pin = scanner.nextLine();
            validado = proxy.validarCredenciales(numeroTarjeta, pin);
            intentosRestantes--;
            if (validado) {
                int opcion;
                do {
                    opcion = mostrarMenuPrincipal();
                    switch (opcion) {
                        case 1:
                            ingresar(numeroTarjeta);
                            Util.pausa();
                            break;
                        case 2:
                            retirar(numeroTarjeta);
                            Util.pausa();
                            break;
                        case 3:
                            consultarSaldo(numeroTarjeta);
                            Util.pausa();
                            break;
                        case 4:
                            // TODO Implementar el método cambiarPin
                            // Al final de la pila de llamadas (Proxy, Empresa, Banco)
                            // hay que invocar al método cambiarPin(String oldPin, String newPin)
                            // de la clase Tarjeta.
                            cambiarPin(numeroTarjeta);
                            Util.pausa();
                            break;
                        case 0:
                            System.out.println("Hasta pronto");
                            break;
                        default:
                            System.out.println("Opción no válida");
                            Util.pausa();
                            break;
                    }
                } while (opcion != 0);
            } else {
                System.out.printf("PIN incorrecto (quedan %d intentos)\n\n", intentosRestantes);
            }
        } while (intentosRestantes > 0 && !validado);
    }

    private void consultarSaldo(String numTarjeta) {
        double saldo = proxy.consultarSaldo(numTarjeta);
        if (saldo > Long.MIN_VALUE) {
            System.out.printf("Tu saldo actual es %.2f\n", saldo);
        } else {
            System.out.println("Ha habido un error en la comunación");
        }
    }

    private void cambiarPin(String numTarjeta) {
        System.out.println("Pin actual: ");
        String pinActual = scanner.nextLine();
        System.out.println("Nuevo Pin: ");
        String nuevoPin = scanner.nextLine();
        if (proxy.cambiarPin(numTarjeta, pinActual, nuevoPin).equals(nuevoPin)) {
            System.out.println("El pin se ha cambiado correctamente");
        } else {
            System.out.println("No se ha podido cambiar el pin");
        }
    }

    private void retirar(String numTarjeta) {
        System.out.println("Cantidad: ");
        double cantidad = Double.parseDouble(scanner.nextLine());
        if (cantidad > 0) {
            double result = proxy.retirar(numTarjeta, cantidad);
            if (result == cantidad) {
                System.out.println("Se han retirado " + cantidad + " de la cuenta de la tarjeta");
            } else if (result == 0) {
                System.out.println("No tiene suficiente saldo");
            } else {
                System.out.println("Ha ocurrido un error. Vuelva a intentarlo en unos minutos");
            }
        } else {
            System.out.println("La cantidad a retirar debe ser positiva");
        }
    }

    private void ingresar(String numTarjeta) {
        System.out.println("Cantidad: ");
        double cantidad = Double.parseDouble(scanner.nextLine());
        if (cantidad > 0) {
            if (proxy.ingresar(numTarjeta, cantidad)) {
                System.out.println("Se han ingresado " + cantidad + " en la cuenta de la tarjeta");
            } else {
                System.out.println("Ha ocurrido un error. Vuelva a intentarlo en unos minutos");
            }
        } else {
            System.out.println("La cantidad a ingresar debe ser positiva");
        }
    }

    private int mostrarMenuPrincipal() {
        int opcion;
        boolean validado = false;
        do {
            System.out.println("***********************");
            System.out.println("** CAJERO AUTOMÁTICO **");
            System.out.println("***********************");
            System.out.println("1. Ingresar");
            System.out.println("2. Retirar");
            System.out.println("3. Consultar saldo");
            // TODO se deja como tarea implementar la funcionalidad de cambiar PIN
            System.out.println("4. Cambiar pin");
            System.out.println("-------------------");
            System.out.println("0. Salir");
            System.out.println();
            System.out.println("Elija una opción: ");
            opcion = Integer.parseInt(scanner.nextLine());
            validado = opcion >= 0 && opcion <= 4;
        } while (!validado);
        return opcion;
    }

    private int mostrarMenuInicial() {
        int opcion;
        boolean validado = false;
        do {
            System.out.println("***********************");
            System.out.println("** CAJERO AUTOMÁTICO **");
            System.out.println("***********************");
            System.out.println("1. Insertar tarjeta");
            System.out.println("-------------------");
            System.out.println("0. Salir");
            System.out.println();
            System.out.println("Elija una opción: ");
            opcion = Integer.parseInt(scanner.nextLine());
            validado = opcion >= 0 && opcion <= 1;
        } while (!validado);
        return opcion;
    }
}
