package ExamenRecuperacion.Models;

import ExamenRecuperacion.numeric.NCombustible;

public class Autocaravana extends Vehiculo {
    private boolean placasSolar;

    public Autocaravana(String marca, String modelo, double precioAlquilerDiario,
            double precioKmRealizado, NCombustible tipoCombustible, boolean placasSolar) {
        super(marca, modelo, precioAlquilerDiario, precioKmRealizado, tipoCombustible);
        this.placasSolar = placasSolar;
    }

    public boolean isPlacasSolar() {
        return placasSolar;
    }

    @Override
    public String toString() {
        return "Autocaravana{" +
                "placasSolar=" + placasSolar + super.toString() +
                '}';
    }

    @Override
    public double suplemento() {
        double precio = super.getPrecioAlquilerDiario();
        if (placasSolar == true) {
            precio += 12;
        } else {
            precio = 0;
        }
        return precio;
    }

    @Override
    public double descuento(Conductor conductor) {
        double precio = super.getPrecioAlquilerDiario();
        if (conductor.getFechaExperiencia() > 15) {
            precio -= 15;
        }
        return precio;
    }

}
