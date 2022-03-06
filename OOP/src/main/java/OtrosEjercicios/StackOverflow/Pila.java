package OtrosEjercicios.StackOverflow;

import java.util.Scanner;
import java.util.Stack;

public class Pila {

    Scanner myInput = new Scanner(System.in);
    Stack pila = new Stack();
    public static int size;

    public void size() {
        System.out.println("Ingrese la cantidad de datos ");
        size = myInput.nextInt();
        System.out.println("*************");
    }

    public void add() {
        System.out.println("Metodo ADD");
        while (pila.size() < size) {
            System.out.println("Ingrese el dato");
            String userStr = myInput.next();
            pila.add(userStr);
        }
        System.out.println("**************");
        System.out.println("Vamos a mostrar la pila");
        System.out.println(pila);
    }

    public void push() {
        System.out.println("Metodo PUSH");
        while (pila.size() < size) {
            String a = null;
            System.out.println("Ingrese el dato");
            pila.push(a = myInput.next());
        }
        System.out.println(pila);
    }

    public void contains() {
        System.out.println("Ingrese el dato a validar");
        Object a = pila.contains(myInput.next());
        System.out.println(a);
    }

    public void lastElement() {
        Object a = pila.lastElement();
        System.out.println("This is the last element " + a);
    }

    public void pop() {
        System.out.println("Vamos a elimnar el ultimo elemento de la pila");
        Object a = pila.pop();
        System.out.println(a);
        System.out.println(pila);
    }

    public void popOneElement() {
        System.out.println("Vamos a elimnar el ultimo elemento de la pila");
        System.out.println("Indica el indice del elemento que deseas eliminar");
        int userInt = myInput.nextInt();
        Object a = pila.remove(userInt);
        System.out.println(pila);
    }

    public void empty() {
        System.out.println("Vamos a vaciar la pila");
        pila.removeAllElements();
        System.out.println(pila);
    }

}
