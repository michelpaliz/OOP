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

    public static  LocalDate fechaFabricacion(int day, int month, int year) {
        day = fechaFabricacion.get(Calendar.DAY_OF_MONTH);
        month = fechaFabricacion.get(Calendar.MONTH);
        year = fechaFabricacion.get(Calendar.YEAR);
        LocalDate fecha;
        fecha = LocalDate.of(day, month, year);
        return fecha;
    }

    @Override
    public String toString() {
        return "Bicicleta [dimensionRuedas=" + dimensionRuedas + ", fechaFabricacion=" + fechaFabricacion + ", marca="
                + marca + ", motor=" + motor + ", numeroExistencias=" + numeroExistencias + ", peso=" + peso
                + ", precio=" + precio + ", referencia=" + referencia + "]";
    }

}
