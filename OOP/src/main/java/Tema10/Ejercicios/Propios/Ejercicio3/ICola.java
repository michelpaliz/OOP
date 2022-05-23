package Tema10.Ejercicios.Propios.Ejercicio3;

public interface ICola<T> {

    boolean push(T e);

    T remove();

    int size();

    T peek();

    boolean isEmpty();

}
