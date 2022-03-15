package Tema8.EjemplosTema8.CajeroGerman;


import java.util.Random;

public class Cuenta {
    private static final int MAX_NUMERO_TARJETA = 1000;
    private static final int MIN_NUMERO_TARJETA = 9999;
    private static final int MAX_CODIGO = 100;
    private static final int MIN_CODIGO = 0;
    private String numero;
    private String propietario;
    private double saldo;
    private Tarjeta tarjeta;//primero lo vamos a hacer con una opcion

    //Metodo de creacion de cuentas;
    public Cuenta(String numero, String propietario) {
        this.numero = numero;
        this.propietario = propietario;
        //no son necesariosas en java
        saldo = 0; //se puede poner el this pero no es necesario
        tarjeta = null;
    }

    //**METODOS**/

    @Override
    public String toString() {
        return "Cuenta{" +
                "numero='" + numero + '\'' +
                ", propietario='" + propietario + '\'' +
                ", saldo=" + saldo +
                ", tarjeta=" + tarjeta +
                '}';
    }

    public Tarjeta crearTarjeta() {
        Random r = new Random();
        if (tarjeta == null) {
            tarjeta = new Tarjeta(
                    String.valueOf(r.nextInt(MAX_NUMERO_TARJETA - MIN_NUMERO_TARJETA + 1) + MIN_NUMERO_TARJETA),
                    String.valueOf(r.nextInt(MAX_NUMERO_TARJETA - MIN_NUMERO_TARJETA + 1) + MIN_NUMERO_TARJETA),
                    String.valueOf(r.nextInt(MAX_CODIGO - MIN_CODIGO + 1) + MIN_CODIGO));
            return tarjeta;
        }
        return null;
    }


}
