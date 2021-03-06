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
        // System.out.println(i.getVehiculoActual().alquilarVehiculo(i.getConductorActual()));
        if (i.getVehiculoActual().alquilarVehiculo(i.getConductorActual()) == true) {
            System.out.println("Vehiculo Alquilado Exitosamente");
            System.out.println(i.getConductorActual().getVehiculoAlquilado());
        }
        menu();
    }

    public void devolverVehiculo() {
        seleccionarDatos();
        i.setAlquilerActual();
        System.out.println("Devolver Vehiculo");
        System.out.println("Introduce los km recorridos ");
        user = Util.myInput.nextLine();
        double km = Double.parseDouble(user);
        i.devolverVehiculo(km);
        // volvemos al menu
        menu();
    }

    public void mostrarAlquileres() {
        System.out.println("Mostrar registro de Alquileres");
        System.out.println(i.mostrarAlquileres());
        menu();
    }

    public void mostrarEstadisticas() {
        System.out.println("El vehiculo mas alquilado es " + i.vehiculoMasAlquilado());
    }

    public boolean seleccionarDatos() {
        char si = 'Y';
        boolean correct = Control.one("Quieres seguir utilizando los datos anteriores Y/N", si);
        if (!correct) {
            preguntarDatos();
            return false;
        }
        System.out.println("Utilizamos los datos anteriores");
        return true;
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
