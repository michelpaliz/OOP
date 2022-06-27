package ExamenRecuperacion.Out;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.github.javafaker.Faker;

import Examen.Models.MuebleAux;
import ExamenRecuperacion.Interface.IEstadisticas;
import ExamenRecuperacion.Models.Autocaravana;
import ExamenRecuperacion.Models.Coche;
import ExamenRecuperacion.Models.Conductor;
import ExamenRecuperacion.Models.Vehiculo;
import ExamenRecuperacion.numeric.NCombustible;
import Lib.Util;

public class Inventario implements IEstadisticas {
    private static Faker fk = new Faker();
    private final int MAX_CONDUCTORES = 3;
    private final int MAX_VEHICULOS = 20;
    private List<Conductor> listaConductores;
    private List<Vehiculo> listaVehiculos;
    private Conductor conductorActual;
    private Vehiculo vehiculoActual;

    public Inventario() {
        randomConductor(MAX_CONDUCTORES, MAX_VEHICULOS);
    }

    public List<Conductor> getListaConductores() {
        return listaConductores;
    }

    public List<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public Conductor getConductorActual() {
        return conductorActual;
    }

    public Vehiculo getVehiculoActual() {
        return vehiculoActual;
    }

    public void randomConductor(int cantidadConductores, int cantidadVehiculos) {
        listaVehiculos = new ArrayList<>();
        Date d1 = new Date(); // obtenemos la fecha actual
        Date fechaNacimientoMInima = new GregorianCalendar(2000, Calendar.FEBRUARY, 11).getTime();
        Date fechaLicenciaMinima = new GregorianCalendar(2000, Calendar.FEBRUARY, 11).getTime();
        GregorianCalendar fechaNacimientoGc = new GregorianCalendar();
        GregorianCalendar fechaLicenciaGc = new GregorianCalendar();
        for (int i = 0; i < MAX_CONDUCTORES; i++) {
            String dni = fk.number().digits(8);
            String nombre = fk.name().firstName();
            Date fechaNacimiento = fk.date().between(fechaNacimientoMInima, d1);
            Date fechaLicenciaConducir = fk.date().between(fechaLicenciaMinima, d1);
            fechaNacimientoGc.setTime(fechaNacimiento);
            fechaLicenciaGc.setTime(fechaLicenciaConducir);
            conductorActual = new Conductor(dni, nombre, fechaNacimientoGc, fechaLicenciaGc);
            conductorActual.getVehiculoAlquilado().addAll(vehiculoAsignado(cantidadVehiculos));
            listaConductores.add(conductorActual);
        }
    }

    private List<Vehiculo> vehiculoAsignado(int cantidad) {
        randomVehiculo(cantidad);// generamos los mueblesDuplicados
        List<Vehiculo> lista = new ArrayList<>(2);
        for (int i = 0; i < 2; i++) {// solo asignamos 2 mueblesDuplicados por catalogo
            vehiculoActual = listaVehiculos.get(Util.random(0, listaVehiculos.size()));
            lista.add(vehiculoActual);
        }
        // nos devuelve que los conductores tienen 2 vehiculos alquilados
        return lista;
    }

    public List<Vehiculo> randomVehiculo(int cantidad) {
        NCombustible tipoCombustible = NCombustible.DIESEL;
        for (int i = 0; i < cantidad / 2; i++) {
            String marca = fk.funnyName().name();
            String modelo = fk.funnyName().name();
            double precioAlquiler = fk.number().randomDouble(2, 20, 100);
            double precioKm = fk.number().randomDouble(2, 5, 10);
            tipoCombustible = tipoCombustible.getRandom();
            boolean placasSolares = true;
            vehiculoActual = new Autocaravana(marca, modelo, precioAlquiler, precioKm, tipoCombustible, placasSolares);
            listaVehiculos.add(vehiculoActual);
        }
        for (int i = 0; i < cantidad / 2; i++) {
            String marca = fk.funnyName().name();
            String modelo = fk.funnyName().name();
            double precioAlquiler = fk.number().randomDouble(2, 20, 100);
            double precioKm = fk.number().randomDouble(2, 5, 10);
            tipoCombustible = tipoCombustible.getRandom();
            int numPlazas = fk.number().numberBetween(0, 10);
            vehiculoActual = new Coche(marca, modelo, precioAlquiler, precioKm, tipoCombustible,
                    numPlazas);
            listaVehiculos.add(vehiculoActual);
        }
        return listaVehiculos;
    }

    private Conductor buscarConductor(String dni) {
        for (Conductor c : listaConductores) {
            if (c.getDni().equals(dni)) {
                return c;
            }
        }
        return null;
    }

    private Vehiculo buscarVehiculo(int idMueble) {

        for (Vehiculo v : conductorActual.getVehiculoAlquilado()) {
            // esto lo pongo asi porque me da pereza escribir todo el string porque
            // simplemente lloamando la clase override de equals bastaria y fuese mas
            // entendible.
            if (v.getMatricula().equalsIgnoreCase("C00" + idMueble)) {
                return v;
            }
        }
        return null;
    }

    public boolean setConductorSeleccionado(String dni) {
        conductorActual = buscarConductor(dni);
        return conductorActual != null;
    }

    public boolean setVehiculoSeleccionado(int id) {
        vehiculoActual = buscarVehiculo(id);
        return vehiculoActual != null;
    }

    public void ordenarVehiculos() {
        listaVehiculos.sort(new Vehiculo.OrdenarPorPrecio());
        System.out.println(listaVehiculos);
    }

    public void ordenarVehiculosPorTIpo() {
        listaVehiculos.sort(new Vehiculo.CompararPorTipo());
        System.out.println(listaVehiculos);
    }

    public List<Vehiculo> clasificarTipo(int tipo) {
        Set<Vehiculo> vehiculoSet = new HashSet<Vehiculo>();
        List<Vehiculo> vehiculo = new ArrayList<>();
        // Iterator<Mueble> iterator = mueblesSet.iterator();
        if (tipo == 0) {
            for (int i = 0; i < listaConductores.size(); i++) {
                for (int j = 0; j < listaConductores.get(i).getVehiculoAlquilado().size(); j++) {
                    if (Coche.class == listaConductores.get(i).getVehiculoAlquilado().get(j).getClass()) {
                        Vehiculo vehiculoEncontrado = listaConductores.get(i).getVehiculoAlquilado().get(j);
                        vehiculoSet.add(vehiculoEncontrado);// no admite duplicados
                    }
                }
            }
        } else {
            for (int i = 0; i < listaConductores.size(); i++) {
                for (int j = 0; j < listaConductores.get(i).getVehiculoAlquilado().size(); j++) {
                    if (Autocaravana.class == listaConductores.get(i).getVehiculoAlquilado().get(j).getClass()) {
                        Vehiculo vehiculoEncontrado = listaConductores.get(i).getVehiculoAlquilado().get(j);
                        vehiculoSet.add(vehiculoEncontrado);// no admite duplicados
                    }
                }
            }
        }
        for (Vehiculo v : vehiculoSet) {
            vehiculo.add(v);
        }
        vehiculo.sort(new Vehiculo.CompararPorTipo());
        return vehiculo;
    }

    // Recolecta todos los muebles que estan en los catalogos.
    public List<Vehiculo> totalMuebles() {
        List<Vehiculo> vehiculo = new ArrayList<>();
        for (int i = 0; i < listaConductores.size(); i++) {
            for (int j = 0; j < listaConductores.get(i).getVehiculoAlquilado().size(); j++) {
                vehiculo.add(listaConductores.get(i).getVehiculoAlquilado().get(j));
            }
        }
        return vehiculo;
    }

    // public void devolverVehiculo(){
    //     for (int i = 0; i < listaConductores.size(); i++) {
    //         for (int j = 0; j < listaConductores.get(i).getVehiculoAlquilado().size(); j++) {
    //             if (Autocaravana.class == listaConductores.get(i).getVehiculoAlquilado().get(j).getClass()) {
    //                 Vehiculo vehiculoEncontrado = listaConductores.get(i).getVehiculoAlquilado().get(j);
    //                 vehiculoSet.add(vehiculoEncontrado);// no admite duplicados
    //             }
    //         }
    //     }
    // }


    @Override
    public Vehiculo vehiculoMasAlquilado() {
        List<Vehiculo> vehiculos = totalMuebles();
        Vehiculo vehiculo = vehiculos.get(1);
        for (int i = 0; i < vehiculos.size(); i++) {
            if (vehiculo.getAlquileres().size() < vehiculos.get(i).getAlquileres().size()) {
                vehiculo = vehiculos.get(i); // dame el mueble que mas registros de ventas tiene.
            }
        }
        return vehiculo;
    }

}
