package Tema10.Ejercicios.Propios.Ejercicio2;

import java.util.ArrayList;

public class ArrayLisEstadisticas implements IEstadisticas {
    private ArrayList<Double> data;

    // creamos el constructor para el array list
    public ArrayLisEstadisticas(int initialCapacity) {
        data = new ArrayList<>(initialCapacity);
    }

    // Este metodo solo lo puede gestionar el arrayListEstadisticas
    // public ArrayList<Double> getData(){
    // return data;
    // }

    public boolean add(double element) throws UnsupportedOperationException, ClassCastException, NullPointer {
        return data.add(element);

    }

    public boolean get(int index) {
        return data.get(index);
    }

    @Override
    public double minimo() throws NullPointerException {
        if (data == null) {
            throw new NullPointerException("El arraylist esta vacio");
        }
        if (data != null) {
            double min = data.get(0);
            for (int i = 1; i < data.size(); i++) {
                if (data.get(i) < min) {
                    min = data.get(i);
                }
            }
            return min;
        }

    }

    @Override
    public double maximo() throws NullPointerException {
        if (data == null) {
            throw new NullPointerException("El arraylist esta vacio");
        }
        if (data != null) {
            double max = data.get(0);
            for (int i = 1; i < data.size(); i++) {
                if (data.get(i) < max) {
                    max = data.get(i);
                }
            }
            return max;
        }
    }

    @Override
    public double sumatorio() {
        if(){
            
        }
        
    }

    @Override
    public double media() {
        return sumatorio() / data.size();
    }

    @Override
    public double moda() throws NullPointerException {
        if (data == null) {
            throw new NullPointerException("El arraylist esta vacio");
        }
        double value = data.get(0);// numero glabal
        int rep = 0; // numero de rep gloables

        if (data != null) {
            for (int i = 1; i < data.size(); i++) {
                double currentValue = data.get(i); // obtengo el valor actual
                int currentRep = 1;// obtengo numero de repenticiones local/actual
                for (int j = i; j < data.size(); j++) {
                    if (currentValue == data.get(j)) {
                        currentRep++;
                    }
                }
                if (currentRep > rep) {
                    rep = currentRep;
                    value = currentValue;
                }
            }
            return value;
        }
    }

}
