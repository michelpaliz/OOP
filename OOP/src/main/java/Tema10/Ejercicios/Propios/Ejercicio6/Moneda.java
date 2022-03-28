package Tema10.Ejercicios.Propios.Ejercicio6;

import java.util.HashMap;

public class Moneda implements IMoneda {

    private HashMap<Double, Double> cambio;

    public Moneda() {
        this(10);
    }

    public Moneda(int initialSize) {
        cambio = new HashMap<>(initialSize);
    }

    @Override
    public double monedas(double monedaLocal, double diferenciaExtr) {
        if (!moneda(monedaLocal)) {
            return cambioMoneda(monedaLocal, diferenciaExtr);
        }
        return 0;
    }

    private boolean moneda(double moneda) {
        return cambio.get(moneda) == null;
    }

    private double cambioMoneda(double monedaLocal, double diferenciaExtr) {
        return monedaLocal * diferenciaExtr;

    }

}
