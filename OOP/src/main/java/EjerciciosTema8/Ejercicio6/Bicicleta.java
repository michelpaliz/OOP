package EjerciciosTema8.Ejercicio6;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import org.yaml.snakeyaml.LoaderOptions;

public class Bicicleta {
    private final String referencia;
    private final String marca;
    private final double peso;
    private final double dimensionRuedas;
    private final String  motor;
    private final GregorianCalendar fechaFabricacion;
    private final double precio;
    private final int numeroExistencias;

    public Bicicleta(String referencia, String marca, double peso, double dimensionRuedas, String  motor,
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

    public String  isMotor() {
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

    public static  GregorianCalendar fechaFabricacion(int day, int month, int year) {
        day = (Calendar.DAY_OF_MONTH);
        month = (Calendar.MONTH);
        year = (Calendar.YEAR);
//        LocalDate fecha;
//        fecha = LocalDate.of(day, month, year);
        return fechaFabricacion(day,month,year);


    }
    @Override
    public String toString() {
        return "Bicicleta{" +
                "referencia='" + referencia + '\'' +
                ", marca='" + marca + '\'' +
                ", peso=" + peso +
                ", dimensionRuedas=" + dimensionRuedas +
                ", motor='" + motor + '\'' +
                ", fechaFabricacion=" + fechaFabricacion +
                ", precio=" + precio +
                ", numeroExistencias=" + numeroExistencias +
                '}';
    }
}
