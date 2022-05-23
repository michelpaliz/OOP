package Tema08.EjemplosTema8.Tema8Adv.Cajero;

import java.util.Random;

import Tema08.EjemplosTema8.Cajero.config.Config;

public class Cuenta {
    private final String numero;
    private final String propietario;
    private double saldo;
    private Tarjeta tarjeta;

    public Cuenta(String numero, String propietario) {
        this.numero = numero;
        this.propietario = propietario;
        // Las siguientes asignaciones no son necesarias en Java
        saldo = 0;
        tarjeta = null;
    }

    public Tarjeta crearTarjeta(String codigoBanco, int numeroSegmentoPropietario) {
        if(tarjeta == null) {
            Random r = new Random();
            tarjeta = new Tarjeta(
                    "0" + codigoBanco + String.format("%09d", numeroSegmentoPropietario),
                    String.valueOf(r.nextInt(Config.MAX_NUMERO_TARJETA - Config.MIN_NUMERO_TARJETA + 1) + Config.MIN_NUMERO_TARJETA),
                    String.valueOf(r.nextInt(Config.MAX_CODIGO_SEGURIDAD - Config.MIN_CODIGO_SEGURIDAD + 1) + Config.MIN_CODIGO_SEGURIDAD));
            return tarjeta;
        }
        return null;
    }

    public boolean ingresar(double cantidad) {
        if(cantidad > 0) {
            saldo += cantidad;
            return true;
        }
        return false;
    }

    public double retirar(double cantidad) {
        if(cantidad > 0 && saldo >= cantidad) {
            saldo -= cantidad;
            return cantidad;
        }
        return 0;
    }

    public double getSaldo() {
        return saldo;
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "numero='" + numero + '\'' +
                ", propietario='" + propietario + '\'' +
                ", saldo=" + saldo +
                ", tarjeta=" + tarjeta +
                '}';
    }


}
