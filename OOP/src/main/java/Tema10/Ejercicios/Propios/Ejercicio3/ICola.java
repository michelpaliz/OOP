package Tema10.Ejercicios.Propios.Ejercicio3;

public interface ICola<T> {

    T push(T e);

    T size();

    T pop();

    T isFull();

    T isEmpty();

}
