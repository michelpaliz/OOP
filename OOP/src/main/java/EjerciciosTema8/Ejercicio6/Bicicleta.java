package EjerciciosTema8.Ejercicio6;

import java.time.LocalDate;
import java.util.GregorianCalendar;

public class Bicicleta {
    private int referencia;
    private String marca;
    private double peso;
    private double dimensionRuedas;
    private boolean motor;
    private LocalDate fechaFabricacion;
    private double precio;
    private int numeroExistencias;

    public Bicicleta(int referencia, String marca, double peso, double dimensionRuedas, boolean motor,
            int anyo, int mes, int dia, double precio, int numeroExistencias) {
        this.referencia = referencia;
        this.marca = marca;
        this.peso = peso;
        this.dimensionRuedas = dimensionRuedas;
        this.motor = motor;
        this.fechaFabricacion = LocalDate.of(anyo, mes, dia);
        this.precio = precio;
        this.numeroExistencias = numeroExistencias;
    }

    @Override
    public String toString() {
        return "Bicicleta [dimensionRuedas=" + dimensionRuedas + ", fechaFabricacion=" + fechaFabricacion + ", marca="
                + marca + ", motor=" + motor + ", numeroExistencias=" + numeroExistencias + ", peso=" + peso
                + ", precio=" + precio + ", referencia=" + referencia + "]";
    }

}
