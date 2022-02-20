package EjerciciosTema8.Ejercicio6;

//*IMPORT DATE PACKAGES
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Bicicleta {
    private final int referencia;
    private final String marca;
    private final double peso;
    private final double dimensionRuedas;
    private final String motor;
    private final GregorianCalendar fechaFabricacion;
    private final double precio;
    private final int numeroExistencias;

    public Bicicleta(int referencia, String marca, double peso, double dimensionRuedas, String motor,
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

    public String isMotor() {
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
                ", fechaFabricacion=" + sdf.format(fechaFabricacion.getTime()) +
                ", precio=" + precio +
                ", numeroExistencias=" + numeroExistencias +
                '}';
    }
}
