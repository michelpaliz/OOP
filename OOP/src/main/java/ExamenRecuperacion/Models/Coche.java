package ExamenRecuperacion.Models;

import ExamenRecuperacion.numeric.NCombustible;

public class Coche extends Vehiculo {
    private int numPlazas;

    public Coche(String marca, String modelo, double precioAlquilerDiario, double precioKmRealizado,
            NCombustible tipoCombustible, int numPlazas) {
        super(marca, modelo, precioAlquilerDiario, precioKmRealizado, tipoCombustible);
        this.numPlazas = numPlazas;
    }

    @Override
    public String toString() {
        return "Coche{" +
                "numPlazas=" + numPlazas + super.toString() +
                '}';
    }

    @Override
    public double suplemento() {
        double precio = super.getPrecioAlquilerDiario();
        if (numPlazas > 5) {
            precio += 7;
        } else {
            precio = 0;
        }
        return precio;
    }

    @Override
    public double descuento(Conductor conductor) {
        double precio = super.getPrecioAlquilerDiario();
        if (conductor.getEdad() > 25) {
            precio -= 25;
        }
        return precio;
    }

}
