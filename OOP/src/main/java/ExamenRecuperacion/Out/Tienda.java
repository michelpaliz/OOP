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

                break;
            case 3:
                mostrarEstadisticas();
                break;
            case 4:

                break;
        }
    }

    public void mostrarVehiculos() {
        System.out.println("Mostramos datos primero");
        i.ordenarVehiculos();
    }

    public void mostrarConductores() {
        System.out.println("Mostramos datos primero");
        System.out.println(i.getListaConductores());
    }

    public void alquilarVehiculo() {
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
        i.getVehiculoActual().alquilarVehiculo(i.getConductorActual());
        System.out.println("Vehiculo alquilado exitosamente");

    }

    public void devolverVehiculo() {
        System.out.println("Ingresa la matricula del vehiculo");
        user = Util.myInput.nextLine();
        i.setVehiculoSeleccionado(user);
        System.out.println("Vehiculo seleccionado exitosamente");

    }

    public void mostrarEstadisticas() {
        System.out.println("El vehiculo mas alquilado es " + i.vehiculoMasAlquilado());
    }

}
