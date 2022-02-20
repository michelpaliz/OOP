package EjerciciosTema8.Ejercicio6;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import com.github.javafaker.DateAndTime;

public class Bicicleta {
    private final int referencia;
    private final String marca;
    private final double peso;
    private final double dimensionRuedas;
    private final boolean motor;
    private final GregorianCalendar fechaFabricacion;
    private final double precio;
    private final int numeroExistencias;

    public Bicicleta(int referencia, String marca, double peso, double dimensionRuedas, boolean motor,
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

    public int getReferencia() {
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
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return "Bicicleta{" +
                "referencia='" + referencia + '\'' +
                ", marca='" + marca + '\'' +
                ", peso=" + peso +
                ", dimensionRuedas=" + dimensionRuedas +
                ", motor='" + motor + '\'' +
                ", fechaFabricacion=" + sdf.format(fechaFabricacion) +
                ", precio=" + precio +
                ", numeroExistencias=" + numeroExistencias +
                '}';
    }
}
