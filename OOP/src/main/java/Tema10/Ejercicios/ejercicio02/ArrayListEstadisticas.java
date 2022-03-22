package Tema10.Ejercicios.ejercicio02;

import java.util.ArrayList;

public class ArrayListEstadisticas extends ArrayList<Double> implements IEstadisticas {
    private ArrayList<Double> data;

    // Constructor
    // public ArrayListEstadisticas(int initialCapacity) {
    // data = new ArrayList<>(initialCapacity);
    // }

    public ArrayListEstadisticas(){
        super();
    }

    public ArrayListEstadisticas(int initialCapacity){
        super(initialCapacity);
    }

    public ArrayListeEstaditicas(Collection<Double>){

    }


    /*
     * Esto huele.
     * En la próxima sesión veremos como solucionar el problema de tener que volver
     * a implementar la mayoría de los métodos de la clase ArrayList para que la
     * clase
     * ArrayListEstadisticas sea útil.
     * 
     * public boolean add(double element) throws UnsupportedOperationException,
     * ClassCastException, NullPointerException, IllegalFormatException {
     * return data.add(element);
     * }
     * 
     * public double get(int index) {
     * return data.get(index);
     * }
     */

    @Override
    public double minimo() throws NullPointerException {
        if (this == null)
            throw new NullPointerException("El ArrayList está vacío");
        double min = get(0);
        for (int i = 1; i < size(); i++) {
            if (get(i) < min)
                min = get(i);
        }
        return min;
    }

    @Override
    public double maximo() throws NullPointerException {
        if (this == null)
            throw new NullPointerException("El ArrayList está vacío");
        double max = get(0);
        for (int i = 1; i < size(); i++) {
            if (get(i) > max)
                max = get(i);
        }
        return max;
    }

    @Override
    public double sumatorio() throws NullPointerException {
        if (this == null)
            throw new NullPointerException("El ArrayList está vacío");
        double sum = 0;
        for (int i = 0; i < size(); i++) {
            sum += get(i);
        }
        return sum;
    }

    @Override
    public double media() throws NullPointerException {
        return sumatorio() / data.size();
    }

    @Override
    public double moda() throws NullPointerException {
        if (this == null)
            throw new NullPointerException("El ArrayList está vacío");
        double value = get(0);
        int reps = 0;

        for (int i = 0; i < size(); i++) {
            double currentValue = get(i);
            int currentReps = 1;
            for (int j = i; j < size(); j++) {
                if (currentValue == get(j))
                    currentReps++;
            }
            if (currentReps > reps) {
                reps = currentReps;
                value = currentValue;
            }
        }
        return value;
    }
}
