package EjerciciosTema8.Ejercicio6;

import java.util.GregorianCalendar;

public class Bicicleta {
    private final String referencia;
    private final String marca;
    private final double peso;
    private final double dimensionRuedas;
    private final boolean motor;
    private final GregorianCalendar fechaFabricacion;
    private final double precio;
    private final int numeroExistencias;

    public Bicicleta(String referencia, String marca, double peso, double dimensionRuedas, boolean motor,
            GregorianCalendar fechaFabricacion, double precio, int numeroExistencias) {
        this.referencia = referencia;
        this.marca = marca;
        this.peso = peso;
        this.dimensionRuedas = dimensionRuedas;
        this.motor = motor;
        this.fechaFabricacion = fechaFabricacion;
        this.precio = precio;
        this.numeroExistencias = numeroExistencias;
    }

    public String getReferencia() {
        return referencia;
    }

    public String getMarca() {
        return marca;
    }

    public double getPeso() {
        return peso;
    }

    public double getDimensionRuedas() {
        return dimensionRuedas;
    }

    public boolean isMotor() {
        return motor;
    }

    public GregorianCalendar getFechaFabricacion() {
        return fechaFabricacion;
    }

    public double getPrecio() {
        return precio;
    }

    public int getNumeroExistencias() {
        return numeroExistencias;
    }

    @Override
    public String toString() {
        return "Bicicleta [dimensionRuedas=" + dimensionRuedas + ", fechaFabricacion=" + fechaFabricacion + ", marca="
                + marca + ", motor=" + motor + ", numeroExistencias=" + numeroExistencias + ", peso=" + peso
                + ", precio=" + precio + ", referencia=" + referencia + "]";
    }

}
