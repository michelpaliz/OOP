package EjemplosTema8.CajeroGerman;

import java.util.TreeMap;

public class Tarjeta {
    private String numero; //021 el cero no se podria almacenar no lo tomaria en cuenta
    private String pin;
    private String codigoSeguridad;


    //Constructor recive todo
    public Tarjeta(String numero, String pin, String codigoSeguridad) {
        this.numero = numero;
        this.pin = pin;
        this.codigoSeguridad = codigoSeguridad;
    }

    //Generamos los getters
    public String getNumero() {
        return numero;
    }

    public String getPin() {
        return pin;
    }

    public String getCodigoSeguridad() {
        return codigoSeguridad;
    }

    //Crear tarjerta metodo pueder ser void o tarjeta


    @Override
    public String toString() {
        return "Tarjeta{" +
                "numero='" + numero + '\'' +
                ", pin='" + pin + '\'' +
                ", codigoSeguridad='" + codigoSeguridad + '\'' +
                '}';
    }
}
