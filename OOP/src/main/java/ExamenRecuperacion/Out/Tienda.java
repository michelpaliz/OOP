package ExamenRecuperacion.Out;

import Lib.Control;
import Lib.Util;

public class Tienda {
    private Inventario i;
    private String user;
    private int userInt;

    public Tienda() {
        i = new Inventario();
        menu();
    }

    public void menu() {
        String tittle = "TIenda";
        String[] sentence = { "Salir", "Alquilar Vehiculo", "Devolver Vehiculo y pagar", "Estadisticas",
                "Registro Alquiler" };
        int user = Control.menuGenerator(tittle, sentence);
        switch (user) {
            case 0:
                System.out.println("Adios");
                break;
            case 1:
                alquilarVehiculo();
                break;
            case 2:
                devolverVehiculo();
                break;
            case 3:
                mostrarEstadisticas();
                break;
            case 4:
                mostrarAlquileres();
                break;
        }
    }

    public void mostrarVehiculos() {
        seleccionarDatos();
        System.out.println("Mostramos datos primero");
        i.ordenarVehiculos();
    }

    public void mostrarConductores() {
        System.out.println("Mostramos datos primero");
        System.out.println(i.getListaConductores());
    }

    public void alquilarVehiculo() {
        preguntarDatos();
        if (i.getVehiculoActual().alquilarVehiculo(i.getConductorActual())) {
            System.out.println("Vehiculo Alquilado Exitosamente");
            System.out.println(i.getConductorActual());

        }

        // System.out.println("Muestras");
        // System.out.println(i.getVehiculoActual().getAlquileres());
        // i.setAlquilerActual();
        // System.out.println("Vehiculo alquilado exitosamente");

        menu();
    }

    public void devolverVehiculo() {
        seleccionarDatos();
        System.out.println("Devolver Vehiculo");
        System.out.println("Introduce los km recorridos ");
        userInt = Util.myInput.nextInt();
        i.devolverVehiculo(userInt);
        // volvemos al menu
        menu();
    }

    public void mostrarAlquileres() {
        System.out.println("Mostrar Alquieres");
        if (i.getAlquilerActual().isAlquilado() == false) {
            System.out.println("El vehiculo no tiene alquileres");
        } else {
            System.out.println(i.getVehiculoActual().getAlquileres());
        }

    }

    public void mostrarEstadisticas() {
        System.out.println("El vehiculo mas alquilado es " + i.vehiculoMasAlquilado());
    }

    public void seleccionarDatos() {
        char si = 'Y';
        boolean correct = Control.one("Quieres seguir utilizando los datos anteriores Y/N", si);
        if (!correct) {
            preguntarDatos();
        }
    }

    public void preguntarDatos() {
        mostrarConductores();
        System.out.println("Ingresa el dni del conductor");
        user = Util.myInput.nextLine();
        i.setConductorSeleccionado(user);
        i.getConductorActual();
        System.out.println("Conductor seleccionado exitosamentes");
        System.out.println("Escoge el vehiculo del conductor ");
        // mostrarVehiculos();
        System.out.println(i.getConductorActual().getVehiculoAlquilado());
        System.out.println("Ingresa la matricula del vehiculo");
        user = Util.myInput.nextLine();
        i.setVehiculoSeleccionado(user);
        System.out.println("Vehiculo seleccionado exitosamente");
        System.out.println("El vehiculo actual es");
        System.out.println(i.getVehiculoActual());
    }

}
