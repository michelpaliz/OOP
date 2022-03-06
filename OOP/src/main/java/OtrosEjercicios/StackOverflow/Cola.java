package OtrosEjercicios.StackOverflow;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Cola {

    // FIFO
    Scanner myInput = new Scanner(System.in);
    int userInt, size;
    LinkedList cola = new LinkedList();

    /**
     * Indica el size de la cola
     */

    public void size() {
        System.out.println("Ingrese la cantidad de datos ");
        size = myInput.nextInt();
        System.out.println("*************");
    }

    /**
     * 
     * @return el lenght de la lista
     */

    public int showSize() {
        System.out.println("Aqui esta el tamanyo de la cola");
        userInt = cola.size();
        return userInt;
    }

    /**
     * Encolar se anyade un elemento a la cola, al final de esta
     * 
     * @param a
     */
    public void encolar() {
        while (cola.size() < size) {
            System.out.println("Inserta el elemento que quieres encolar (anaydir)");
            userInt = myInput.nextInt();
            cola.addFirst(userInt);
        }
        System.out.println("Vamos a mostrar la cola");
        System.out.println(cola);
    }

    // public void add() {
    // System.out.println("Metodo ADD");
    // while (cola.size() < size) {
    // System.out.println("Ingrese el dato");
    // String userStr = myInput.next();
    // cola.add(userStr);
    // }
    // System.out.println("**************");
    // System.out.println("Vamos a mostrar la pila");
    // System.out.println(cola);
    // }

    /**
     * Desconlar elimina el elemenoto frontral de la cola, es decir el primer
     * elemento que entro
     * 
     * @return
     */
    public int desencolar() {
        System.out.println("Eliminar el ultimo elemento de la cola (FIFO)");
        return (int) cola.removeLast();
    }

    public void removeElement() {
        System.out.println("Elimina el elemento que deseas, introduce el indice");
        userInt = myInput.nextInt();
        cola.remove(userInt);
        mostrar();
    }

    /**
     * Consultar el elemento frontal de la cola es decir el primer elemento que
     * entro
     * 
     * @return
     */

    public int showFirstElement() {
        System.out.println("Muestra el primer elemento de la cola");
        return (int) cola.peekFirst();
    }

    public void mostrar() {
        System.out.println("Muestra toda la cola");
        System.out.println(cola);
    }

    /**
     * Ordenar la lista de menor a mayor
     */

    public void ordenar() {
        System.out.println("Ordena la cola");
        Collections.sort(cola);
    }

    /**
     * Eliminar todos los elementos de la cola
     */
    public void removeQueue() {
        System.out.println("Elimar toda los elementos de la lista");
        cola.clear();
    }

}
