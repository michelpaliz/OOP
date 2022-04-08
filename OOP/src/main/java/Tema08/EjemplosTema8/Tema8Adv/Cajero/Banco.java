package Tema08.EjemplosTema8.Tema8Adv.Cajero;

// import Tema8.EjemplosTema8.Cajero.util.Bombo;
import Te

import java.util.Random;

public class Banco {
    private final String codigo;
    private final String nombre;
    private Cuenta[] cuentas;

    public Banco(String codigo, String nombre) {
        this(codigo, nombre, null);
    }

    public Banco(String codigo, String nombre, Bombo bombo) {
        this.codigo = codigo;
        this.nombre = nombre;
        if (Config.DEBUG && bombo != null) {
            crearDatosPrueba(bombo);
        }
    }

    private void crearDatosPrueba(Bombo bombo) {
        cuentas = new Cuenta[Config.CANTIDAD_CUENTAS];
        Random r = new Random();
        for(int i = 0; i < cuentas.length; i++) {
            cuentas[i] = new Cuenta(
                    String.valueOf(r.nextInt(Config.CUENTA_MAX_NUMERO - Config.CUENTA_MIN_NUMERO + 1) + Config.CUENTA_MIN_NUMERO),
                    "Propietario " + (i+1));
            cuentas[i].crearTarjeta(codigo, bombo.extraerBola());
        }
        for(Cuenta cuenta: cuentas) {
            System.out.println(cuenta.getTarjeta());
        }
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public Cuenta getCuenta(String numTarjeta) {
        for(Cuenta cuenta: cuentas) {
            if (cuenta.getTarjeta().getNumero().equals(numTarjeta))
                return cuenta;
        }
        return null;
    }

    public boolean validarCredenciales(String numTarjeta, String pin) {
        Cuenta cuenta = getCuenta(numTarjeta);
        if(cuenta != null) {
            return cuenta.getTarjeta().getNumero().equals(numTarjeta) &&
                    cuenta.getTarjeta().getPin().equals(pin);
        }
        return false;
    }

    public boolean ingresar(String numTarjeta, double cantidad) {
        Cuenta cuenta = getCuenta(numTarjeta);
        if(cuenta != null)
            return cuenta.ingresar(cantidad);
        return false;
    }

    public double retirar(String numTarjeta, double cantidad) {
        Cuenta cuenta = getCuenta(numTarjeta);
        if(cuenta != null)
            return cuenta.retirar(cantidad);
        return -1;
    }

    public double consultarSaldo(String numTarjeta) {
        Cuenta cuenta = getCuenta(numTarjeta);
        if(cuenta != null)
            return cuenta.getSaldo();
        return Long.MIN_VALUE;
    }

    public String cambiarPin(String numTarjeta, String oldPin, String newPin) {
        Cuenta cuenta = getCuenta(numTarjeta);
        if(cuenta != null) {
            Tarjeta tarjeta = cuenta.getTarjeta();
            return tarjeta.cambiarPin(oldPin, newPin);
        }
        return oldPin;
    }
}
