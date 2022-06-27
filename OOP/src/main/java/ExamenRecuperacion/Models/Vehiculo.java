package ExamenRecuperacion.Models;

import ExamenRecuperacion.numeric.NCombustible;

public abstract class Vehiculo {
    private static int cont = 1;
    private String matricula;
    private String marca;
    private String modelo;
    private double precioAlquilerDiario;
    private double precioKmRealizado;
    private NCombustible tipoCombustible;
    

}
