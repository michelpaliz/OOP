package Examen.Models;

public class MuebleClasico extends Mueble {

    private double peso;
    private String tipoMadera;

    public MuebleClasico(String nombre, double precio, double alto, double ancho, double profundo, int stock,
            double peso,
            String tipoMadera) {
        super(nombre, precio, alto, ancho, profundo, stock);
        this.peso = peso;
        this.tipoMadera = tipoMadera;
    }

    public double getPeso() {
        return peso;
    }
    
    public String getTipoMadera() {
        return tipoMadera;
    }

    @Override
    public String toString() {
        return "MuebleClasico{" +
                "peso=" + peso +
                ", tipoMadera='" + tipoMadera + '\'' + super.toString() +
                '}';
    }

    @Override
    public double importeEnvio(double km) {
        return 0.10 * peso * km + 30;
    }
}
