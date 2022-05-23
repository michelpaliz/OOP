package Tema10.Ejercicios.Propios.Ejercicio7;

import java.util.HashMap;

import Tema10.Ejercicios.Propios.Ejercicio2.ArrayLisEstadisticas;

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

    double cambioMoneda(double monedaLocal, double diferenciaExtr) {
        double cambio, resultado;
        cambio = monedaLocal * diferenciaExtr;;
        return resultado =  cambio + monedaLocal;
    }

    public Arraylist<String> getMonedas(){
        return new ArrayLis();
    }

    public set<Map.Entry<String, double>> getEntrySet(){
        
    }



}
