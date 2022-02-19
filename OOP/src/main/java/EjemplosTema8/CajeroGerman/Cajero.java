package EjemplosTema8.CajeroGerman;

//import EjemplosTema8.Cajero.Tarjeta;
//import EjemplosTema8.CajeroGerman.Tarjeta.Tarjeta;

import java.util.Random;

public class Cajero {

    private static final int MIN_NUMERO = 1000;
    private static final int MAX_NUMERO = 9999;
    private static final int CANTIDAD_CUENTAS = 10;


    public Cajero() {
//                Cuenta cuenta = new Cuenta();
    Cuenta cuenta1 = new Cuenta("1234", "michael");
        //Array
        Cuenta[] cuentas = new Cuenta[CANTIDAD_CUENTAS]; //Se crean 10 posiciiones de memoria que apuntan a NULL
        Random r = new Random();

        for (int i = 0; i < cuentas.length; i++) {
            cuentas[i] = new Cuenta(
//                                String.valueOf(r.nextInt(MAX_NUMERO-MIN_NUMERO+1)+MIN_NUMERO,"Propietario" + (i+1));
                    String.valueOf(r.nextInt(MAX_NUMERO - MIN_NUMERO + 1) + MIN_NUMERO), "Propietario" + (i + 1));

            Tarjeta tarjeta = new Tarjeta("d", "da", "ar");
            cuentas[i].crearTarjeta();//metodo crear cuenta
        }

        for (Cuenta cuenta : cuentas) {
            System.out.println(cuenta.toString());
        }

        //sin constructor en este ejemplo
        System.out.println("sin constructor en este ejmplo" + cuenta1.toString());

    }

}
