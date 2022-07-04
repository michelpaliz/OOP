package ExamenRecuperacion.Out;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.github.javafaker.Faker;

import ExamenRecuperacion.Interface.IEstadisticas;
import ExamenRecuperacion.Models.Alquiler;
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
    private final int MAX_ALQUILERES = 20;
    private List<Conductor> listaConductores;
    private List<Vehiculo> listaVehiculos;
    private List<Alquiler> listaAlquileres;
    private Conductor conductorActual;
    private Vehiculo vehiculoActual;
    private Alquiler alquilerActual;

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

    public Alquiler getAlquilerActual() {
        return alquilerActual;
    }

    public List<Alquiler> getListaAlquileres() {
        return listaAlquileres;
    }

    public void randomConductor(int cantidadConductores, int cantidadVehiculos) {
        listaConductores = new ArrayList<>();
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
            vehiculoActual = listaVehiculos.get(Util.random(0, listaVehiculos.size() - 1));
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

    // private List<Alquiler> alquileresAsignado(int cantidad) {
    // randomAlquileres(cantidad);
    // List<Alquiler> lista = new ArrayList<>(2);
    // for (int i = 0; i < 2; i++) {// solo asignamos 2 mueblesDuplicados por
    // catalogo
    // alquilerActual = listaAlquileres.get(Util.random(0, listaAlquileres.size()));
    // lista.add(alquilerActual);
    // }
    // // nos devuelve que los conductores tienen 2 vehiculos alquilados
    // return lista;
    // }

    // public List<Alquiler> randomAlquileres(int cantidad) {
    // listaAlquileres = new ArrayList<>();
    // Date d1 = new GregorianCalendar(2000, Calendar.FEBRUARY, 11).getTime();
    // Date d2 = new Date();
    // GregorianCalendar fechaAlquiler = new GregorianCalendar();
    // GregorianCalendar fechaDevolucion = new GregorianCalendar();
    // for (int i = 0; i < cantidad; i++) {
    // Date fecha = fk.date().between(d1, d2);
    // conductorActual = listaConductores.get(Util.randBetween(0,
    // listaConductores.size()));
    // fechaAlquiler.setTime(fecha);
    // vehiculoActual = listaVehiculos.get(Util.randBetween(0,
    // listaVehiculos.size()));
    // fechaDevolucion.setTime(fecha);
    // double km = fk.number().randomDouble(2, 10, 100);
    // alquilerActual = new Alquiler(fechaAlquiler, conductorActual, vehiculoActual,
    // fechaDevolucion, km);
    // listaAlquileres.add(alquilerActual);
    // }
    // return listaAlquileres;
    // }

    private Alquiler buscarAlquiler() {
        for (Alquiler a : getVehiculoActual().getAlquileres()) {
            if (a.isAlquilado()) {
                return a;
            } else {
                System.out.println("El alquiler ya esta devuelto");
            }
        }
        return null;
    }

    private Conductor buscarConductor(String dni) {
        for (Conductor c : listaConductores) {
            if (c.getDni().equals(dni)) {
                return c;
            }
        }
        return null;
    }

    private Vehiculo buscarVehiculo(String matricula) {
        for (Vehiculo v : getConductorActual().getVehiculoAlquilado()) {
            if (v.getMatricula().equals(matricula)) {
                return v;
            }
        }
        return null;
    }

    public void setAlquilerActual() {
        this.alquilerActual = buscarAlquiler();
    }

    public boolean setConductorSeleccionado(String dni) {
        conductorActual = buscarConductor(dni);
        return conductorActual != null;
    }

    public boolean setVehiculoSeleccionado(String id) {
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

    public boolean devolverVehiculo(double kmRecorridos) {
        // cogemos el alquiler en caso que este no devuelto
        if (getAlquilerActual().isAlquilado() == true) {
            alquilerActual.setKmRecorridos(kmRecorridos);
            alquilerActual.setFechaDevolucion();
            System.out.println("Alquiler exitosamente devuelto");
            return true;
        } else {
            System.out.println("El alquiler ya esta devuelto en la fecha = " + alquilerActual.getFechaDevolucion());
            return false;
        }
        // for (int i = 0; i < vehiculoActual.getAlquileres().size(); i++) {
        // // queremos devolver un vehiculo
        // // sabiendo el vehiculo que queremos devolver prodriamos devolverlo.
        // if (vehiculoActual.getAlquileres().get(i).isAlquilado() == true) {
        // } else {
        // System.out.println("El alquiler esta devuelto");
        // }
        // }
        // return false;
    }

    /**
     * 
     * @return la lista de los alquileres disponibles que hay.
     */
    public List<Alquiler> mostrarAlquileres() {
        // Creamos una lista nueva;
        Set<Alquiler> alquilerSet = new HashSet<Alquiler>();
        List<Alquiler> lista = new ArrayList<>();
        // cogeriamos todos los vehiculos en la lista de vehiculos para obtener los
        // alquileres de los mismos vehiculos;

        for (int i = 0; i < listaVehiculos.size(); i++) {
            // entramos por cada clase que encontramos de los vehiculos y recorremos sus
            // listas de alquileres asi que cogemos el numero de alquileres que hay en
            // total.
            for (int j = 0; j < listaVehiculos.get(i).getAlquileres().size(); j++) {
                // cogemos los alquileres actuales
                alquilerActual = listaVehiculos.get(i).getAlquileres().get(j);
                if (alquilerActual.isAlquilado()) {
                    alquilerSet.add(alquilerActual);
                }
            }
        }
        for (Alquiler alquiler : alquilerSet) {
            lista.add(alquiler);
        }

        return lista;
    }

    // public boolean alquilarVehiculo() {
    // // GregorianCalendar fechaAlquiler = new GregorianCalendar();
    // Date fechaAlquiler = new Date();

    // if (getConductorActual().vehiculoActual.getAlquileres()
    // .add(new Alquiler(fechaAlquiler, conductorActual, vehiculoActual, null,
    // 0))) {
    // return true;
    // }
    // return false;
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
