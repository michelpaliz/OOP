package Tema08.EjemplosTema8.Tema8Adv.Cajero;

import Tema08.EjemplosTema8.Cajero.config.Config;

public class Tarjeta {
    private final String numero;
    private String pin;
    private final String codigoSeguridad;

    public Tarjeta(String numero, String pin, String codigoSeguridad) {
        this.numero = numero;
        this.pin = pin;
        this.codigoSeguridad = codigoSeguridad;
    }

    public String getNumero() {
        return numero;
    }

    public String getPin() {
        return pin;
    }

    public String cambiarPin(String oldPin, String newPin) {
        if (pin.equals(oldPin) && newPin.length() >= Config.MIN_LONGITUD_PIN) {
            pin = newPin;
            return newPin;
        }
        return oldPin;
    }

    public String getCodigoSeguridad() {
        return codigoSeguridad;
    }

    @Override
    public String toString() {
        return "Tarjeta{" +
                "numero='" + numero + '\'' +
                ", pin='" + pin + '\'' +
                ", codigoSeguridad='" + codigoSeguridad + '\'' +
                '}';
    }
}
