package ExamenRecuperacion.Out;

import java.util.List;

import com.github.javafaker.Faker;

import ExamenRecuperacion.Models.Conductor;
import ExamenRecuperacion.Models.Vehiculo;

public class Inventario {
    private static Faker fk = new Faker();
    private final int MAX_CONDUCTORES = 3;
    private final int MAX_VEHICULOS = 10;
    private List<Conductor> listaConductores;
    private List<Vehiculo> listaVehiculos;
    private Conductor conductorActual;
    private Vehiculo vehiculoActual;

    public Inventario() {

    }

    public void randomVehiculos() {

    }

}
